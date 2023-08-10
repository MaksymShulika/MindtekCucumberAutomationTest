package utillities;


import io.restassured.response.Response;

import java.util.Random;

import static  io.restassured.RestAssured.given;

public class RestAPITestCompanies {

    public static void main(String[] args){

        Random random = new Random();
        int nums = random.nextInt(900000000) + 1000000000;

        System.out.println("==============================================\n\n" +
                "                    |GET|" +
                "\n\n==============================================");

        given().baseUri("http://elarbridgelogisticsmindtek.space")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept", "application/json")
                .when().get("/companies/1/")
                .then().log().all().statusCode(200);

        System.out.println("==============================================\n\n" +
                "                    |POST|" +
                "\n\n==============================================");

        given().baseUri("http://elarbridgelogisticsmindtek.space")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"company_name\": \"ABC\",\n" +
                        "  \"company_type\": \"broker company\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"mc_number\": \""+nums+"\",\n" +
                        "  \"dot_number\": \""+nums+"\",\n" +
                        "  \"ifta\": true,\n" +
                        "  \"address\": \"5441 Main Avenue\",\n" +
                        "  \"apt_suite_company_co\": null,\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60539\",\n" +
                        "  \"insurance\": \"Progressive\",\n" +
                        "  \"producer_address\": \"4567 Levaine Avenue\",\n" +
                        "  \"producer_apt_suite_company_co\": null,\n" +
                        "  \"producer_city\": \"Lombard\",\n" +
                        "  \"producer_state\": \"IL\",\n" +
                        "  \"producer_zip_code\": \"45789\",\n" +
                        "  \"policy_effective_day\": null,\n" +
                        "  \"policy_expiration\": null,\n" +
                        "  \"type_of_insurance\": null,\n" +
                        "  \"automobile_liability\": \"\",\n" +
                        "  \"num_of_truck_insured\": null,\n" +
                        "  \"policy_number\": null,\n" +
                        "  \"employer_id_num\": \"12-3456789\",\n" +
                        "  \"billing_address\": null,\n" +
                        "  \"bank_name\": null,\n" +
                        "  \"routing_number\": null,\n" +
                        "  \"account_number\": null,\n" +
                        "  \"president_full_name\": null,\n" +
                        "  \"trucks_in_fleet\": null,\n" +
                        "  \"scac_code\": \"\",\n" +
                        "  \"other_licenses\": false,\n" +
                        "  \"license_name\": null,\n" +
                        "  \"incorporated_in\": null,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"please Pay in time\",\n" +
                        "  \"company_picture\": [],\n" +
                        "  \"company_documents\": [],\n" +
                        "  \"contacts\": [\n" +
                        "    {\n" +
                        "      \"phone\": \"773-315-3678\",\n" +
                        "      \"ext\": \"\",\n" +
                        "      \"contact_name\": \"\",\n" +
                        "      \"email\": \"marielagongales@gmail.com\",\n" +
                        "      \"fax\": \"\",\n" +
                        "      \"producer_phone\": \"775-315-3677\",\n" +
                        "      \"producer_phone_ext\": \"\",\n" +
                        "      \"producer_contact_name\": \"\",\n" +
                        "      \"producer_email\": \"ginapistol@gmail.com\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"phone_number\": [\n" +
                        "    {\n" +
                        "      \"phone\": \"773-315-3678\",\n" +
                        "      \"ext\": \"\",\n" +
                        "      \"contact_name\": \"\",\n" +
                        "      \"email\": \"marielagongales@gmail.com\",\n" +
                        "      \"fax\": \"\",\n" +
                        "      \"producer_phone\": \"775-315-3677\",\n" +
                        "      \"producer_phone_ext\": \"\",\n" +
                        "      \"producer_contact_name\": \"\",\n" +
                        "      \"producer_email\": \"ginapistol@gmail.com\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"fax_number\": [\n" +
                        "    {\n" +
                        "      \"fax\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"email_number\": [\n" +
                        "    {\n" +
                        "      \"email\": \"marielagongales@gmail.com\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"producer_email_number\": [\n" +
                        "    {\n" +
                        "      \"producer_email\": \"ginapistol@gmail.com\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"producer_phone_number\": [\n" +
                        "    {\n" +
                        "      \"producer_phone\": \"775-315-3677\",\n" +
                        "      \"producer_phone_ext\": \"\",\n" +
                        "      \"producer_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/companies/")
                .then().log().all().statusCode(201);

