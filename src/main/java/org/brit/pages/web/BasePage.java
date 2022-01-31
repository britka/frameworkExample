package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;

public class BasePage {

    MenuComponent menuComponent = new MenuComponent();
    SelenideElement shopping_cart_link = $(".shopping_cart_link");

    public MenuComponent menu() {
        return menuComponent;
    }

    public Integer getCartProductsCount() {
        if (shopping_cart_link.$(".shopping_cart_badge").is(Condition.visible)) {
            return Integer.parseInt(shopping_cart_link.$(".shopping_cart_badge").text());
        } else {
            return 0;
        }
    }

    public CartPage goToCart() {
        shopping_cart_link.click();
        return new CartPage();
    }

    @SneakyThrows
    public List<ProductItem> getProductItemsList(ElementsCollection itemCollection) {
        List<ProductItem> result = new ArrayList<>();
        for (SelenideElement element : itemCollection) {
            ProductItem productItem = new ProductItem();
            productItem
                    .itemName(element.$(".inventory_item_name").text())
                    .description(element.$(".inventory_item_desc").text())
                    .price(convertDollarStringToDouble(element.$(".inventory_item_price").text()));
            result.add(productItem);
        }
        return result;
    }

    @SneakyThrows
    public Double convertDollarStringToDouble(String dollarsAsString) {
        NumberFormat nf = new DecimalFormat("$#,###.00");
        return nf.parse(dollarsAsString).doubleValue();
    }
}
