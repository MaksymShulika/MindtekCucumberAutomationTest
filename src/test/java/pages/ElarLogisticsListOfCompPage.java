package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;


import java.util.List;

public class ElarLogisticsListOfCompPage {
    WebDriver driver;

    public ElarLogisticsListOfCompPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "btn-search-list")
    public WebElement searchButton;

    @FindBy(className = "faceted-input-search")
    public WebElement searchEngine;

    @FindBy(className = "link-btm-menu")
    public WebElement addCompanyButton;

    @FindBy(xpath = "//label[@for='checkbox1']")
    public WebElement tagName;

    @FindBy(xpath = "//label[@for='checkbox2']")
    public WebElement tagMC;

    @FindBy(xpath = "//label[@for='checkbox3']")
    public WebElement tagDOT;

    @FindBy(xpath = "//label[@for='checkbox4']")
    public WebElement tagPhone;

    @FindBy(xpath = "//label[@for='checkbox5']")
    public WebElement tagEmail;

    @FindBy(xpath = "//label[@for='checkbox6']")
    public WebElement tagAddress;

    @FindBy(xpath = "//label[@for='checkbox7']")
    public WebElement tagNotes;

    @FindBy(xpath = "//td[@class='table-link show-popup-list']")//5 comp only////table[@class='table-company-content']/tr
    public List<WebElement> listOfCompaniesNames;

    @FindBy(xpath = "(//td[@class='table-link show-popup-list'])[1]")//5 comp only////table[@class='table-company-content']/tr
    public WebElement companyName;

    @FindBy(xpath = "//td[contains(text(),1234)]")
    public List<WebElement> listOfMCNumber;

    @FindBy(xpath = "//td[contains(text(),4321)]")
    public List<WebElement> listOfDOTNumber;

    @FindBy(xpath = "//td[contains(text(),773)]")
    public List<WebElement> listOfPhones;

    @FindBy(xpath = "//span [@class='company-cell']")
    public List<WebElement> listOfEmail;

//    @FindBy(xpath = "//td[@class='table-link show-popup-list']")
//    public List<WebElement> listOfCompaniesNames;
//
//    @FindBy(xpath = "//td[@class='table-link show-popup-list']")
//    public List<WebElement> listOfCompaniesNames;

    @FindBy(xpath = "//h5[normalize-space()='ABC successfully created']")////div[@class='success-title']/h5
    public WebElement createdCompSuccessMess;

    @FindBy(xpath = "//a[contains(text(),'Go to list companies')]")////div/div[3]/div[2]/a[1]
    public WebElement goToListComp;

    @FindBy(xpath = "//div[@class='not-found-text']")
    public WebElement notFoundTextMessage;







}