        System.out.println("==============================================\n\n" +
                "                    |PATCH|" +
                "\n\n==============================================");

        given().baseUri("http://elarbridgelogisticsmindtek.space")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"alert\": [],\n" +
                        "  \"contacts\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"email\": \"abc@gmail.com\",\n" +
                        "      \"phone\": \"123-456-7898\",\n" +
                        "      \"ext\": \"\",\n" +
                        "      \"contact_name\": \"\",\n" +
                        "      \"fax\": \"\",\n" +
                        "      \"producer_email\": \"abc@gmail.com\",\n" +
                        "      \"producer_phone\": \"123-456-7890\",\n" +
                        "      \"producer_phone_ext\": \"\",\n" +
                        "      \"producer_contact_name\": \"\",\n" +
                        "      \"service_phone\": \"\",\n" +
                        "      \"service_contact_name\": \"\",\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"company_name\": \"Mindtek Club"+nums+"\",\n" +
                        "  \"company_type\": \"broker company\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"mc_number\": \"1234567898\",\n" +
                        "  \"dot_number\": \"1234567890\",\n" +
                        "  \"ifta\": false,\n" +
                        "  \"address\": \"123 Abc St.\",\n" +
                        "  \"apt_suite_company_co\": null,\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60656\",\n" +
                        "  \"insurance\": \"Abc\",\n" +
                        "  \"producer_address\": \"123 abc st.\",\n" +
                        "  \"producer_apt_suite_company_co\": null,\n" +
                        "  \"producer_city\": \"Chicago\",\n" +
                        "  \"producer_state\": \"IL\",\n" +
                        "  \"producer_zip_code\": \"60656\",\n" +
                        "  \"policy_effective_day\": null,\n" +
                        "  \"policy_expiration\": null,\n" +
                        "  \"type_of_insurance\": null,\n" +
                        "  \"automobile_liability\": \"\",\n" +
                        "  \"num_of_truck_insured\": null,\n" +
                        "  \"policy_number\": null,\n" +
                        "  \"employer_id_num\": \"Na063MNlh2INH4kOItaZUg==\",\n" +
                        "  \"billing_address\": null,\n" +
                        "  \"bank_name\": null,\n" +
                        "  \"routing_number\": null,\n" +
                        "  \"account_number\": null,\n" +
                        "  \"president_full_name\": null,\n" +
                        "  \"trucks_in_fleet\": null,\n" +
                        "  \"scac_code\": \"\",\n" +
                        "  \"other_licenses\": false,\n" +
                        "  \"incorporated_in\": null,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": null,\n" +
                        "  \"company_documents\": [],\n" +
                        "  \"license_name\": null,\n" +
                        "  \"logging\": {\n" +
                        "    \"count\": 24,\n" +
                        "    \"next\": \"http://elarbridgelogisticsmindtek.space/companies/1/?limit=10&offset=10\",\n" +
                        "    \"previous\": null,\n" +
                        "    \"results\": [\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Status\",\n" +
                        "        \"field_value\": \"Active\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:37 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Status\",\n" +
                        "        \"field_value\": \"Non-active\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:37 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Company name\",\n" +
                        "        \"field_value\": \"Mindtek Club\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:37 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Other licenses\",\n" +
                        "        \"field_value\": \"No\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Employer id num\",\n" +
                        "        \"field_value\": \"*********\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Producer email 1\",\n" +
                        "        \"field_value\": \"abc@gmail.com\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Producer zip code\",\n" +
                        "        \"field_value\": \"60656\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Producer state\",\n" +
                        "        \"field_value\": \"Illinois\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Producer city\",\n" +
                        "        \"field_value\": \"Chicago\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"user\": {\n" +
                        "          \"id\": 3,\n" +
                        "          \"full_name\": \"Student\"\n" +
                        "        },\n" +
                        "        \"content_object\": \"Mindtek Club\",\n" +
                        "        \"field_name\": \"Producer address\",\n" +
                        "        \"field_value\": \"123 abc st.\",\n" +
                        "        \"timestamp\": \"05/24/2023 07:36 PM\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .when().patch("/companies/1/")
                .then().log().all().statusCode(200);







    }
}
