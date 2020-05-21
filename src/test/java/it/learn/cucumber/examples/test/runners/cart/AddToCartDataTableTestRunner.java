package it.learn.cucumber.examples.test.runners.cart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
        , features = {"classpath:features/cart/add_to_cart_datatable.feature"}
        , glue = {"it.learn.cucumber.examples.test.defs.cart.datatable",
        "it.learn.cucumber.examples.test.types.datatable"}
        , plugin = "html:target/cucumber"
)
public class AddToCartDataTableTestRunner {
}
