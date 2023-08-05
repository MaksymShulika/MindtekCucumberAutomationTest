package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ElarLogisticHomePage;
import pages.ElarLogisticLoginPage;
import pages.ElarLogisticsAddCompPage;
import pages.ElarLogisticsListOfCompPage;
import utillities.BrowserUtils;
import utillities.ConfigReader;
import utillities.Driver;


import java.util.*;

public class ElarLogisticAppSteps {
    WebDriver driver= Driver.getDriver();
    ElarLogisticLoginPage elarLogisticLoginPage = new ElarLogisticLoginPage();
    ElarLogisticHomePage elarLogisticHomePage = new ElarLogisticHomePage();
    ElarLogisticsListOfCompPage elarLogisticsListOfCompPage = new ElarLogisticsListOfCompPage();
    ElarLogisticsAddCompPage elarLogisticsAddCompPage = new ElarLogisticsAddCompPage();
    List<Map<String,Object>> data = new ArrayList<>();




//
//    @Then("User clicks on Log in button")
//    public void user_clicks_on_log_in_button() {
//        elarLogisticLoginPage.LogInButton.click();
//    }
//
//    @Then("User clicks on Company button")
//    public void user_clicks_on_company_button() {
//        elarLogisticHomePage.companyButton.click();
//    }
//
//    @Then("User clicks on Search button")
//    public void user_clicks_on_search_button() {
//        elarLogisticsListOfCompPage.searchButton.click();
//
//    }
//    @Then("User validates the search engine appear")
//    public void user_validates_the_search_engine_appear() {
//        Assert.assertTrue("Search engine is not appearing",elarLogisticsListOfCompPage.searchEngine.isEnabled());
//    }
//
//    @Then("User clicks on Add Company button")
//    public void user_clicks_on_add_company_button() {
//        elarLogisticsListOfCompPage.addCompanyButton.click();
//    }
//
//    @Then("User create company with data")
//    public void user_create_company_with_data(io.cucumber.datatable.DataTable dataTable) {
//        Random randNum = new Random();
//        int num = randNum.nextInt(118746548);
//        data = dataTable.asMaps(String.class,Object.class);
//        for(int i =0;i<data.size();i++){
//            elarLogisticsAddCompPage.nameField.sendKeys(data.get(0).get("NAME").toString());
//            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.companyTypeDropDown,data.get(0).get("COMPANY TYPE").toString());
//            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.statusDropDown,data.get(0).get("STATUS").toString());
//            elarLogisticsAddCompPage.numberOfMc.sendKeys(data.get(0).get("MC#").toString()+num);
//            elarLogisticsAddCompPage.numberOfDot.sendKeys(data.get(0).get("DOT#").toString()+num);
//            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.numberOfIftaDropDown,data.get(0).get("IFTA").toString());
//            elarLogisticsAddCompPage.phoneNumb.sendKeys(data.get(0).get("PHONE").toString());
//            elarLogisticsAddCompPage.street.sendKeys(data.get(0).get("STREET").toString());
//            elarLogisticsAddCompPage.city.sendKeys(data.get(0).get("CITY").toString());
//            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.state,data.get(0).get("STATE").toString());
//            elarLogisticsAddCompPage.zipCode.sendKeys(data.get(0).get("ZIP CODE").toString());
//            elarLogisticsAddCompPage.eMail.sendKeys(data.get(0).get("EMAIL").toString());
//            elarLogisticsAddCompPage.insuranceProdCompName.sendKeys(data.get(0).get("INSURANCE").toString());
//            elarLogisticsAddCompPage.producedPhone.sendKeys(data.get(0).get("PRODUCER PHONE").toString());
//            elarLogisticsAddCompPage.producerStreet.sendKeys(data.get(0).get("PRODUCER STREET").toString());
//            elarLogisticsAddCompPage.producerCity.sendKeys(data.get(0).get("PRODUCER CITY").toString());
//            elarLogisticsAddCompPage.producerState.sendKeys(data.get(0).get("PRODUCED STATE").toString());
//            elarLogisticsAddCompPage.producerZibCode.sendKeys(data.get(0).get("PRODUCED ZIP CODE").toString());
//            elarLogisticsAddCompPage.producerEmail.sendKeys(data.get(0).get("PRODUCER EMAIL").toString());
//            elarLogisticsAddCompPage.employerIdNumber.sendKeys(data.get(0).get("EMPLOYER ID NUMBER").toString());
//            //BrowserUtils.selectDropDownByValue(elarLogisticsAddCompPage.otherLicenses,data.get(0).get("OTHER INSURANCE").toString());
//            elarLogisticsAddCompPage.notes.sendKeys(data.get(0).get("NOTES").toString());
//            elarLogisticsAddCompPage.addCompButton.click();
//        }
//    }
//    @Then("Validates message {string} and press button Go to list companies")
//    public void validates_message_and_press_button_go_to_list_companies(String message) {
//       //Assert.assertEquals(message,elarLogisticsListOfCompPage.createdCompSuccessMess.getText());
//    }
//    @Then("User clicks on button Go to list companies")
//    public void user_clicks_on_button_go_to_list_companies() {
//        elarLogisticsListOfCompPage.goToListComp.click();
//    }
//
////    @Then("User clicks on Search  button")
////    public void user_clicks_on_search_button() {
////        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
////    }
//
//
//    @Then("Clicks on appeared Search engine")
//    public void clicks_on_appeared_search_engine() {
//        elarLogisticsListOfCompPage.searchEngine.click();
//    }
//    @Then("User typed any match {string}")
//    public void user_typed_any_match(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("Validates List of companies matching")
//    public void validates_list_of_companies_matching() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
}
