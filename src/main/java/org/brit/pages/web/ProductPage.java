package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public ProductItem getProductInformation() {
        ProductItem result = new ProductItem();
        SelenideElement element = $(".inventory_details_desc_container");
        result
                .itemName(element.$(".inventory_details_name.large_size").text())
                .description(element.$(".inventory_details_desc.large_size").text())
                .price(convertDollarStringToDouble(element.$(".inventory_details_price").text()));
        return result;
    }

    public boolean isOnPage(){
        return $("#back-to-products").is(Condition.visible);
    }

}
