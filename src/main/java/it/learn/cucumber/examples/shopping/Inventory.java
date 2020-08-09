package it.learn.cucumber.examples.shopping;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private static final Map<Goods, Integer> GOODS_INVENTORY = new HashMap<>();

    static {
        reset();
    }

    public static Integer stockOf(String name) {
        return stockOf(new Goods(name));
    }

    public static Integer stockOf(Goods goods) {
        return GOODS_INVENTORY.getOrDefault(goods, 0);
    }

    public static void add(Goods goods, int amount) {
        GOODS_INVENTORY.put(goods, GOODS_INVENTORY.get(goods) + amount);
    }

    public static void subtract(Goods goods, int amount) {
        if (GOODS_INVENTORY.get(goods) - amount < 0) {
            throw new RuntimeException("No sufficient stock available.");
        }
        GOODS_INVENTORY.put(goods, GOODS_INVENTORY.get(goods) - amount);
    }

    public static void reset() {
        GOODS_INVENTORY.put(new Goods("HuaWei"), 100);
        GOODS_INVENTORY.put(new Goods("XiaoMi"), 100);
        GOODS_INVENTORY.put(new Goods("Apple"), 100);
        GOODS_INVENTORY.put(new Goods("Oppo"), 100);
        GOODS_INVENTORY.put(new Goods("Vivo"), 100);
    }

}
