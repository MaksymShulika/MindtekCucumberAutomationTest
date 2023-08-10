package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.response.Response;
import utillities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingApiSteps {

    Response response;
    String id;

    @Given("user creates booking with POST api call with data")
    public void user_creates_booking_with_post_api_call_with_data(io.cucumber.datatable.DataTable dataTable) {

        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        String firstName = data.get("firstName").toString();
        String lastName = data.get("lastname").toString();
        String totalPrice = data.get("totalprice").toString();
        String checkIn = data.get("checkin").toString();
        String checkout = data.get("checkout").toString();
        String additionalNeeds = data.get("additionalneeds").toString();


        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
               .and().accept("application/json")
               .and().contentType("application/json")
               .and().body("{\n" +
                        "    \"firstname\" : \""+firstName+"\",\n" +
                        "    \"lastname\" : \""+lastName+"\",\n" +
                        "    \"totalprice\" : "+totalPrice+",\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \""+checkIn+"\",\n" +
                        "        \"checkout\" : \""+checkout+"\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \""+additionalNeeds+"\"\n" +
                        "}")
                .and().log().all()
                .when().post("/booking");

        System.out.println("\nAfter Post: +_++_+__+__+_+_+_++_+__+___+_+__\n");

        response.then().log().all();

        id = response.body().jsonPath().getString("bookingid");

    }


    @When("user gets created booking with GET api call")
    public void user_gets_created_booking_with_get_api_call() {

        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().log().all()
                .when().get("/booking/" + id);

        System.out.println("\nAfter Post: +_++_+__+__+_+_+_++_+__+___+_+__++++++++++++++++++++++++++++++++++++++++++++\n");

        response.then().log().all();

    }

    @Then("user validates {int} status code")
    public void user_validates_status_code(Integer status) {
        response.then().statusCode(status);
    }

    @Then("user validates created data matches with response of get call")
    public void user_validates_created_data_matches_with_response_of_get_call() {

    }
}
