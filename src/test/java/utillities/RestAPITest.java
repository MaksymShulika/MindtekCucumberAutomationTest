package utillities;

import io.restassured.response.Response;//!!!!!!!!!
import static  io.restassured.RestAssured.given;//typing

public class RestAPITest {
    //RestAssure

    public static void main(String[] args){
        /*
        Make get yard api call.
            Request
                1. URL -> BaserURL & Endpoint -> http://3.137.169.132/en-us/api/v2
                2. Headers -> Authorization(Token), Accept(application/json)
                3. Method -> GET
            Response
                1. Status code
                2. Json Data
         */

//        Response response =
        given().baseUri("http://elarbridgelogisticsmindtek.space")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept", "application/json")
                .when().get("/yards/10/")
                        .then().log().all();
                        //.then().statusCode(400)

//        System.out.println(response.statusCode());
//        System.out.println(response.body().asString());

        /*
        POST call
            Request:
                1. URL -> BaseURL + Endpoint
                2. Headers -> Authorization(Token), Content-Type(application/json), Accept(application/json)
                3. Payload/Body -> json
                4. Method -> POST
            Response:
                1. Status code -> 201
                2. Body -> json
         */
        Response postResponse = given().baseUri("http://elarbridgelogisticsmindtek.space")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \"Maks3\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"123\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"12345\",\n" +
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
                .when().post("/yards/");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body().asString());

        /*
        Path Call
            Request:
                1. URL -> BaseURL + Endpoint
                2. Headers -> Authorization(Token), Accept(application/json), Content-type(application/json)
                3. Payload -> json
                4. Method -> PATCH
            Response:
                1. Status code -> 200
                2. Body -> json
         */

        Response updateResponse = given().baseUri(ConfigReader.getProperty("ElarAPIBaseUri"))
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 53,\n" +
                        "  \"contacts\": [],\n" +
                        "  \"name\": \"You228\",\n" +
                        "  \"location\": \"Maks Mindtek 45\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"321123\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"12345\",\n" +
                        "  \"spots\": 123,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"yard_pictures\": [],\n" +
                        "  \"logging\": {\n" +
                        "    \"count\": 7,\n" +
                        "    \"next\": null,\n" +
                        "    \"previous\": null,\n" +
                        "    \"results\": [\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"Spots\",\n" +
                        "        \"field_value\": \"123\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"Zip code\",\n" +
                        "        \"field_value\": \"12345\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"State\",\n" +
                        "        \"field_value\": \"Illinois\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"City\",\n" +
                        "        \"field_value\": \"Chicago\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"Address\",\n" +
                        "        \"field_value\": \"123\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"Status\",\n" +
                        "        \"field_value\": \"Active\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Y53\",\n" +
                        "        \"field_name\": \"Location\",\n" +
                        "        \"field_value\": \"Maks2\",\n" +
                        "        \"timestamp\": \"08/01/2023 08:39 PM\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .when().patch("/yards/53/");

        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());

    }
}
