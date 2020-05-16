Feature: Add Another Cellphone to cart
  Add Another Cellphone to cart

  Scenario Outline: Add cellphone to cart with sufficient stock

    Given I have login in the shopping website
    When I add <amount> <goodsName> into the cart
    Then I can see <amount> <goodsName> in my cart
    And The amount of the <goodsName> in the inventory should be <remainder>


    Examples:
      | amount | remainder | goodsName |
      | 1      | 99        | HuaWei    |
      | 3      | 97        | Apple     |
      | 5      | 95        | XiaoMi    |

