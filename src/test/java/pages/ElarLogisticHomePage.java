package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;


public class ElarLogisticHomePage {
    WebDriver driver;

    public ElarLogisticHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='side-link-company']")
    public WebElement companyButton;

//    @FindBy(className = "btn-search-list")
//    public WebElement searchButton;



}
