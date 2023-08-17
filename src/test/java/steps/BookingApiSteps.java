package steps;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Booking;
import pojo.Bookingdates;
import utillities.ConfigReader;

import java.io.Reader;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingApiSteps {

    //api
    Response response;

    //for body
    Booking bookingPayload = new Booking();
    Bookingdates bookingdates = new Bookingdates();

    String id;
    String firstName;
    String lastName ;
    String totalPrice ;
    String checkIn ;
    String checkout ;
    String additionalNeeds ;




    Map<String, Object> data;
    Map<String, Object> updateData;

    @Given("user creates booking with POST api call with data")
    public void user_creates_booking_with_post_api_call_with_data(io.cucumber.datatable.DataTable dataTable) {

        data = dataTable.asMap(String.class, Object.class);
        firstName = data.get("firstName").toString();
        lastName = data.get("lastname").toString();
        totalPrice = data.get("totalprice").toString();
        checkIn = data.get("checkin").toString();
        checkout = data.get("checkout").toString();
        additionalNeeds = data.get("additionalneeds").toString();


        bookingPayload.setFirstname(firstName);
        bookingPayload.setLastname(lastName);
        bookingPayload.setTotalprice(Integer.parseInt(totalPrice));
        bookingPayload.setDepositpaid(true);
        bookingPayload.setAdditionalneeds(additionalNeeds);
        bookingdates.setCheckin(checkIn);
        bookingdates.setCheckout(checkout);
        bookingPayload.setBookingdates(bookingdates);

        // SERIALIZATION
        Gson gson = new Gson();
        String requestPayload = gson.toJson(bookingPayload);
        System.out.println("Request payload: " + requestPayload);



        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
               .and().accept("application/json")
               .and().contentType("application/json")
                //Body -> Java Object
                .and().body(requestPayload) // do it up ===> SERIALIZATION
               //.and().body(bookingPayload)// POJO -> Json ===> SERIALIZATION

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
        // EXPECTED -> data(map)
        // ACTUAL -> response body

        Assert.assertEquals(data.get("firstName").toString(), response.body().jsonPath().getString("firstname"));
        Assert.assertEquals(data.get("lastname").toString(), response.body().jsonPath().getString("lastname"));

        Assert.assertEquals(Integer.parseInt(data.get("totalprice").toString()), response.body().jsonPath().getInt("totalprice"));

        //Assert.assertEquals(data.get("depositpaid").toString(), response.body().jsonPath().getString("depositpaid")); no in DB
        Assert.assertEquals(data.get("checkin").toString(), response.body().jsonPath().getString("bookingdates.checkin"));
        Assert.assertEquals(data.get("checkout").toString(), response.body().jsonPath().getString("bookingdates.checkout"));
        Assert.assertEquals(data.get("additionalneeds").toString(), response.body().jsonPath().getString("additionalneeds"));
    }

    @When("user updates booking with PUT updates booking with PUT api call with data")
    public void user_updates_booking_with_put_updates_booking_with_put_api_call_with_data(io.cucumber.datatable.DataTable dataTable) {
        updateData = dataTable.asMap(String.class, Object.class);
        firstName = updateData.get("firstname").toString();
        checkIn = updateData.get("checkin").toString();
        checkout = updateData.get("checkout").toString();

        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().body("{\n" +
                        "    \"firstname\" : \""+firstName+"\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \""+checkIn+"\",\n" +
                        "        \"checkout\" : \""+checkout+"\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .and().log().all() // logs request details
                .when().put("/booking/"+id);
        response.then().log().all(); // logs response details
    }


    @When("user gets updated booking with GET api call")
    public void user_gets_updated_booking_with_get_api_call() {
        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().log().all()
                .when().get("/booking/"+id);
        response.then().log().all();
    }

    @Then("user validates updated data matches with response of get call")
    public void user_validates_updated_data_matches_with_response_of_get_call() {
        Booking bookingResponseBody = response.body().as(Booking.class); // Json -> POJO ===> DESERIALIZATION

        Gson gson = new Gson();
        Booking responseBody = gson.fromJson(response.body().toString(), Booking.class);

        Assert.assertEquals(updateData.get("firstname").toString(), bookingResponseBody.getFirstname());
        Assert.assertEquals(updateData.get("checkin").toString(), bookingResponseBody.getBookingdates().getCheckin());
        Assert.assertEquals(updateData.get("checkout").toString(), bookingResponseBody.getBookingdates().getCheckout());
    }

    @When("user deletes created booking with DELETE api call")
    public void user_deletes_created_booking_with_delete_api_call() {
        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().log().all()//details of request
                .when().delete("/booking/" + id);

        response.then().log().all();//details of response
    }

    @When("user gets deleted booking with GET api call")
    public void user_gets_deleted_booking_with_get_api_call() {
        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().accept("application/json")
                .and().log().all()//details of request
                .when().get("booking" + id);

        response.then().log().all();//details of response
    }

    @When("user deletes created booking with DELETE api call without authorization token")
    public void user_deletes_created_booking_with_delete_api_call_without_authorization_token() {
        response = given().baseUri(ConfigReader.getProperty("BookingAPIBaseUrl"))
                .and().log().all()
                .when().delete("/booking/" + id);

        response.then().log().all();
    }

}
