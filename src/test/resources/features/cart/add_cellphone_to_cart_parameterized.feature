Feature: Add Another Cellphone to cart
  Add Another Cellphone to cart

  Scenario Outline: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add <amount> cellphone into the cart
    Then I can see <amount> cellphone in my cart
    And The amount of the cellphone in the inventory should be <remainder>

    Examples:
    |amount | remainder|
    |       |          |

