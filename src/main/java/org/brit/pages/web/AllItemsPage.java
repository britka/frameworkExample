package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.checkerframework.checker.units.qual.A;

public class AllItemsPage extends BasePage {

    @SneakyThrows
    public List<ProductItem> getAllItemsFromPage() {
        ElementsCollection itemElements = $$(".inventory_item");
        return getProductItemsList(itemElements);
    }

    public boolean isOnPage(){
        return $("#react-burger-menu-btn").is(Condition.visible);
    }

    public AllItemsPage addProductToCard(String productName) {
        $x("//div[@class='inventory_item_name'][text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']"
                + "//button[starts-with(@name, 'add-to-cart')]")
                .click();
        return this;
    }

    public AllItemsPage removeFromCart(String productName) {
        $x("//div[@class='inventory_item_name'][text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']"
                + "//button[starts-with(@name, 'remove-')]")
                .click();
        return this;
    }

    public AllItemsPage sort(SortDirection sortDirection) {
        $(".product_sort_container").selectOptionByValue(sortDirection.getValue());
        return new AllItemsPage();
    }

    public ProductPage selectProduct(String productName) {
        $x("//div[@class='inventory_item_label']/a[contains(.,'" + productName + "')]")
                .click();
        return new ProductPage();
    }


}
