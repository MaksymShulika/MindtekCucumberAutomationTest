@r @ui @etsy
Feature: Validating Search functionality

  # Background will run steps below once for each Scenario.
  Background: Setup for Etsy tests
    Given User navigates to Etsy application
    When User searches for "carpet"

    @itemDescription
  Scenario: Validating search result matches the searched item
    Then User validates search result contains
      | carpet  | rug     |
      | turkish | persian |
    # The values above are in a DataTable format.

  @priceRange
  Scenario: Validating price range functionality for searched item
    And User selects price range over 1000
    Then User validates price range for items over 1000