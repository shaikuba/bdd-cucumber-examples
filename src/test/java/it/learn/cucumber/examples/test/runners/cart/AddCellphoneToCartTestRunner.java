package it.learn.cucumber.examples.test.runners.cart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
        , features = {"classpath:features/cart/add_cellphone_to_cart.feature"}
        , glue = "it.learn.cucumber.examples.test.defs.cart"
        , plugin = "html:target/cucumber"
)
public class AddCellphoneToCartTestRunner {
}
