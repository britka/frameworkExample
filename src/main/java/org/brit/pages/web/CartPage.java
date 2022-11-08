package org.brit.pages.web;

import com.codeborne.selenide.ElementsCollection;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    public AllItemsPage continueShopping() {
        $("#continue-shopping").click();
        return new AllItemsPage();
    }

    @SneakyThrows
    public List<ProductItem> getProductItemsList() {
        ElementsCollection itemElements = $$(".cart_item");
        return getProductItemsList(itemElements);
    }

    public CartPage removeProductFromCart(String productName) {
        $x("//div[@class='inventory_item_name'][text()='" + productName + "']"
                + "/ancestor::div[@class='cart_item']"
                + "//button[starts-with(@name, 'remove-')]")
                .click();
        return new CartPage();
    }

    public CheckOut1Page checkout() {
        $("#checkout").click();
        return new CheckOut1Page();
    }

    public void clearCartFromProducts() {
        List<ProductItem> productItemsList = getProductItemsList();
        productItemsList.clear();
    }
}
