@regression @iu @porscheCar
Feature:

#  @priceAndBasePrice
#  Scenario: Validating Porsche Price
#    Given user navigates to Porsche Car application
#    When user stores the price and selects the model 718 Cayman
#    Then user validates Base price is matched with listed price

    @priceAndBasePriceWithOptions
  Scenario: Validating Porsche Price For Equipment
    Given user navigates to Porsche Car application
    When user stores the price and selects the model 718 Cayman
    And user adds Power Sport Seats (14-way) with Memory Package
    Then user validates that Price For Equipment is added and price matches