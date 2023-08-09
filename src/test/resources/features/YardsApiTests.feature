Feature: Validating Yard Api calls

  @YardApi
  Scenario: Validating POST Yard Api call
    Given user creates yard with post yard call with data
      | location | random      |
      | status   | active      |
      | Address  | 123 abc st. |
    When user connection to database
    Then user validates created yard is persisted in DB
