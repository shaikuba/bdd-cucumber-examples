package it.learn.cucumber.examples.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
        , features = {"classpath:features/cart/add_cellphone_to_cart_parameterized.feature"}
        , glue = "it.learn.cucumber.examples.test.defs"
        , plugin = "html:target/cucumber"
)
public class AddCellphoneToCartParameterizedTestRunner {
}
