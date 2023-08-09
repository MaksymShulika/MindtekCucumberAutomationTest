package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utillities.Driver;

public class YardApiSteps {

    WebDriver driver = Driver.getDriver();

    @Given("user creates yard with post yard call with data")
    public void user_creates_yard_with_post_yard_call_with_data(io.cucumber.datatable.DataTable dataTable) {
        /*
        POST Yard:
            Request:
                1. URL
                2. Headers -> Authorization, Accept,
                3. Method -> POST
            Response:
         */
    }




    @When("user connection to database")
    public void user_connection_to_database() {

    }

    @Then("user validates created yard is persisted in DB")
    public void user_validates_created_yard_is_persisted_in_db() {

    }
}
