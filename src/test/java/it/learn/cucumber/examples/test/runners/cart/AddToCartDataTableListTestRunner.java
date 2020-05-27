package it.learn.cucumber.examples.test.runners.cart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/cart/add_to_cart_datatable-list.feature"}
        , glue = {"it.learn.cucumber.examples.test.defs.cart.datatable.list"
        , "it.learn.cucumber.examples.test.types.datatable.list"}
        , plugin = "de.monochromata.cucumber.report.PrettyReports:target/cucumber"
)
public class AddToCartDataTableListTestRunner {
}
