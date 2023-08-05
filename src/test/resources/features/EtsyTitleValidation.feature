@r @ui @etsyTitleValidation
  Feature: Validating Etsy titles

    Scenario Outline: Validating title of each module
      Given User navigates to Etsy application
      When User clicks on "<Module>" module
      Then User validates the "<Title>" Favorites"
      Examples:
        | Module                        | Title                         |
        | Fashion favorites             | Fashion favorites             |
        | Jewelry & Accessories - Etsy  | Jewelry & Accessories - Etsy  |
        | Clothing & Shoes - Etsy       | Clothing & Shoes - Etsy       |
        | Home & Living - Etsy          | Home & Living - Etsy          |
        | Wedding & Party - Etsy        | Wedding & Party - Etsy        |
        | Toys & Entertainment - Etsy   | Toys & Entertainment - Etsy   |
        | Art & Collectibles - Etsy     | Art & Collectibles - Etsy     |
        | Craft Supplies & Tools - Etsy | Craft Supplies & Tools - Etsy |
        | The Etsy Gift Guide for 2023 - Etsy | The Etsy Gift Guide for 2023 \| Etsy |
