package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.YardData;
import utillities.ConfigReader;
import utillities.JDBSUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ElarLogisticApiYardSteps {

    Response response;

    Map<String, Object> data;

    String yardId;
    YardData yardData = new YardData();
    List<Map<String, Object>> dbData;

    String apiYardName;
    String apiYardStatus;
    String apiYardAddress;
    String apiYardCity;
    String apiYardState;
    String apiYardSpots;
    String apiYardZipCode;


    @Given("user creates yard with POST api call and use token")
    public void user_creates_yard_with_post_api_call_and_use_token(io.cucumber.datatable.DataTable dataTable) {
        data = dataTable.asMap(String.class, Object.class);

        yardData.setName(data.get("name").toString());
        yardData.setStatus(data.get("status").toString());
        yardData.setStreet(data.get("street").toString());
        yardData.setCity(data.get("city").toString());
        yardData.setState(data.get("state").toString());
        yardData.setZipCode(Integer.parseInt(data.get("zipCode").toString()));
        yardData.setSpots(Integer.parseInt(data.get("tspots").toString()));


        response = given().baseUri(ConfigReader.getProperty("ElarAPIBaseUri"))
                .and().header("Authorization", data.get("token").toString())
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body(yardData)
                .and().log().all() // -> logs (print) request data
                .when().post("/yards/");

        response.then().log().all(); // logs (print) response details
        response.then().statusCode(Integer.parseInt(data.get("statusCode").toString()));

        yardId = response.body().jsonPath().getString("id");
    }



    @When("user connection to database of El")
    public void user_connection_to_database_of_el() throws SQLException {
        JDBSUtils.establishConnection();
        dbData = JDBSUtils.runQuery("select * from core_yard where id = "+yardId);

        apiYardName = response.body().jsonPath().getString("location");
        apiYardStatus = response.body().jsonPath().getString("status");
        apiYardAddress = response.body().jsonPath().getString("address");
        apiYardCity = response.body().jsonPath().getString("city");
        apiYardState = response.body().jsonPath().getString("state");
        apiYardZipCode = response.body().jsonPath().getString("zipCode");
        apiYardSpots = response.body().jsonPath().getString("spots");
    }

    @Then("user validates created yard is persisted in DB of Elar")
    public void user_validates_created_yard_is_persisted_in_db_of_elar() {
        Assert.assertEquals(apiYardAddress, dbData.get(0).get("street").toString());
        Assert.assertEquals(apiYardStatus, dbData.get(0).get("status").toString());
        Assert.assertEquals(apiYardName, dbData.get(0).get("name").toString());
        Assert.assertEquals(apiYardCity, dbData.get(0).get("city").toString());
        Assert.assertEquals(apiYardState, dbData.get(0).get("state").toString());
        Assert.assertEquals(apiYardZipCode, dbData.get(0).get("zipCode").toString());
        Assert.assertEquals(apiYardSpots, dbData.get(0).get("spots").toString());
    }


    @Given("user taking Yard from DB by GET call and validates status code {int}")
    public void user_taking_yard_from_db_by_get_call_and_validates_status_code(Integer statusCode) {
        response = given().baseUri(ConfigReader.getProperty("ElarAPIBaseUri"))
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().log().all() // -> logs (print) request data
                .when().get("/yards/" + yardId);

        response.then().log().all(); // logs (print) response details
        response.then().statusCode(statusCode);
    }




    @Then("user validates created yard is persisted in DT of Elar")
    public void user_validates_created_yard_is_persisted_in_dt_of_elar(io.cucumber.datatable.DataTable dataTable) {
        data = dataTable.asMap(String.class, Object.class);

        Assert.assertEquals(apiYardAddress, data.get("street").toString());
        Assert.assertEquals(apiYardStatus, data.get("status").toString());
        Assert.assertEquals(apiYardName, data.get("name").toString());
        Assert.assertEquals(apiYardCity, data.get("city").toString());
        Assert.assertEquals(apiYardState, data.get("state").toString());
        Assert.assertEquals(apiYardZipCode, data.get("zipCode").toString());
        Assert.assertEquals(apiYardSpots, data.get("spots").toString());
    }

}
