@regression @smoke @elarLogistics @api @Api_POST_GET
Feature: Validating POST and GET call

  @Api_POST_Elar
  Scenario Outline: Validating POST Yard call
    Given user creates yard with POST api call and validates <statusCode>
      | name       | <name>       |
      | status     | <status>     |
      | street     | <street>     |
      | city       | <city>       |
      | state      | <state>      |
      | zipCode    | <zipCode>    |
      | spots      | <spots>      |
      | token      | <token>      |
    Then user validates created yard is persisted in DB of Elar
    Examples:
      | name  | status | street      | city    | state | zipCode | spots | token                                          | statusCode |
      | Super | active | 123 street  | Chicago | IL    | 60173   | 123   | Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6 | 201        |
      | Stars | active | 1234 street | Chicago | IL    | 60172   | 1234  | null                                           | 401        |

  @Api_GET_Elar
  Scenario: Validating GET Yard call
    Given user use GET api call and validates status code 200
    Then user validates created GET call response bode is matching to input info
