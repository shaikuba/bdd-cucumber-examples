package it.learn.cucumber.examples.service;

import it.learn.cucumber.examples.shopping.Cart;
import it.learn.cucumber.examples.shopping.Order;

public interface OrderService {

    Order generate(Cart cart);
}
