package it.learn.cucumber.examples.test.defs.cart.parameterized;

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

public class AddCellphoneToCartParameterizedStepDefinitions {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private CartService cartService;

    @Given("I have login in the cellphone shopping website")
    public void login() {
        person = new Person("ray");
        personService.login(person);
        cartService = new CartServiceImpl(Cart.of(person));
    }

    @When("I add {int} cellphone into the cart")
    public void addGoodsToCart(int amount) {
        cartService.addGoods(new Goods("HuaWei"), amount);
    }

    @Then("I can see {int} cellphone in my cart")
    public void iCanSee(int amount) {
        Assert.assertEquals("I can not see my cellphone in my cart"
                , amount
                , cartService.getGoodsAmount(new Goods("HuaWei")));
    }

    @And("The amount of the cellphone in the inventory should be {int}")
    public void theInventory(int remainder) {
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect."
                , Integer.valueOf(remainder)
                , Inventory.stockOf(new Goods("HuaWei")));
    }

}
