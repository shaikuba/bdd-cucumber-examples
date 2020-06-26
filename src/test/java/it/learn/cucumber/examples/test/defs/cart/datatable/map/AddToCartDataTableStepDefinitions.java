package it.learn.cucumber.examples.test.defs.cart.datatable.map;

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

public class AddToCartDataTableStepDefinitions {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private CartService cartService;

    @Given("I have login in the shopping website")
    public void login() {
        person = new Person("ray");
        personService.login(person);
        cartService = new CartServiceImpl(Cart.of(person));
    }

//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(Map<String, String> tableMap) {
//        String tableJsonString = JSON.toJSONString(tableMap);
//        Goods goods = JSON.parseObject(tableJsonString, Goods.class);
//        cartService.addGoods(goods, goods.getAmount());
//    }

//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(DataTable dataTable) {
//        Map tableMap = dataTable.asMap(String.class, String.class);
//        String tableJsonString = JSON.toJSONString(tableMap);
//        Goods goods = JSON.parseObject(tableJsonString, Goods.class);
//        cartService.addGoods(goods, goods.getAmount());
//    }
    @When("I add one cellphone into the cart")
    public void addGoodsToCart(Goods goods) {
        cartService.addGoods(goods, goods.getAmount());
    }

    @Then("I can see {int} {word} in my cart")
    public void iCanSee(int amount, String name) {
        Assert.assertEquals("I can not see my cellphone in my cart"
                , amount
                , cartService.getGoodsAmount(new Goods(name)));
    }

    @And("The amount of the {word} in the inventory should be {int}")
    public void theInventory(String name, int remainder) {
        Assert.assertEquals("The amount of the cellphone in the inventory is incorrect."
                , Integer.valueOf(remainder)
                , Inventory.stockOf(new Goods(name)));
    }


}
