package steps;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersPage;
import utillities.BrowserUtils;
import utillities.ConfigReader;
import utillities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebOrdersSteps {

    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    WebOrdersPage webOrdersPage = new WebOrdersPage();
    List<Map<String,Object>> data = new ArrayList<>();

    @Given("User navigates to application")
    public void user_navigates_to_application() {
        driver.get(ConfigReader.getProperty("WebOrdersURL"));
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String userName, String password) {
        webOrdersLoginPage.userNameInput.sendKeys(userName);
        webOrdersLoginPage.passwordInput.sendKeys(password);
        webOrdersLoginPage.loginBtn.click();
    }


    @Then("User is successfully logged in and lands on the homepage")
    public void user_is_successfully_logged_in_and_lands_on_the_homepage() {
        Assert.assertEquals("Web Orders", driver.getTitle());
    }

    @Then("User is validates error message {string}")
    public void user_is_validates_error_message(String invalidCredentialsMessage) {
        Assert.assertEquals(invalidCredentialsMessage, webOrdersLoginPage.errorMessage.getText());
    }


    @When("User clicks on Orders tab")
    public void user_clicks_on_orders_tab() {
       webOrdersHomePage.orderTab.click();
    }

    @When("User selects product {string} and enters quantity {int}")
    public void user_selects_product_and_enters_quantity(String product, Integer quantity) {
        BrowserUtils.selectDropdownByValue(webOrdersPage.dropDown, product);
        webOrdersPage.quantity.sendKeys(Keys.BACK_SPACE+quantity.toString());
        webOrdersPage.calculateBtn.click();
    }
    @Then("User validates the price is correctly calculated for {int}")
    public void user_validates_the_price_is_correctly_calculated_for(Integer quantity) {

        int pricePerUnit = Integer.parseInt(webOrdersPage.pricePerUnit.getAttribute("value"));
        int discount = Integer.parseInt(webOrdersPage.discount.getAttribute("value"));
        int total = Integer.parseInt(webOrdersPage.total.getAttribute("value"));

        Assert.assertEquals(total, (pricePerUnit = pricePerUnit * quantity * (100 - discount)/100));

    }

    @When("User creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {

        data = dataTable.asMaps(String.class, Object.class);

        for (int i = 0; i < data.size(); i++){
            BrowserUtils.selectDropdownByValue(webOrdersPage.dropDown, data.get(i).get("PRODUCT").toString());

            webOrdersPage.quantity.sendKeys(Keys.BACK_SPACE+data.get(i).get("QUANTITY").toString());
            webOrdersPage.inputCustomerName.sendKeys(data.get(i).get("CUSTOMER NAME").toString());
            webOrdersPage.inputStreet.sendKeys(data.get(i).get("STREET").toString());
            webOrdersPage.inputCity.sendKeys(data.get(i).get("CITY").toString());
            webOrdersPage.inputState.sendKeys(data.get(i).get("STATE").toString());
            webOrdersPage.inputZip.sendKeys(data.get(i).get("ZIP").toString());
            webOrdersPage.inputCardTypeVisa.click();
            webOrdersPage.inputCardNr.sendKeys(data.get(i).get("CARD NUM").toString());
            webOrdersPage.inputExpireDate.sendKeys(data.get(i).get("EXP DATE").toString());
            webOrdersPage.processBtn.click();
            user_validates_success_message("New order has been successfully added.");
        }
    }

    @Then("User validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, webOrdersPage.correctMessage.getText());                                                                                                                                                                                 
    }

    @Then("User validates created order is in the list of all Orders")
    public void user_validates_created_order_is_in_the_list_of_all_orders() {
        webOrdersHomePage.viewAllOrdersTab.click();
        System.out.println(webOrdersHomePage.firstRowOrder.get(1).getText());
        BrowserUtils.waitForElementVisibilityOf(webOrdersHomePage.firstRowOrder.get(1));
        Assert.assertEquals(data.get(0).get("CUSTOMER NAME").toString(),
                webOrdersHomePage.firstRowOrder.get(1).getText());
    }


}
