package it.learn.cucumber.examples.shopping;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@ToString
@Data
public class Goods extends BaseModel {

    private String name;

    private Float price;

    private int amount;

    public Goods() {}

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
