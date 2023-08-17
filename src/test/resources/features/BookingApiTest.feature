Feature: Validating booking api calls

  @MB8-101 @smoke @regression @api
  Scenario Outline: Validating POST booking Aip call
    Given user creates booking with POST api call with data
      | firstName       | <firstName>       |
      | lastname        | <lastname>        |
      | totalprice      | <totalpric>       |
      | checkin         | <checkin>         |
      | checkout        | <checkout>        |
      | additionalneeds | <additionalneeds> |
    When user gets created booking with GET api call
    Then user validates <statusCode> status code
    And user validates created data matches with response of get call
    Examples:
      | firstName | lastname | totalpric | checkin    | checkout   | additionalneeds | statusCode |
      | Jim       | Brown    | 111       | 2018-01-01 | 2019-01-01 | Breakfast       | 200        |
      | Patel     | Harsh    | 1000      | 2019-01-01 | 2019-02-02 | Bicycle         | 200        |
      | Kim       | Yan      | 2000      | 2020-01-01 | 2019-01-02 | Sushi           | 404        |
    #Data Driven Testing -> Testing functionality with different sets of data

  @MB8-102 @smoke @regression @api
  Scenario: Validating PUT booking Api call
    Given  user creates booking with POST api call with data
      | firstName       | Jim        |
      | lastname        | Brown      |
      | totalprice      | 111        |
      | checkin         | 2023-01-01 |
      | checkout        | 2023-02-02 |
      | additionalneeds | Breakfast  |
    When user updates booking with PUT updates booking with PUT api call with data
      | firstname | James      |
      | checkin   | 2023-02-02 |
      | checkout  | 2023-03-03 |
    And user gets updated booking with GET api call
    Then user validates 200 status code
    And user validates updated data matches with response of get call

    @MB8-105 @smoke @regression @api
      Scenario: Validating DELETE booking Api call
      Given  user creates booking with POST api call with data
        | firstName       | Jim        |
        | lastname        | Brown      |
        | totalprice      | 111        |
        | checkin         | 2023-01-01 |
        | checkout        | 2023-02-02 |
        | additionalneeds | Breakfast  |
      When user deletes created booking with DELETE api call
      And user gets deleted booking with GET api call
      Then user validates 404 status code

      @MB8-106 @smoke @regression @api
        Scenario: Validating DELETE booking api call with no authorization token
        Given  user creates booking with POST api call with data
          | firstName       | Jim        |
          | lastname        | Brown      |
          | totalprice      | 111        |
          | checkin         | 2023-01-01 |
          | checkout        | 2023-02-02 |
          | additionalneeds | Breakfast  |
        When user deletes created booking with DELETE api call without authorization token
        Then  user validates 403 status code


