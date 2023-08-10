Feature: Validating booking api calls

  @MB8-101 @smoke @regression @api
  Scenario: Validating POST booking Aip call
    Given user creates booking with POST api call with data
      | firstName       | Jim        |
      | lastname        | Brown      |
      | totalprice      | 111        |
      | checkin         | 2018-01-01 |
      | checkout        | 2019-01-01 |
      | additionalneeds | Breakfast  |
    When user gets created booking with GET api call
    Then user validates 200 status code
    And user validates created data matches with response of get call