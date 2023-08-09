package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;

public class ElarLogisticProfileOfCompanyPage {
    WebDriver driver;

    public ElarLogisticProfileOfCompanyPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class='section-inp border-default'])[24]")
    public WebElement notesInProfile;

    @FindBy(xpath = "//p[normalize-space()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@id='id_company_name']")
    public WebElement companyName;

    @FindBy(xpath = "//select[@id='id_company_type']")
    public WebElement typeOfCompany;

    @FindBy(xpath = "//select[@id='id_status']")
    public WebElement statusOfCompany;

    @FindBy(xpath = "//input[@id='id_mc_number']")
    public WebElement MC_Id_Number;

    @FindBy(xpath = "//input[@id='id_dot_number']")
    public WebElement DOT_Id_Number;

    @FindBy(xpath = "//select[@id='id_ifta']")
    public WebElement IFTA_On_Profile;

    @FindBy(xpath = "//div[7]//div[1]//p[1]//span[1]//span[1]//span[1]//input[1]")
    public WebElement phoneOnProfile;

    @FindBy(xpath = "//div[7]//div[1]//p[1]//span[1]//span[1]//span[1]//input[2]")
    public WebElement phoneExtOnProfile;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[7]/div[1]/p[2]/span[1]/span[2]/input[1]")
    public WebElement contactNameOnProfile;

    @FindBy(xpath = "//div[8]//div[1]//p[1]//span[1]//span[1]//span[1]//input[1]")
    public WebElement producerPhone;

    @FindBy(xpath = "//div[8]//div[1]//p[1]//span[1]//span[1]//span[1]//input[2]")
    public WebElement producerPhoneExt;

    @FindBy(xpath = "(//div[@input='[object Object]']//p//span//span//span//input[@type='text'])[3]")
    public WebElement facOnProfile;

    @FindBy(xpath = "(//div[1]//span[@class='section-form label-align-notes']//span//div//span)[1]")
    public WebElement addressInProfile;

    @FindBy(xpath = "(//div[1]//span[@class='section-form label-align-notes']//span//div//span)[6]")
    public WebElement producerAddressInProfile;

    @FindBy(xpath = "//input[@class='input-form disabled-not-ext border disabled-company lowercase']")
    public WebElement emailOnProfile;

    @FindBy(xpath = "//input[@id='id_insurance']")
    public WebElement insuranceProducerCompanyName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[8]/div[1]/p[2]/span[1]/span[2]/input[1]")
    public WebElement producerContactName;

    //stop on |Producer state|

    @FindBy(xpath = "//select[@id='id_producer_state']")
    public WebElement producerState;

    @FindBy(xpath = "//span[@class='communication-section dark-width border-default']//input[@type='text']")
    public WebElement producerEmail;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[8]/p[2]/span[1]/span[1]/input[1]")
    public WebElement policyEffectiveDay;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[8]/p[3]/span[1]/span[1]/input[1]")
    public WebElement policyExpiration;

    @FindBy(xpath = "//input[@id='id_type_of_insurance']")
    public WebElement typeOfInsurance;

    @FindBy(xpath = "//select[@id='id_automobile_liability']")
    public WebElement automobileLiability;

    @FindBy(xpath = "//input[@id='id_num_of_truck_insured']")
    public WebElement numbersOfTrucksInsured;

    @FindBy(xpath = "//input[@id='id_policy_number']")
    public WebElement policyNumber;

    @FindBy(xpath = "//input[@id='id_employer_id_num']")
    public WebElement employerIdNumber_PasswordHere;

    @FindBy(xpath = "//input[@id='id_billing_address']")
    public WebElement billingAddressForCheck;

    @FindBy(xpath = "//input[@id='id_bank_name']")
    public WebElement bankNameForACHPayment;

    @FindBy(xpath = "//input[@id='id_routing_number']")
    public WebElement routingNumberForACHPayment_PasswordHere;

    @FindBy(xpath = "//input[@id='id_account_number']")
    public WebElement accountNumberForACHPayment_PasswordHere;

    @FindBy(xpath = "//input[@id='id_president_full_name']")
    public WebElement presidentFullName;

    @FindBy(xpath = "//input[@id='id_trucks_in_fleet']")
    public WebElement trucksInFleet;

    @FindBy(xpath = "//input[@id='id_scac_code']")
    public WebElement SCAC_Code;

    @FindBy(xpath = "//select[@id='id_other_licenses']")
    public WebElement otherLicenses;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[12]/p[5]/span[1]/span[1]/input[1]")
    public WebElement incorporatedIn;

    @FindBy(xpath = "//input[@id='id_warning']")
    public WebElement warning;

}
