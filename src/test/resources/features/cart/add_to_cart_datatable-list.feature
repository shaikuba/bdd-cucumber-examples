@datatable-list
Feature: Add Another Cellphone to cart
  Add Another Cellphone to cart

  @demo
  Scenario: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add one cellphone into the cart
      | name   | price | amount |
      | HuaWei | 1000  | 1      |
      | Apple  | 1500  | 3      |
      | XiaoMi | 800   | 5      |
    Then I can see some cellphone in my cart
    And The amount of the cellphone in the inventory should be incorrect