@regression @smoke @elarLogistics @api @Api_POST_GET
  Feature: Validating POST and GET call

    @Api_POST_Elar
    Scenario Outline: Validating POST Yard call
      Given user creates yard with POST api call and use token
        | name    | <name>    |
        | status  | <status>  |
        | street  | <street>  |
        | city    | <city>    |
        | state   | <state>   |
        | zipCode | <zipCode> |
        | spots   | <spots>   |
        | token   | <token>   |
        | statusCode | <statusCode> |
       When user connection to database of El
      Then user validates created yard is persisted in DB of Elar
      Examples:
        | name  | status | street      | city    | state | zipCode | spots | token                                          | statusCode |
        | Super | active | 123 street  | Chicago | IL    | 60173   | 123   | Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6 | 201        |
        | Stars | active | 1234 street | Chicago | IL    | 60172   | 1234  | null                                           | 201        |

      @Api_GET_Elar
      Scenario: Validating GET Yard call
        Given user taking Yard from DB by GET call and validates status code 200
        Then user validates created yard is persisted in DT of Elar
          | name  | status | street     | city    | state | zipCode | spots | token                                          |
          | Super | active | 123 street  | Chicago | IL    | 60173   | 123   | Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6 |

