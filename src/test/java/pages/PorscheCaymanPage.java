package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;

public class PorscheCaymanPage {

    WebDriver driver;

    public PorscheCaymanPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[@class='text-md md:text-xl'])[2]")
    public WebElement caymanBasePrice;

    @FindBy(xpath = "//input[@aria-label='Premium Package']")
    public WebElement caymanPremiumPackageSelect;

    @FindBy(xpath = "//a[contains(text(),'Accept changes')]")
    public WebElement caymanPremiumPackageAcceptBtn;

    @FindBy(xpath = "//button[@aria-label='Close Layer']")
    public WebElement closeLayer;

}
