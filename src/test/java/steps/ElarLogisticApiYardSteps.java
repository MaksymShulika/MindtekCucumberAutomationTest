package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Contacts;
import pojo.YardData;
import utillities.ConfigReader;
import utillities.JDBSUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ElarLogisticApiYardSteps {

    Response response;//for api

    Map<String, Object> data;// public data table

    String yardId;// id of yard

    YardData yardData = new YardData();//pojo

    String apiYardName; // data for creating api calls and for assertions
    String apiYardStatus;
    String apiYardAddress;
    String apiYardCity;
    String apiYardState;
    int apiYardSpots;
    int apiYardZipCode;
    int statusCodeForAll;





    //=========================================POST


    @Given("user creates yard with POST api call and validates {int}")
    public void user_creates_yard_with_post_api_call_and_validates(Integer statusCode, io.cucumber.datatable.DataTable dataTable) {
        data = dataTable.asMap(String.class, Object.class);
        statusCodeForAll = statusCode;





        if (statusCodeForAll!=401) {
            apiYardName = data.get("name").toString();
            apiYardStatus = data.get("status").toString();
            apiYardAddress = data.get("street").toString();
            apiYardCity = data.get("city").toString();
            apiYardState = data.get("state").toString();
            apiYardSpots = Integer.parseInt(data.get("spots").toString());
            apiYardZipCode = Integer.parseInt(data.get("zipCode").toString());
        }




        response = given().baseUri(ConfigReader.getProperty("ElarAPIBaseUri"))  //POST call
                .and().header("Authorization", data.get("token").toString())
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \""+apiYardName+"\",\n" +
                        "  \"status\": \""+apiYardStatus+"\",\n" +
                        "  \"address\": \""+apiYardAddress+"\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \""+apiYardCity+"\",\n" +
                        "  \"state\": \""+apiYardState+"\",\n" +
                        "  \"zip_code\": \""+apiYardZipCode+"\",\n" +
                        "  \"spots\": \""+apiYardSpots+"\",\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"yard_picture\": [],\n" +
                        "  \"contacts\": [],\n" +
                        "  \"service_phone_number\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"\",\n" +
                        "      \"service_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"owner_phone_number\": [\n" +
                        "    {\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .and().log().all() // -> logs (print) request data
                .when().post("/yards/");

        response.then().log().all(); // logs (print) response details
        response.then().statusCode(statusCode);

        if (statusCodeForAll!=401) {
            yardId = response.body().jsonPath().getString("id");// get id from response.body()
        }

    }


    @Then("user validates created yard is persisted in DB of Elar")
    public void user_validates_created_yard_is_persisted_in_db_of_elar() {
        if (statusCodeForAll!=401) {
            Assert.assertEquals(apiYardAddress, response.body().jsonPath().getString("address")); //expected == actual (assertions)
            Assert.assertEquals(apiYardStatus, response.body().jsonPath().getString("status"));
            Assert.assertEquals(apiYardName, response.body().jsonPath().getString("location"));
            Assert.assertEquals(apiYardCity, response.body().jsonPath().getString("city"));
            Assert.assertEquals(apiYardState, response.body().jsonPath().getString("state"));
            Assert.assertEquals(apiYardZipCode, response.body().jsonPath().getInt("zip_code"));
            Assert.assertEquals(apiYardSpots, response.body().jsonPath().getInt("spots"));
        }
    }


    //=========================================GET


    @Given("user use GET api call and validates status code {int}")
    public void user_use_GET_api_call_and_validates_status_code(Integer statusCode) {

        response = given().baseUri(ConfigReader.getProperty("ElarAPIBaseUri"))      // GET api call
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().log().all() // -> logs (print) request data
                .when().get("/yards/" + yardId);

        response.then().log().all(); // logs (print) response details

        response.then().statusCode(statusCode);// valid statusCode
    }


    @Then("user validates created GET call response bode is matching to input info")
    public void user_validates_created_get_call_response_bode_is_matching_to_input_info() {
        Assert.assertEquals(apiYardAddress, response.body().jsonPath().getString("address")); //expected == actual (assertions)
        Assert.assertEquals(apiYardStatus, response.body().jsonPath().getString("status"));
        Assert.assertEquals(apiYardName, response.body().jsonPath().getString("location"));
        Assert.assertEquals(apiYardCity, response.body().jsonPath().getString("city"));
        Assert.assertEquals(apiYardState, response.body().jsonPath().getString("state"));
        Assert.assertEquals(apiYardZipCode, response.body().jsonPath().getInt("zip_code"));
        Assert.assertEquals(apiYardSpots, response.body().jsonPath().getInt("spots"));

    }

}
