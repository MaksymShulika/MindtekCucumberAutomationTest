@regression @ui
Feature: Validating Login Functionality

  @smoke @loginPositive @WB-70
  Scenario: Validating login functionality with valid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    Then User is successfully logged in and lands on the homepage

  @smoke @loginNegative @MB-70
  Scenario: Validating login functionality with invalid credentials
    Given User navigates to application
    When User logs in with username "test" and password "Tester"
    Then User is validates error message "Invalid Login or Password."