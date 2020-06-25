package it.learn.cucumber.examples.test.defs.cart.plain;

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

public class AddCellphoneToCartStepDefinitions {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private CartService cartService;

    @Given("I have login in the shopping website")
    public void login() {
        person = new Person("ray");
        personService.login(person);
        cartService = new CartServiceImpl(Cart.of(person));
    }

    @When("I add one cellphone into the cart")
    public void addGoodsToCart() {
        cartService.addGoods(new Goods("HuaWei"), 2);
    }

    @And("I subtract the amount of the cellphone in the inventory")
    public void subtractInventory() {
        //Inventory.subtract(new Goods("HuaWei"), 2);
    }

    @Then("I can see one cellphone in my cart")
    public void iCanSee() {
        Assert.assertEquals("I can not see my cellphone in my cart"
                , 2 , cartService.getGoodsAmount(new Goods("HuaWei")));
    }

    @And("The amount of the cellphone in the inventory should be 98")
    public void theInventory() {
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect."
                , Integer.valueOf(98) , Inventory.stockOf(new Goods("HuaWei")));
    }

}
