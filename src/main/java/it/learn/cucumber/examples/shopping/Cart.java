package it.learn.cucumber.examples.shopping;

import it.learn.cucumber.examples.context.LoginContext;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@Data
public class Cart extends BaseModel {

    private Person person;

    private Map<Goods, Integer> goodsMap = new HashMap<>();

    private Cart(Person person) {
        this.person = person;
        this.person.setCart(this);
    }

    public static Cart of(Person person) {
        LoginContext.loginRequired();
        return new Cart(person);
    }
}
