package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;


public class ElarLogisticsAddCompPage {
    WebDriver driver;

    public ElarLogisticsAddCompPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#id_company_name")
    public WebElement nameField;

    @FindBy(id = "id_company_type")
    public WebElement companyTypeDropDown;

    @FindBy(id = "id_status")
    public WebElement statusDropDown;

    @FindBy(id = "id_mc_number")
    public WebElement numberOfMc;

    @FindBy(id = "id_dot_number")
    public WebElement numberOfDot;

    @FindBy(id = "id_ifta")
    public WebElement numberOfIftaDropDown;

    @FindBy(xpath = "(//input[@class='input-phone input-form border disabled-company'])[1]")
    public WebElement phoneNumb;


    @FindBy(id = "id_address")
    public WebElement street;

    @FindBy(id = "id_city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "id_zip_code")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@class='input-form disabled-not-ext border disabled-company lowercase']")
    public WebElement eMail;

    @FindBy(xpath = "//input[@id='id_insurance']")
    public WebElement insuranceProdCompName;

    @FindBy(xpath = "(//input[@class='input-phone input-form border disabled-company'])[2]")
    public WebElement producedPhone;

    @FindBy(xpath = "(//input[@class='input-form border disabled-yard'])[4]")
    public WebElement producerStreet;


    @FindBy(xpath = "(//input[@class='input-form border disabled-yard'])[6]")
    public WebElement producerCity;

    @FindBy(xpath = "//select[@id='id_producer_state']")
    public WebElement producerState;

    @FindBy(id = "id_producer_zip_code")
    public WebElement producerZibCode;

    @FindBy(xpath = "(//input[@class='input-form disabled-not-ext border disabled-company'])[2]")
    public WebElement producerEmail;

    @FindBy(id = "id_employer_id_num")
    public WebElement employerIdNumber;

    @FindBy(id = "id_other_licenses")
    public WebElement otherLicenses;

    @FindBy(id = "id_notes")
    public WebElement notes;

    @FindBy(xpath = "//button[@class='confirm-save']")
    public WebElement addCompButton;

    @FindBy(xpath = "//div[@class='form-container']//div[3]//div[1]//p[2]//span[1]//span[2]//input[1]")
    public WebElement phoneContactName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/div[2]/p[1]/span[1]/span[1]/span[1]/input[1]")
    public WebElement fax;

    @FindBy(xpath = "//input[@id='id_apt_suite_company_co']")
    public WebElement id_Apt_Suit_Company;

    @FindBy(xpath = "//div[1]//div[4]//p[2]//span[1]//span[2]//input[1]")
    public WebElement producerPhoneContactName;

    @FindBy(xpath = "//input[@id='id_producer_apt_suite_company_co']")
    public WebElement  producer_Id_Apt_Suit_Company;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/p[2]/span[1]/span[1]/span[1]")
    public WebElement policyEffectiveDay;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/p[3]/span[1]/span[1]/span[1]")
    public WebElement policyExpiration;

    @FindBy(xpath = "//select[@id='id_automobile_liability']")
    public WebElement automobileLiabilitySelect;

    @FindBy(xpath = "//input[@id='id_num_of_truck_insured']")
    public WebElement numbersOfTrucksInsured;

    @FindBy(xpath = "//input[@id='id_policy_number']")
    public WebElement policyNumber;

    @FindBy(xpath = "//input[@id='id_billing_address']")
    public WebElement billingAddressForCheck;

    @FindBy(xpath = "//input[@id='id_bank_name']")
    public WebElement bankNameForACHPayment;

    @FindBy(xpath = "//input[@id='id_routing_number']")
    public WebElement routingNumberForACHPayment;

    @FindBy(xpath = "//input[@id='id_account_number']")
    public WebElement accountNumberForACHPayment;

    @FindBy(xpath = "//input[@id='id_president_full_name']")
    public WebElement presidentFullName;

    @FindBy(xpath = "//input[@id='id_trucks_in_fleet']")
    public WebElement trucksInFleet;

    @FindBy(xpath = "//input[@id='id_scac_code']")
    public WebElement SCAC_Code;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[8]/p[5]/span[1]/span[1]/span[1]")
    public WebElement incorporatedIn;

    @FindBy(xpath = "//input[@id='id_warning']")
    public WebElement warning;

    @FindBy(xpath = "//div[@class='form-container']//div[3]//div[1]//p[1]//span[1]//span[1]//span[1]//input[2]")
    public WebElement phoneExt;

    @FindBy(xpath = "(//div[@input='[object Object]']//p//span//span//span//input[@class='input-form input-ext border disabled-company'])[2]")
    public WebElement producePhoneExt;

    @FindBy(xpath =  "//li[@class='calendar-day']//span[@class='date'][normalize-space()='3']")
    public WebElement dayFromPolicyEffectiveDay;

    @FindBy(xpath =  "//span[@class='date'][normalize-space()='16']")
    public WebElement dayFromPolicyExpiration;

    @FindBy(xpath = "//div[@class='success-button']//a[@class='link-cancel confirm-save'][normalize-space()='Go to list companies']")
    public WebElement bntGoToList;
}
