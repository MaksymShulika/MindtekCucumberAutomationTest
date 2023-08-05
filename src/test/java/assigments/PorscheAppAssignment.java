package assigments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PorscheAppMainPage;
import pages.PorscheCaymanPage;
import utillities.ConfigReader;
import utillities.Driver;

public class PorscheAppAssignment {

    WebDriver driver = Driver.getDriver();
    PorscheAppMainPage porscheAppMainPage = new PorscheAppMainPage();
    PorscheCaymanPage porscheCaymanPage = new PorscheCaymanPage();

    @Given("user navigates to Porsche Car application")
    public void user_navigates_to_porsche_car_application() {
        driver.get(ConfigReader.getProperty("PorscheCarConfigurationURL"));
    }

    @When("user stores the price and selects the model {int} Cayman")
    public void user_stores_the_price_and_selects_the_model_cayman(Integer model) {
        porscheAppMainPage.priceOfCaymanAndBtn.click();
    }

    @Then("user validates Base price is matched with listed price")
    public void user_validates_base_price_is_matched_with_listed_price() {
        double expectedPrice = Double.parseDouble((porscheAppMainPage.priceOfCaymanAndBtn.getText()).replace(",", "."));
        double actualPrice = Double.parseDouble((porscheCaymanPage.caymanBasePrice.getText()).replace(",", "."));
        Assert.assertEquals(expectedPrice, actualPrice, 0.0);
    }




}
