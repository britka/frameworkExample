package org.brit.pages.pw;

import com.microsoft.playwright.Locator;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;

import java.util.List;

public class AllItemsPagePW extends BasePagePW {

    @SneakyThrows
    public List<ProductItem> getAllItemsFromPage() {
        Locator itemElements = page.locator(".inventory_item");
        return getProductItemsList(itemElements);
    }

    public boolean isOnPage(){
        return page.locator("#react-burger-menu-btn").isVisible();
    }

    public AllItemsPagePW addProductToCard(String productName) {
        page.locator("//div[@class='inventory_item_name '][text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']"
                + "//button[starts-with(@name, 'add-to-cart')]")
                .click();
        return this;
    }

    public AllItemsPagePW removeFromCart(String productName) {
        page.locator("//div[@class='inventory_item_name '][text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']"
                + "//button[starts-with(@name, 'remove-')]")
                .click();
        return this;
    }

    public AllItemsPagePW sort(SortDirection sortDirection) {
        page.locator(".product_sort_container").selectOption(sortDirection.getValue());
        return new AllItemsPagePW();
    }

    public ProductPagePW selectProduct(String productName) {
        page.locator("//div[@class='inventory_item_label']/a[contains(.,'" + productName + "')]")
                .click();
        return new ProductPagePW();
    }


}
