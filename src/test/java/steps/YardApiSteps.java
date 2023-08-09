package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;
import utillities.BrowserUtils;
import utillities.Driver;
import utillities.JDBSUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

import static io.restassured.RestAssured.given;

public class YardApiSteps {

    WebDriver driver = Driver.getDriver();
    Response response;
    String yardId;


    @Given("user creates yard with post yard call with data")
    public void user_creates_yard_with_post_yard_call_with_data(io.cucumber.datatable.DataTable dataTable) {
        /*
        POST Yard:
            Request:
                1. URL
                2. Headers -> Authorization, Accept, Content-Type
                3. Payload -> json data
                4. Method -> POST
            Response:

         */


        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        String name = data.get("location").toString();
        String status = data.get("status").toString();
        String address = data.get("Address").toString();

        response = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \""+name+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"address\": \""+address+"\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60173\",\n" +
                        "  \"spots\": \"123\",\n" +
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
        response.then().statusCode(201);

        yardId = response.body().jsonPath().getString("id");
    }




    @When("user connection to database")
    public void user_connection_to_database() throws SQLException {

        JDBSUtils.establishConnection();
        List<Map<String, Object>> dbData = JDBSUtils.runQuery("select * from core_yard where id = "+yardId);
        System.out.println("Yard details from database: " + dbData);

        String apiYardName = response.body().jsonPath().getString("location");
        String apiYardStatus = response.body().jsonPath().getString("status");
        String apiYardAddress = response.body().jsonPath().getString("address");




        Assert.assertEquals(apiYardAddress, dbData.get(0).get("address"));
        Assert.assertEquals(apiYardStatus, dbData.get(0).get("status"));
        Assert.assertEquals(apiYardName, dbData.get(0).get("location"));
    }

    @Then("user validates created yard is persisted in DB")
    public void user_validates_created_yard_is_persisted_in_db() {

    }
}
