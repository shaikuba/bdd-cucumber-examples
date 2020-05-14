package it.learn.cucumber.examples.service.impl;

import it.learn.cucumber.examples.context.LoginContext;
import it.learn.cucumber.examples.service.CartService;
import it.learn.cucumber.examples.shopping.Cart;
import it.learn.cucumber.examples.shopping.Goods;
import it.learn.cucumber.examples.shopping.Inventory;
import it.learn.cucumber.examples.shopping.Order;
import lombok.Data;

import java.util.Map;

@Data
public class CartServiceImpl implements CartService {

    private Cart cart;

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addGoods(Goods goods, int amount) {

        Map<Goods, Integer> goodsMap = cart.getGoodsMap();

        if (Inventory.stockOf(goods) <= 0) {
            throw new RuntimeException("No sufficient goods in inventory.");
        }
        if (goodsMap.get(goods) != null) {
            goodsMap.put(goods, goodsMap.get(goods) + amount);
        } else {
            goodsMap.put(goods, amount);
        }

        Inventory.subtract(goods, amount);
    }

    @Override
    public int getGoodsAmount(Goods goods) {
        return cart.getGoodsMap().getOrDefault(goods, 0);
    }

    @Override
    public void checkout(Order order) {
        LoginContext.loginRequired();
        new OrderServiceImpl().generate(cart);
    }
}
