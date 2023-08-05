package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;


public class ElarLogisticLoginPage {
    WebDriver driver;

    public ElarLogisticLoginPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@class='input-login']")
    public WebElement inputUserName;

    @FindBy(id = "id_input_pass")
    public WebElement inputPassword;

    @FindBy(className = "btn-login")
    public WebElement LogInButton;

}
