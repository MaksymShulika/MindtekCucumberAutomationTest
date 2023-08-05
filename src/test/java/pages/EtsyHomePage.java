package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utillities.Driver;

import java.util.List;

public class EtsyHomePage {

    WebDriver driver;

    public EtsyHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBar;

    @FindBy(xpath = "//ol[@data-results-grid-container]//h3")
    public List<WebElement> items;

    @FindBy(id = "search-filter-button")
    public WebElement filtersBtn;

    @FindBy(xpath = "//label[@for='price-input-4']")
    public WebElement selectRangOver1_000;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    public WebElement applyBtn;

    @FindBy(xpath = "//ol[@data-results-grid-container]//p[2]//span[@class='currency-value']")
    public List<WebElement> pricesOfItems;

    @FindBy(xpath = "//a[@class='wt-display-table wt-width-full wt-text-link-no-underline']")
    public WebElement fashionAndFavoritesTab;

    @FindBy(id = "catnav-primary-link-10923")
    public WebElement clothingAndShoesTab;

    @FindBy(xpath = "//span[@id='catnav-primary-link-10855']")
    public WebElement jewelryAndAccessoriesTab;

    @FindBy(id = "catnav-primary-link-891")
    public WebElement homeAndLivingTab;

    @FindBy(id = "catnav-primary-link-10983")
    public WebElement weddingAndPartyTab;

    @FindBy(id = "catnav-primary-link-11049")
    public WebElement toysAndEntertainmentTab;

    @FindBy(xpath = "//span[contains(text(),'Art & Collectibles')]")
    public WebElement artAndCollectiblesTab;

    @FindBy(xpath = "//span[contains(text(),'Craft Supplies')]")
    public WebElement craftSuppliesAndToolsTab;

    @FindBy(id = "catnav-primary-link--10")
    public WebElement theEtsyGiftTab;

}
