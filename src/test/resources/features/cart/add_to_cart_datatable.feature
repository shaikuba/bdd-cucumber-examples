Feature: Add Another Cellphone to cart
  Add Another Cellphone to cart

  Scenario Outline: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add one cellphone into the cart
      | name   | <goodsName> |
      | price  | <price>     |
      | amount | <amount>    |
    Then I can see <amount> <goodsName> in my cart
    And The amount of the <goodsName> in the inventory should be <remainder>


    Examples:
      | goodsName | price | amount | remainder |
      | HuaWei    | 1000  | 1      | 99        |
      | Apple     | 1500  | 3      | 97        |
      | XiaoMi    | 800   | 5      | 95        |

