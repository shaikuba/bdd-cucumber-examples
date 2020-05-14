package it.learn.cucumber.examples.service;

import it.learn.cucumber.examples.shopping.Goods;
import it.learn.cucumber.examples.shopping.Order;

public interface CartService {

    void addGoods(Goods goods, int amount);

    int getGoodsAmount(Goods goods);

    void checkout(Order order);

}
