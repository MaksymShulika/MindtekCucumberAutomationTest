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

    @FindBy(xpath = "//span[contains(text(),'5441 Main Avenue')]")
    public WebElement addressInProfile;

    @FindBy(xpath = "(//span[@class='section-inp border-default'])[24]")
    public WebElement notesInProfile;

    @FindBy(xpath = "//p[normalize-space()='Edit']")
    public WebElement editButton;
}
