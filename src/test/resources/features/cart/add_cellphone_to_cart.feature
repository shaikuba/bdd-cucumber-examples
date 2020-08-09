@shopping-example
Feature: Add one cellphone to cart
  Add one cellphone to cart

  Scenario: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add one cellphone into the cart
    Then I can see one cellphone in my cart
    And The amount of the cellphone in the inventory should be 99




