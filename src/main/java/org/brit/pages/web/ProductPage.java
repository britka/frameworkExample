package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.brit.models.ProductItem;
import org.checkerframework.checker.units.qual.A;

public class ProductPage extends BasePage {

    public ProductPage addToCart() {
        $("button[id^=add-to-cart]").click();
        return this;
    }

    public ProductPage removeFromCart() {
        $("button[id^=remove-]").click();
        return this;
    }

    public ProductItem getProductInfo() {
        return getProductItemsList($$(".inventory_details")).get(0);
    }

    public AllItemsPage backToProducts() {
        $("#back-to-products").click();
        return new AllItemsPage();
    }
}
