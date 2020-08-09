package examples.test;

import it.learn.cucumber.examples.service.impl.CartServiceImpl;
import it.learn.cucumber.examples.shopping.Cart;
import it.learn.cucumber.examples.shopping.Goods;
import it.learn.cucumber.examples.shopping.Inventory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class CartServiceTest extends ServiceBaseTestCase {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock(stubOnly = true)
    private Cart cart;

    @After
    public void tearDown() {
        Inventory.reset();
    }

    @Test
    public void addGoodsTest() {
        Map<Goods, Integer> goodsMap = new HashMap<>();
        goodsMap.put(new Goods("Apple"), 10);

        when(cart.getGoodsMap()).thenReturn(goodsMap);

        cartService.addGoods(new Goods("Apple"), 12);
        verify(cart, only()).getGoodsMap();
    }

    @Test
    public void addGoodsStubTest() {
        Map<Goods, Integer> goodsMap = new HashMap<>();
        goodsMap.put(new Goods("Apple"), 10);

        doReturn(goodsMap).when(cart).getGoodsMap();

        cartService.addGoods(new Goods("Apple"), 12);
        Assert.assertEquals(Inventory.stockOf("Apple").intValue(), 88);
    }
}
