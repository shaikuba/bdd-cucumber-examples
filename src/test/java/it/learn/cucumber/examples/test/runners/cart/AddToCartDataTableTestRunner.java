package it.learn.cucumber.examples.test.runners.cart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/cart/add_to_cart_datatable.feature"}
        , glue = {"it.learn.cucumber.examples.test.defs.cart.datatable.map",
        "it.learn.cucumber.examples.test.types.goods"}
        , plugin = "html:target/cucumber"
)
public class AddToCartDataTableTestRunner {
}
