package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;
import utillities.BrowserUtils;
import utillities.ConfigReader;
import utillities.Driver;

import javax.swing.text.Utilities;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ElarLogisticAppSteps2 {
//    WebDriver driver = Driver.getDriver();
//    ElarLogisticLoginPage elarLogisticLoginPage = new ElarLogisticLoginPage();
//    ElarLogisticHomePage elarLogisticHomePage = new ElarLogisticHomePage();
//    ElarLogisticsListOfCompPage elarLogisticsListOfCompPage = new ElarLogisticsListOfCompPage();
//    ElarLogisticsAddCompPage elarLogisticsAddCompPage = new ElarLogisticsAddCompPage();
//    ElarLogisticProfileOfCompanyPage elarLogisticProfileOfCompanyPage = new ElarLogisticProfileOfCompanyPage();
//    List<Map<String,Object>> data = new ArrayList<>();
//
//
//    @Given("User navigates to ElarLogistics application")
//    public void user_navigates_to_elar_logistics_application() {
//        driver.get(ConfigReader.getProperty("ElarLogisticsURL"));
//    }
//
//    @When("User logs in with  username {string} and password {string}")
//    public void user_logs_in_with_username_and_password(String userName, String password) {
//        elarLogisticLoginPage.inputUserName.sendKeys(userName);
//        elarLogisticLoginPage.inputPassword.sendKeys(password);
//    }
//    @When("User clicks on Log in button")
//    public void user_clicks_on_log_in_button() {
//        elarLogisticLoginPage.LogInButton.click();
//    }
//    @When("User clicks on Company button")
//    public void user_clicks_on_company_button() {
//        elarLogisticHomePage.companyButton.click();
//    }
//    @When("User clicks on Add Company button")
//    public void user_clicks_on_add_company_button() {
//        elarLogisticsListOfCompPage.addCompanyButton.click();
//    }
//    @When("User create company with data")
//    public void user_create_company_with_data(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
//
//        Random randNum = new Random();
//        //                                            123456
//        int number = randNum.nextInt(900000) + 100000;
//        data = dataTable.asMaps(String.class,Object.class);
//
//        String randomName = BrowserUtils.getRandomNameWithNumbers();//for name
//
//        for(int i =0;i<data.size();i++){
//            elarLogisticsAddCompPage.nameField.sendKeys(data.get(0).get("NAME").toString());
//            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.companyTypeDropDown,data.get(0).get("COMPANY TYPE").toString());
//            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.statusDropDown,data.get(0).get("STATUS").toString());
//            elarLogisticsAddCompPage.numberOfMc.sendKeys(data.get(0).get("MC#").toString()+number);
//            elarLogisticsAddCompPage.numberOfDot.sendKeys(data.get(0).get("DOT#").toString()+number);
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
////            Thread.sleep(10000);
//        }
//    }
//
//    @When("User clicks on Add Company button in company creating page")
//    public void user_clicks_on_add_company_button_in_company_creating_page() {
//        elarLogisticsAddCompPage.addCompButton.click();
//        driver.get("http://3.137.169.132/#/panel/companies/list");
//    }
//
//    @When("User clicks on Search  button")
//    public void user_clicks_on_search_button() {
//        elarLogisticsListOfCompPage.searchButton.click();
//    }
//
//    @Then("User validates the search engine appear")
//    public void user_validates_the_search_engine_appear() {
//        Assert.assertTrue("Search engine is not appearing",elarLogisticsListOfCompPage.searchEngine.isEnabled());
//    }
//
//    @When("User typed any match {string}")
//    public void user_typed_any_match(String nameOfCompany) {
//        elarLogisticsListOfCompPage.searchEngine.sendKeys(nameOfCompany);
//    }
//
//    @Then("Validates List of companies with match {string}")
//    public void validates_list_of_companies_with_match(String nameOfCompany) {
//        int place = 0;
//        for (WebElement el : elarLogisticsListOfCompPage.listOfCompaniesNames){
//            place++;
//            Assert.assertTrue(el.getText().toLowerCase().contains(nameOfCompany));
//            Assert.assertEquals(1, place);
//            break;
//        }
//    }
//
//    @When("User clicks on Name tag")
//    public void user_clicks_on_name_tag() {
//        elarLogisticsListOfCompPage.tagName.click();
//    }
//
//    @When("User types beginning of the value {string}")
//    public void user_types_beginning_of_the_value(String nameOfCompany_beginning) {
//        elarLogisticsListOfCompPage.searchEngine.sendKeys(nameOfCompany_beginning);
//    }
//
//    @Then("Validates list of companies with the beginning of the value {string}")
//    public void validates_list_of_companies_with_the_beginning_of_the_value(String nameOfCompany_beginning) {
//        int place = 0;
//        for (WebElement el : elarLogisticsListOfCompPage.listOfCompaniesNames){
//            place++;
//            Assert.assertTrue(el.getText().toLowerCase().contains(nameOfCompany_beginning));
//            Assert.assertEquals(1, place);
//            break;
//        }
//    }
//
//    @When("User clicks on MC# tag")
//    public void user_clicks_on_mc_tag() {
//        elarLogisticsListOfCompPage.tagMC.click();
//    }
//
//    @When("User types beginning of the value of MC# {string}")
//    public void user_types_beginning_of_the_value_of_mc(String nameOfMC_beginning) {
//        elarLogisticsListOfCompPage.searchEngine.sendKeys(nameOfMC_beginning);
//    }
//
//    @Then("User validates list of companies with beginning of the value {string}")
//    public void user_validates_list_of_companies_with_beginning_of_the_value(String nameOfMC_beginning) {
//        int place = 0;
//        for (WebElement el : elarLogisticsListOfCompPage.listOfMCNumber){
//            place++;
//            Assert.assertTrue(el.getText().contains(nameOfMC_beginning));
//            Assert.assertEquals(1, place);
//            break;
//        }
//    }
//
//    @Then("User validates message of page {string}")
//    public void user_validates_message_of_page(String actualMessage) {
//        BrowserUtils.waitForElementVisibilityOf(elarLogisticsListOfCompPage.companyName);
//        elarLogisticsListOfCompPage.tagMC.click();
//        elarLogisticsListOfCompPage.tagMC.click();
//        Assert.assertEquals(elarLogisticsListOfCompPage.notFoundTextMessage.getText(), actualMessage);
//    }
//
//    @When("User clicks on DOT# tag")
//    public void user_clicks_on_dot_tag() {
//        elarLogisticsListOfCompPage.tagDOT.click();
//    }
//
//    @Then("User validates list of companies with beginning of the value of DOT {string}")
//    public void user_validates_list_of_companies_with_beginning_of_the_value_of_dot(String nameOfDOT_beginning) {
//        int place = 0;
//        for (WebElement el : elarLogisticsListOfCompPage.listOfDOTNumber){
//            place++;
//            Assert.assertTrue(el.getText().contains(nameOfDOT_beginning));
//            Assert.assertEquals(1, place);
//            break;
//        }
//    }
//
//    @Then("User validates message of page by DOT# {string}")
//    public void user_validates_message_of_page_by_dot(String actualMessage) {
//        BrowserUtils.waitForElementVisibilityOf(elarLogisticsListOfCompPage.companyName);
//        elarLogisticsListOfCompPage.tagDOT.click();
//        elarLogisticsListOfCompPage.tagDOT.click();
//        Assert.assertEquals(elarLogisticsListOfCompPage.notFoundTextMessage.getText(), actualMessage);
//    }
//
//    @When("User clicks on Phone tag")
//    public void user_clicks_on_phone_tag() {
//        elarLogisticsListOfCompPage.tagPhone.click();
//    }
//
//    @Then("User validates list of companies with beginning of the value of Phone {string}")
//    public void user_validates_list_of_companies_with_beginning_of_the_value_of_phone(String nameOfPhone_beginning) {
//        int place = 0;
//        for (WebElement el : elarLogisticsListOfCompPage.listOfPhones){
//            place++;
//            Assert.assertEquals(el.getText(), nameOfPhone_beginning);
//            Assert.assertEquals(1, place);
//            break;
//        }
//    }
//
//    @Then("User validates message of page by Phone {string}")
//    public void user_validates_message_of_page_by_phone(String actualMessage) {
//        BrowserUtils.waitForElementVisibilityOf(elarLogisticsListOfCompPage.companyName);
//        elarLogisticsListOfCompPage.tagPhone.click();
//        elarLogisticsListOfCompPage.tagPhone.click();
//        Assert.assertEquals(elarLogisticsListOfCompPage.notFoundTextMessage.getText(), actualMessage);
//    }
//
//    @When("User clicks on Email tag")
//    public void user_clicks_on_email_tag() {
//        elarLogisticsListOfCompPage.tagEmail.click();
//    }
//
//    @Then("Validates list of companies with the beginning of the value by Email {string}")
//    public void validates_list_of_companies_with_the_beginning_of_the_value_by_email(String nameOFEmail_beginning) {
//        int place = 0;
//        for (WebElement el : elarLogisticsListOfCompPage.listOfEmail){
//            place++;
//            Assert.assertTrue(el.getText().contains(nameOFEmail_beginning));
//            Assert.assertEquals(1, place);
//            break;
//        }
//    }
//
//    @When("User clicks on Address tag")
//    public void user_clicks_on_address_tag() {
//        elarLogisticsListOfCompPage.tagAddress.click();
//    }
//
//    @When("User clicks on first company in list and go to profile of company")
//    public void user_clicks_on_first_company_in_list_and_go_to_profile_of_company() {
//        elarLogisticsListOfCompPage.companyName.click();
//    }
//
//
//    @Then("User validates {string} in address")
//    public void user_validates_in_address(String addressValidation) {
//        Assert.assertTrue(elarLogisticProfileOfCompanyPage.addressInProfile.getText().toLowerCase()
//                .contains(addressValidation.toLowerCase()));
//    }
//
//    @When("User clicks on Notes tag")
//    public void user_clicks_on_notes_tag() {
//        elarLogisticsListOfCompPage.tagNotes.click();
//    }
//
//    @When("User clicks on edit button")
//    public void user_clicks_on_edit_button() throws InterruptedException {
//        elarLogisticProfileOfCompanyPage.editButton.click();
//        Thread.sleep(10000);
//    }
//
//    @Then("User validates {string} in notes")
//    public void user_validates_in_notes(String notesValidation) {
//        System.out.println(elarLogisticProfileOfCompanyPage.notesInProfile.getText());
////        Assert.assertTrue(elarLogisticProfileOfCompanyPage.notesInProfile.getAttribute("value").toLowerCase()
////                .contains(notesValidation));
//    }



}
