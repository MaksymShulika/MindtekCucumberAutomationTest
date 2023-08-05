package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PorscheAppMainPage;
import pages.PorscheCaymanPage;
import utillities.BrowserUtils;
import utillities.ConfigReader;
import utillities.Driver;

public class PorscheAppAssignment2 {

    WebDriver driver = Driver.getDriver();
    PorscheAppMainPage porscheAppMainPage = new PorscheAppMainPage();
    PorscheCaymanPage porscheCaymanPage = new PorscheCaymanPage();
    double expectedPrice;
    double basePrice;

    @Given("user navigates to Porsche Car application")
    public void user_navigates_to_porsche_car_application() {
        driver.get(ConfigReader.getProperty("PorscheCarConfigurationURL"));
    }

    @When("user stores the price and selects the model {int} Cayman")
    public void user_stores_the_price_and_selects_the_model_cayman(Integer model) {
        expectedPrice = Double.parseDouble(porscheAppMainPage.priceOfCaymanAndBtn.getText()
                .substring(porscheAppMainPage.priceOfCaymanAndBtn.getText().indexOf("$")+1)
                .replace(",", ".").replace("*", ""));
        porscheAppMainPage.priceOfCaymanAndBtn.click();
    }

    @Then("user validates Base price is matched with listed price")
    public void user_validates_base_price_is_matched_with_listed_price() {
        basePrice = Double.parseDouble(porscheCaymanPage.caymanBasePrice.getText()
                .substring(porscheCaymanPage.caymanBasePrice.getText().indexOf("$")+1)
                .replace(",", ".").replace("*", ""));
        Assert.assertEquals(expectedPrice, basePrice, 0.0);
    }

    @When("user adds Power Sport Seats \\({int}-way) with Memory Package")
    public void user_adds_power_sport_seats_way_with_memory_package(Integer int1) {
        BrowserUtils.scrollDownBy(6000);
        porscheCaymanPage.caymanPremiumPackageSelect.click();
        porscheCaymanPage.closeLayer.click();
        porscheCaymanPage.caymanPremiumPackageAcceptBtn.click();
    }

    @Then("user validates that Price For Equipment is added and price matches")
    public void user_validates_that_price_for_equipment_is_added_and_price_matches() {
        //BrowserUtils.scrollDownBy(-6000);
        BrowserUtils.waitForElementVisibilityOf(porscheCaymanPage.caymanBasePrice);
        double basePriceAfterAdd = Double.parseDouble(porscheCaymanPage.caymanBasePrice.getText()
                .substring(porscheCaymanPage.caymanBasePrice.getText().indexOf("$")+1)
                .replace(",", ".").replace("*", ""));
        Assert.assertTrue(basePrice<basePriceAfterAdd);
    }




}
