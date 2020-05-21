package it.learn.cucumber.examples.test.types.datatable.list;

import com.alibaba.fastjson.JSON;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import it.learn.cucumber.examples.shopping.Goods;

import java.util.Locale;
import java.util.Map;

public class GoodsDataTableListTypeRegistry implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {

        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (Map<String, String> goodsMap) -> {
            String goodsJson = JSON.toJSONString(goodsMap);
            return JSON.parseObject(goodsJson, Goods.class);
        }));

//        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (List<String> row) -> {
//            Goods goods = new Goods();
//            goods.setName(row.get(0));
//            goods.setPrice(Float.parseFloat(row.get(1)));
//            goods.setAmount(Integer.parseInt(row.get(2)));
//            return goods;
//        }));
    }

}
