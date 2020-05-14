Feature: Add Another Cellphone to cart
  Add Another Cellphone to cart

  Scenario: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add one cellphone into the cart
    And I subtract the amount of the cellphone in the inventory
    Then I can see one cellphone in my cart
    And The amount of the cellphone in the inventory should be 98


