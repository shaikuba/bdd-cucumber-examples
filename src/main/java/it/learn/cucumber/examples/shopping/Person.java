package it.learn.cucumber.examples.shopping;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Person extends BaseModel {

    public Person(String username) {
        this.username = username;
    }
    private String username;

    private String nickname;

    private String password;

    private Cart cart;

    public Person cart(Cart cart) {
        this.cart = cart;
        return this;
    }

}
