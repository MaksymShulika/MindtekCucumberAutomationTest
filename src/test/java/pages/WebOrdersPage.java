package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utillities.Driver;

public class WebOrdersPage {

    WebDriver driver;

    public WebOrdersPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropDown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement pricePerUnit;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discount;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement total;

    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateBtn;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement inputCustomerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement inputStreet;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement inputCity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement inputState;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement inputZip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement inputCardTypeVisa;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement inputCardNr;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement inputExpireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;

    @FindBy(xpath = "//strong[contains(text(),'New order')]")
    public WebElement correctMessage;
}
