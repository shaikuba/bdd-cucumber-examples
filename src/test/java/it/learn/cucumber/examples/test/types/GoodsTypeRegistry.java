package it.learn.cucumber.examples.test.types;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import it.learn.cucumber.examples.shopping.Goods;

import java.util.Locale;

public class GoodsTypeRegistry implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType("goodsName", "\\w+", Goods.class, this::goodsTransformer));
    }

    private Goods goodsTransformer(String parameterName) {
        return new Goods(parameterName);
    }

    class GoodsTransfer implements CaptureGroupTransformer<Goods> {

        @Override
        public Goods transform(String[] strings) throws Throwable {
            return new Goods(strings[0]);
        }
    }
}
