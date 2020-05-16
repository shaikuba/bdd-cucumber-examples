package it.learn.cucumber.examples.test.defs.cart.selftype;

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

public class AddToCartSelfTypeStepDefinitions {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private CartService cartService;

    @Given("I have login in the shopping website")
    public void login() {
        person = new Person("ray");
        personService.login(person);
        cartService = new CartServiceImpl(Cart.of(person));
    }

    @When("I add {int} {goodsName} into the cart")
    public void addGoodsToCart(int amount, Goods goods) {
        cartService.addGoods(goods, amount);
    }

    @Then("I can see {int} {goodsName} in my cart")
    public void iCanSee(int amount, Goods goods) {
        Assert.assertEquals("I can not see my cellphone in my cart"
                , amount
                , cartService.getGoodsAmount(goods));
    }

    @And("The amount of the {goodsName} in the inventory should be {int}")
    public void theInventory(Goods goods, int remainder) {
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect."
                , Integer.valueOf(remainder)
                , Inventory.stockOf(goods));
    }


}
