package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;

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
}
