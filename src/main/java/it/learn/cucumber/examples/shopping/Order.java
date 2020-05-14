package it.learn.cucumber.examples.shopping;

import lombok.Data;

@Data
public class Order extends BaseModel {

    private String orderNo = String.valueOf(System.currentTimeMillis());

    private String orderDetail;

    private Order() {
    }
    public static Order newOrder() {
        return new Order();
    }

}
