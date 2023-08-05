package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;

public class PorscheAppMainPage {
    WebDriver driver;

    public PorscheAppMainPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[contains(text(),'$')])[1]")
    public WebElement priceOfCaymanAndBtn;
}
