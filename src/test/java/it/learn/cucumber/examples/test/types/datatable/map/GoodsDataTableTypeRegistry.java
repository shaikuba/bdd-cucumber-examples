package it.learn.cucumber.examples.test.types.datatable.map;

import com.alibaba.fastjson.JSON;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import it.learn.cucumber.examples.shopping.Goods;

import java.util.Locale;
import java.util.Map;

public class GoodsDataTableTypeRegistry implements TypeRegistryConfigurer {

    DataTableTypeRegistry typeRegistry = new DataTableTypeRegistry(Locale.ENGLISH);
    DataTable.TableConverter tableConverter = new DataTableTypeRegistryTableConverter(typeRegistry);

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {

        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (DataTable dataTable) -> {
            Map<String, String> tableMap = tableConverter.toMap(dataTable, String.class, String.class);
            String tableJsonString = JSON.toJSONString(tableMap);
            Goods goods = JSON.parseObject(tableJsonString, Goods.class);
            return goods;
        }));


//        typeRegistry.defineDataTableType(new DataTableType(Goods.class, (DataTable dataTable) -> {
//            Goods goods = new Goods();
//            goods.setName(dataTable.cell(0, 1));
//            goods.setPrice(Float.parseFloat(dataTable.cell(1, 1)));
//            goods.setAmount(Integer.parseInt(dataTable.cell(2, 1)));
//            return goods;
//        }));
    }

}
