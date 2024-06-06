package org.brit.pages.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.webdriver.PlaywrightDriver;

import java.util.List;

public class CartPagePW extends BasePagePW {
    private Page page = PlaywrightDriver.getInstance().getPage();

    public AllItemsPagePW continueShopping() {
        page.locator("#continue-shopping").click();
        return new AllItemsPagePW();
    }

    @SneakyThrows
    public List<ProductItem> getProductItemsList() {
        Locator itemElements = page.locator(".cart_item");
        return getProductItemsList(itemElements);
    }

    public CartPagePW removeProductFromCart(String productName) {
        page.locator("//div[@class='inventory_item_name'][text()='" + productName + "']"
                + "/ancestor::div[@class='cart_item']"
                + "//button[starts-with(@name, 'remove-')]")
                .click();
        return new CartPagePW();
    }

    public CheckOut1PagePW checkout() {
        page.locator("#checkout").click();
        return new CheckOut1PagePW();
    }
}
