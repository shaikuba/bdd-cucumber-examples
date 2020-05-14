package it.learn.cucumber.examples.service.impl;

import it.learn.cucumber.examples.service.OrderService;
import it.learn.cucumber.examples.shopping.Cart;
import it.learn.cucumber.examples.shopping.Goods;
import it.learn.cucumber.examples.shopping.Order;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order generate(Cart cart) {

        Order order = Order.newOrder();

        Map<Goods, Integer> goodsMap = cart.getGoodsMap();
        StringBuilder orderBuilder = new StringBuilder();
        AtomicReference<Double> totalPrice = new AtomicReference<>(0.0);
        goodsMap.forEach((goods, amount) -> {
            orderBuilder
                    .append(String.format("Goods: %s, Amount: %d, Unit-Price: %f, Total-Price: %f",
                            goods.getName(), amount, goods.getPrice(), amount * goods.getPrice()))
                    .append("\n");

            totalPrice.updateAndGet(v -> v + amount * goods.getPrice());
        });

        orderBuilder.append(String.format("Summation: %f", totalPrice.get())).append("\n");
        orderBuilder.append(String.format("Order No: %f", order.getOrderNo())).append("\n");

        order.setOrderDetail(orderBuilder.toString());

        return order;
    }
}
