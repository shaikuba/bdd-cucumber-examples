package it.learn.cucumber.examples.test.defs.cart.datatable.list;

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

import java.util.ArrayList;
import java.util.List;

public class AddToCartDataTableListStepDefinitions {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private CartService cartService;

    private List<Goods> goodsList = new ArrayList<>();


    @Given("I have login in the shopping website")
    public void login() {
        person = new Person("ray");
        personService.login(person);
        cartService = new CartServiceImpl(Cart.of(person));
    }

    @When("I add one cellphone into the cart")
    public void addGoodsToCart(List<Goods> goodsList) {
        goodsList.stream()
                .forEach(goods -> {
                    cartService.addGoods(goods, goods.getAmount());
                    this.goodsList.add(goods);
                });

    }

//    @When("I add one cellphone into the cart")
//    public void addGoodsToCart(List<Map<String, String>> tableListMap) {
//        tableListMap.stream()
//                .forEach(tableMap -> {
//                    Goods goods = new Goods(tableMap.get("name"));
//                    goods.setPrice(Float.parseFloat(tableMap.get("price")));
//                    goods.setAmount(Integer.parseInt(tableMap.get("amount")));
//                    cartService.addGoods(goods, goods.getAmount());
//                    goodsList.add(goods);
//                });
//
//    }

    @Then("I can see some cellphone in my cart")
    public void iCanSee() {
        goodsList.stream()
                .forEach(goods -> {
                    Assert.assertEquals("I can not see my cellphone in my cart"
                            , goods.getAmount()
                            , cartService.getGoodsAmount(goods));
                });
    }

    @And("The amount of the cellphone in the inventory should be incorrect")
    public void theInventory() {
        goodsList.stream()
                .forEach(goods -> {
                    Assert.assertEquals("The amount of the cellphone in the inventory is incorrect."
                            , 100 - goods.getAmount()
                            , Inventory.stockOf(goods).intValue());
                });
    }


}
