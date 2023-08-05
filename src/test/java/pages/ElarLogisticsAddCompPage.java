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


}
