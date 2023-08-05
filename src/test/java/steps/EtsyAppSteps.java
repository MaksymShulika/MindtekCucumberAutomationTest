package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utillities.BrowserUtils;
import utillities.ConfigReader;
import utillities.Driver;

import java.util.List;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));
    }


    @When("User searches for {string}")
    public void user_searches_for(String itemName) {
        etsyHomePage.searchBar.sendKeys(itemName + Keys.ENTER);
    }

    @Then("User validates search result contains")
    public void user_validates_search_result_contains(DataTable dataTable) {
        boolean isFound = false;
        int num = 0;
        int checkFalse = 0;
        int falseTime = 0;
        int trueTime = 0;
        List<String> itemName = dataTable.asList();
        for (WebElement item : etsyHomePage.items) {
            num++;
            for (String expectedItemName : itemName) {
                if (!item.getText().toLowerCase().contains(expectedItemName)) {
                    checkFalse++;
                } else {
                    trueTime++;
                    isFound = true;
                    System.out.println("-----------CONTAINS---------");
                    System.out.println("|" + expectedItemName + "|");
                    System.out.println("|Y| " + num + "_num_of_line) " + item.getText() + "\n");
                    break;
                }
            }

            if (checkFalse == itemName.size()) {
                //isFound = false;S
                falseTime++;
                System.out.println("-----------NOT_CON------------");
                System.out.println("|N| " + num + "_num_of_line) " + item.getText() + "\n");
                checkFalse = 0;
            }else {
                checkFalse = 0;
            }
        }
        //int nTimesPr =
        System.out.println("\n=========================");
        System.out.println("|Y| times = " + trueTime);
        System.out.println("|N| times = " + falseTime);
        System.out.println("from: " + etsyHomePage.items.size());
        //comment: (false) | "{" + itemDescription + "} does not contain keyword: " + keywords.get(index) + "}", isFound |
        Assert.assertTrue(isFound);
    }

    @When("User selects price range over {int}")
    public void user_selects_price_range_over(Integer priceRang) {
        etsyHomePage.filtersBtn.click();
        etsyHomePage.selectRangOver1_000.click();
        etsyHomePage.applyBtn.click();

    }

    @Then("User validates price range for items over {double}")
    public void user_validates_price_range_for_items_over(Double priceRange) {
        driver.navigate().refresh();
        for (WebElement price : etsyHomePage.pricesOfItems) {
            Double priceDouble = Double.parseDouble(price.getText().replace(",", ""));
            if(priceDouble > priceRange){
                System.out.println("|Y|" + price.getText());
            }else System.out.println("|N|" + price.getText());
            Assert.assertTrue(priceDouble + " is  equal or less than " + priceRange,priceDouble>priceRange);
        }
    }

    @When("User clicks on {string} module")
    public void user_clicks_on_module(String module) {
        switch (module) {
            case "Fashion favorites":
                etsyHomePage.fashionAndFavoritesTab.click();
                break;
            case "Clothing & Shoes - Etsy":
                etsyHomePage.clothingAndShoesTab.click();
                break;
            case "Jewelry & Accessories - Etsy":
                etsyHomePage.jewelryAndAccessoriesTab.click();
                break;
            case "Home & Living - Etsy":
                etsyHomePage.homeAndLivingTab.click();
                break;
            case "Toys & Entertainment - Etsy":
                etsyHomePage.toysAndEntertainmentTab.click();
                break;
            case "Art & Collectibles - Etsy":
                etsyHomePage.artAndCollectiblesTab.click();
                break;
            case "Craft Supplies & Tools - Etsy":
                etsyHomePage.craftSuppliesAndToolsTab.click();
                break;
            case "The Etsy Gift Guide for 2023 - Etsy":
                etsyHomePage.theEtsyGiftTab.click();
                break;
            case "Wedding & Party - Etsy":
                etsyHomePage.weddingAndPartyTab.click();
                break;
        }
    }

    @Then("User validates the {string} Favorites\"")
    public void user_validates_the_favorites(String title) {
        Assert.assertEquals(title ,driver.getTitle());
    }

}
