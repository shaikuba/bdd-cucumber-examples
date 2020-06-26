package it.learn.cucumber.examples.test.defs.cart.expression;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import it.learn.cucumber.examples.service.CartService;
import it.learn.cucumber.examples.service.PersonService;
import it.learn.cucumber.examples.service.impl.CartServiceImpl;
import it.learn.cucumber.examples.service.impl.PersonServiceImpl;
import it.learn.cucumber.examples.shopping.Cart;
import it.learn.cucumber.examples.shopping.Goods;
import it.learn.cucumber.examples.shopping.Inventory;
import it.learn.cucumber.examples.shopping.Person;
import org.junit.Assert;

public class AddToCartExpressionStepDefinitions {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private CartService cartService;

    @Given("I have login in the shopping website")
    public void login() {
        person = new Person("ray");
        personService.login(person);
        cartService = new CartServiceImpl(Cart.of(person));
    }

    @When("I add (\\d+) (\\w+) into the cart")
    public void addGoodsToCart(int amount, String goodsName) {
        cartService.addGoods(getGoodsByName(goodsName), amount);
    }

    @Then("I can see {int} {word} in my cart")
    public void iCanSee(int amount, String goodsName) {
        Assert.assertEquals("I can not see my cellphone in my cart"
                , amount
                , cartService.getGoodsAmount(getGoodsByName(goodsName)));
    }

    @And("The amount of the {word} in the inventory should be {int}")
    public void theInventory(String goodsName, int remainder) {
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect."
                , Integer.valueOf(remainder)
                , Inventory.stockOf(getGoodsByName(goodsName)));
    }

    private Goods getGoodsByName(String goodsName) {
        return new Goods(goodsName);
    }

}
