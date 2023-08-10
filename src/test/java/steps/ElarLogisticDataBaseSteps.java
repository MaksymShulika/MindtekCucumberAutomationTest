package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utillities.BrowserUtils;
import utillities.ConfigReader;
import utillities.Driver;
import utillities.JDBSUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ElarLogisticDataBaseSteps {

WebDriver driver = Driver.getDriver();
ElarLogisticProfileOfCompanyPage elarLogisticProfileOfCompanyPage = new ElarLogisticProfileOfCompanyPage();
ElarLogisticsAddCompPage elarLogisticsAddCompPage = new ElarLogisticsAddCompPage();
ElarLogisticLoginPage elarLogisticLoginPage = new ElarLogisticLoginPage();
ElarLogisticHomePage elarLogisticHomePage = new ElarLogisticHomePage();
ElarLogisticsListOfCompPage elarLogisticsListOfCompPage = new ElarLogisticsListOfCompPage();

List<Map<String,Object>> data = new ArrayList<>();

String uniqueMC;


    Random randNum = new Random();
    int number = randNum.nextInt(900000) + 100000;


    int i;

    @Given("User navigates to ElarLogistics application and create company")
    public void user_navigates_to_elar_logistics_application_and_create_company() {
        driver.get(ConfigReader.getProperty("ElarLogisticsURL"));
    }


    @When("User logs in with  username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String userName, String password) {
        elarLogisticLoginPage.inputUserName.sendKeys(userName);
        elarLogisticLoginPage.inputPassword.sendKeys(password);
    }
    @When("User clicks on Log in button")
    public void user_clicks_on_log_in_button() throws InterruptedException {
        elarLogisticLoginPage.LogInButton.click();
        Thread.sleep(40000);

    }

    @When("User clicks on Company button")
    public void user_clicks_on_company_button() throws InterruptedException {
        elarLogisticHomePage.companyButton.click();
    }

    @When("User clicks on Add Company button")
    public void user_clicks_on_add_company_button() throws InterruptedException {
        Thread.sleep(1000);
        elarLogisticsListOfCompPage.addCompanyButton.click();
    }

    @When("User create company with personal data")
    public void user_create_company_with_data(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        data = dataTable.asMaps(String.class,Object.class);

            elarLogisticsAddCompPage.nameField.sendKeys(data.get(i).get("NAME").toString());
            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.companyTypeDropDown,data.get(i).get("COMPANY TYPE").toString());
            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.statusDropDown,data.get(i).get("STATUS").toString());
            elarLogisticsAddCompPage.numberOfMc.sendKeys(data.get(i).get("MC#").toString()+number);
            elarLogisticsAddCompPage.numberOfDot.sendKeys(data.get(i).get("DOT#").toString()+number);
            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.numberOfIftaDropDown,data.get(i).get("IFTA").toString());
            elarLogisticsAddCompPage.phoneNumb.sendKeys(data.get(i).get("PHONE").toString());
            elarLogisticsAddCompPage.street.sendKeys(data.get(i).get("STREET").toString());
            elarLogisticsAddCompPage.city.sendKeys(data.get(i).get("CITY").toString());
            BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.state,data.get(i).get("STATE").toString());
            elarLogisticsAddCompPage.zipCode.sendKeys(data.get(i).get("ZIP CODE").toString());
            elarLogisticsAddCompPage.eMail.sendKeys(data.get(i).get("EMAIL").toString());
            elarLogisticsAddCompPage.insuranceProdCompName.sendKeys(data.get(i).get("INSURANCE").toString());
            elarLogisticsAddCompPage.producedPhone.sendKeys(data.get(i).get("PRODUCER PHONE").toString());
            elarLogisticsAddCompPage.producerStreet.sendKeys(data.get(i).get("PRODUCER STREET").toString());
            elarLogisticsAddCompPage.producerCity.sendKeys(data.get(i).get("PRODUCER CITY").toString());
            elarLogisticsAddCompPage.producerState.sendKeys(data.get(i).get("PRODUCED STATE").toString());
            elarLogisticsAddCompPage.producerZibCode.sendKeys(data.get(i).get("PRODUCED ZIP CODE").toString());
            elarLogisticsAddCompPage.producerEmail.sendKeys(data.get(i).get("PRODUCER EMAIL").toString());
            elarLogisticsAddCompPage.employerIdNumber.sendKeys(data.get(i).get("EMPLOYER ID NUMBER").toString());



            uniqueMC = data.get(i).get("MC#").toString() + number;


    }

    @When("User create company with full personal data")
    public void user_create_company_with_full_personal_data(io.cucumber.datatable.DataTable dataTable) {
        data = dataTable.asMaps(String.class,Object.class);


        elarLogisticsAddCompPage.nameField.sendKeys(data.get(i).get("NAME").toString());
        BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.companyTypeDropDown,data.get(i).get("COMPANY TYPE").toString());
        BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.statusDropDown,data.get(i).get("STATUS").toString());
        elarLogisticsAddCompPage.numberOfMc.sendKeys(data.get(i).get("MC#").toString()+number);
        elarLogisticsAddCompPage.numberOfDot.sendKeys(data.get(i).get("DOT#").toString()+number);
        BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.numberOfIftaDropDown,data.get(i).get("IFTA").toString());
        elarLogisticsAddCompPage.phoneNumb.sendKeys(data.get(i).get("PHONE").toString());
        elarLogisticsAddCompPage.phoneExt.sendKeys(data.get(i).get("Ext1").toString());
        elarLogisticsAddCompPage.phoneContactName.sendKeys(data.get(i).get("Contact name").toString());
        elarLogisticsAddCompPage.fax.sendKeys(data.get(i).get("Fax").toString());
        elarLogisticsAddCompPage.street.sendKeys(data.get(i).get("STREET").toString());
        elarLogisticsAddCompPage.id_Apt_Suit_Company.sendKeys(data.get(i).get("Apt1").toString());
        elarLogisticsAddCompPage.city.sendKeys(data.get(i).get("CITY").toString());
        BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.state,data.get(i).get("STATE").toString());
        elarLogisticsAddCompPage.zipCode.sendKeys(data.get(i).get("ZIP CODE").toString());
        elarLogisticsAddCompPage.eMail.sendKeys(data.get(i).get("EMAIL").toString());
        elarLogisticsAddCompPage.insuranceProdCompName.sendKeys(data.get(i).get("INSURANCE").toString());
        elarLogisticsAddCompPage.producedPhone.sendKeys(data.get(i).get("PRODUCER PHONE").toString());
        elarLogisticsAddCompPage.producePhoneExt.sendKeys(data.get(i).get("Ext2").toString());
        elarLogisticsAddCompPage.producerPhoneContactName.sendKeys(data.get(i).get("ContactName2").toString());
        elarLogisticsAddCompPage.producerStreet.sendKeys(data.get(i).get("PRODUCER STREET").toString());
        elarLogisticsAddCompPage.producer_Id_Apt_Suit_Company.sendKeys(data.get(i).get("Apt2").toString());
        elarLogisticsAddCompPage.producerCity.sendKeys(data.get(i).get("PRODUCER CITY").toString());
        elarLogisticsAddCompPage.producerState.sendKeys(data.get(i).get("PRODUCED STATE").toString());
        elarLogisticsAddCompPage.producerZibCode.sendKeys(data.get(i).get("PRODUCED ZIP CODE").toString());
        elarLogisticsAddCompPage.producerEmail.sendKeys(data.get(i).get("PRODUCER EMAIL").toString());


        elarLogisticsAddCompPage.policyEffectiveDay.click();//open
        elarLogisticsAddCompPage.dayFromPolicyEffectiveDay.click();//choose day
        elarLogisticsAddCompPage.policyEffectiveDay.click();//cole


        elarLogisticsAddCompPage.policyExpiration.click();
        elarLogisticsAddCompPage.dayFromPolicyExpiration.click();
        elarLogisticsAddCompPage.policyExpiration.click();

        elarLogisticsAddCompPage.insuranceProdCompName.sendKeys(data.get(i).get("Type of insurance1").toString());
        BrowserUtils.selectDropdownByValue(elarLogisticsAddCompPage.automobileLiabilitySelect, data.get(i).get("Automobile liability").toString());
        elarLogisticsAddCompPage.numbersOfTrucksInsured.sendKeys(data.get(i).get("Numbers of trucks insured").toString());
        elarLogisticsAddCompPage.policyNumber.sendKeys(data.get(i).get("Policy number").toString());
        elarLogisticsAddCompPage.employerIdNumber.sendKeys(data.get(i).get("EMPLOYER ID NUMBER").toString());
        elarLogisticsAddCompPage.billingAddressForCheck.sendKeys(data.get(i).get("Billing address (for check)").toString());
        elarLogisticsAddCompPage.bankNameForACHPayment.sendKeys(data.get(i).get("Bank name(for ACH payment)").toString());
        elarLogisticsAddCompPage.routingNumberForACHPayment.sendKeys(data.get(i).get("Routing Number (for ACH payment)").toString());
        elarLogisticsAddCompPage.accountNumberForACHPayment.sendKeys(data.get(i).get("Account Number(for ACH payment)").toString());
        elarLogisticsAddCompPage.presidentFullName.sendKeys(data.get(i).get("President full name").toString());
        elarLogisticsAddCompPage.trucksInFleet.sendKeys(data.get(i).get("Trucks in fleet").toString());
        elarLogisticsAddCompPage.SCAC_Code.sendKeys(data.get(i).get("SCAC code").toString());
        elarLogisticsAddCompPage.otherLicenses.sendKeys(data.get(i).get("Other licenses").toString());
        elarLogisticsAddCompPage.warning.sendKeys(data.get(i).get("Warning").toString());
        elarLogisticsAddCompPage.notes.sendKeys(data.get(i).get("NOTES").toString());
    }


    @When("User clicks on Add Company button in company creating page and go on companies list")
    public void user_clicks_on_add_company_button_in_company_creating_page() throws InterruptedException {
        elarLogisticsAddCompPage.addCompButton.click();
        Thread.sleep(40000);
        BrowserUtils.waitForElementToBeClickable(elarLogisticsAddCompPage.addCompButton);
        elarLogisticsAddCompPage.bntGoToList.click();
        Thread.sleep(20000);
    }

    //@When("click on search btn and write company MC#{string}")
    //public void click_on_search_btn_and_write_company_name(String MC) throws InterruptedException {
    //    driver.navigate().refresh();
    //    Thread.sleep(40000);
    //    elarLogisticsListOfCompPage.searchButton.click();
     //   elarLogisticsListOfCompPage.searchEngine.sendKeys(MC+uniqueMcFullNumbers);
     //   Thread.sleep(3000);
     //   elarLogisticsListOfCompPage.tagMC.click();
      //  elarLogisticsListOfCompPage.tagMC.click();
     //  elarLogisticsListOfCompPage.tagMC.click();
      //  Thread.sleep(20000);
   // }

   // @When("User navigate to company with MC#{string}")
   // public void user_navigate_to_company_with_name(String MC) {
     //   int place = 0;
     //   for (WebElement el : elarLogisticsListOfCompPage.listOfCompaniesNames){
       //     place ++;
     //       if (place == 1){
         //       el.click();
        //    }
      //  }
  //  }





    @Then("User will Validates all unique fields from company profile to Data Base by own fields")
    public void user_will_validates_all_unique_fields_from_company_profile_to_data_base_by_own_fields(io.cucumber.datatable.DataTable dataTable) throws SQLException {
        data = dataTable.asMaps(String.class,Object.class);

        JDBSUtils.establishConnection();
        List<Map<String, Object>> dbData = JDBSUtils.runQuery("select * from core_company where mc_number = '" + uniqueMC + "'");

        Assert.assertEquals(data.get(i).get("NAME").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("COMPANY TYPE").toString(), dbData.get(0).get("company_type"));
        Assert.assertEquals(data.get(i).get("STATUS").toString(), dbData.get(0).get("status"));
        Assert.assertEquals(data.get(i).get("MC#").toString(), dbData.get(0).get("mc_number"));
        Assert.assertEquals(data.get(i).get("DOT#").toString(), dbData.get(0).get("dot_number"));
        Assert.assertEquals(data.get(i).get("IFTA").toString(), dbData.get(0).get("ifta"));
        //Assert.assertEquals(data.get(i).get("PHONE").toString(), dbData.get(0).get("company_name")); no on DB (bag)
        Assert.assertEquals(data.get(i).get("STREET").toString(), dbData.get(0).get("address"));
        Assert.assertEquals(data.get(i).get("CITY").toString(), dbData.get(0).get("city"));
        Assert.assertEquals(data.get(i).get("STATE").toString(), dbData.get(0).get("state"));
        Assert.assertEquals(data.get(i).get("ZIP CODE").toString(), dbData.get(0).get("zip_code"));
        //Assert.assertEquals(data.get(i).get("EMAIL").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("INSURANCE").toString(), dbData.get(0).get("insurance"));
        //Assert.assertEquals(data.get(i).get("PRODUCER PHONE").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("PRODUCER STREET").toString(), dbData.get(0).get("producer_address"));
        Assert.assertEquals(data.get(i).get("PRODUCER CITY").toString(), dbData.get(0).get("producer_city"));
        Assert.assertEquals(data.get(i).get("PRODUCED STATE").toString(), dbData.get(0).get("producer_sate"));
        Assert.assertEquals(data.get(i).get("PRODUCED ZIP CODE").toString(), dbData.get(0).get("producer_zip_code"));
        //Assert.assertEquals(data.get(i).get("PRODUCER EMAIL").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("EMPLOYER ID NUMBER").toString(), dbData.get(0).get("employer_id_number"));
//        Assert.assertEquals(data.get(i).get("OTHER LICENSES").toString(), dbData.get(0).get("company_name"));

    }

    @Then("User will Validates all unique fields from company profile to Data Base by using all fields")
    public void user_will_validates_all_unique_fields_from_company_profile_to_data_base_by_using_all_fields(io.cucumber.datatable.DataTable dataTable) throws SQLException {
        data = dataTable.asMaps(String.class,Object.class);
        JDBSUtils.establishConnection();
        List<Map<String, Object>> dbData = JDBSUtils.runQuery("select * from core_company where mc_number = '" + uniqueMC + "'");

        Assert.assertEquals(data.get(i).get("NAME").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("COMPANY TYPE").toString(), dbData.get(0).get("company_type"));
        Assert.assertEquals(data.get(i).get("STATUS").toString(), dbData.get(0).get("status"));
        Assert.assertEquals(data.get(i).get("MC#").toString(), dbData.get(0).get("mc_number"));
        Assert.assertEquals(data.get(i).get("DOT#").toString(), dbData.get(0).get("dot_number"));
        Assert.assertEquals(data.get(i).get("IFTA").toString(), dbData.get(0).get("ifta"));
        //Assert.assertEquals(data.get(i).get("PHONE").toString(), dbData.get(0).get("company_name")); no on DB (bag)
        Assert.assertEquals(data.get(i).get("STREET").toString(), dbData.get(0).get("address"));
        Assert.assertEquals(data.get(i).get("CITY").toString(), dbData.get(0).get("city"));
        Assert.assertEquals(data.get(i).get("STATE").toString(), dbData.get(0).get("state"));
        Assert.assertEquals(data.get(i).get("ZIP CODE").toString(), dbData.get(0).get("zip_code"));
        //Assert.assertEquals(data.get(i).get("EMAIL").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("INSURANCE").toString(), dbData.get(0).get("insurance"));
        //Assert.assertEquals(data.get(i).get("PRODUCER PHONE").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("PRODUCER STREET").toString(), dbData.get(0).get("producer_address"));
        Assert.assertEquals(data.get(i).get("PRODUCER CITY").toString(), dbData.get(0).get("producer_city"));
        Assert.assertEquals(data.get(i).get("PRODUCED STATE").toString(), dbData.get(0).get("producer_sate"));
        Assert.assertEquals(data.get(i).get("PRODUCED ZIP CODE").toString(), dbData.get(0).get("producer_zip_code"));
        //Assert.assertEquals(data.get(i).get("PRODUCER EMAIL").toString(), dbData.get(0).get("company_name"));
        Assert.assertEquals(data.get(i).get("EMPLOYER ID NUMBER").toString(), dbData.get(0).get("employer_id_number"));
//        Assert.assertEquals(data.get(i).get("OTHER LICENSES").toString(), dbData.get(0).get("company_name"));

        Assert.assertEquals(data.get(i).get("NOTES").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Contact name").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Policy effective day").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Policy expiration").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Type of insurance1").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Automobile liability").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Numbers of trucks insured").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Policy number").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Billing address (for check)").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Bank name(for ACH payment)").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Routing Number (for ACH payment)").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Account Number(for ACH payment)").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("President full name").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Trucks in fleet").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("SCAC code").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Other licenses").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Incorporated in").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Warning").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("ContactName2").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Ext1").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("ProducerPhoneExt").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Fax").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Apt1").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Ext2").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Apt2").toString(), dbData.get(0).get("employer_id_number"));
        Assert.assertEquals(data.get(i).get("Type of insurance").toString(), dbData.get(0).get("employer_id_number"));

        //http://3.137.169.132/#/login
    }
}







