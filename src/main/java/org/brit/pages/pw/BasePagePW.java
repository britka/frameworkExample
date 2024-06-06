package org.brit.pages.pw;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.webdriver.PlaywrightDriver;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class BasePagePW {
    protected Page page = PlaywrightDriver.getInstance().getPage();

    MenuComponentPW menuComponent = new MenuComponentPW();
    Locator shopping_cart_link = page.locator(".shopping_cart_link");

    public MenuComponentPW menu() {
        return menuComponent;
    }

    public Integer getCartProductsCount() {
        if (shopping_cart_link.locator(".shopping_cart_badge").isVisible()) {
            return Integer.parseInt(shopping_cart_link.locator(".shopping_cart_badge").textContent());
        } else {
            return 0;
        }
    }

    public CartPagePW goToCart() {
        shopping_cart_link.click();
        return new CartPagePW();
    }

    @SneakyThrows
    public List<ProductItem> getProductItemsList(Locator itemCollection) {
        List<ProductItem> result = new ArrayList<>();
        for (Locator element : itemCollection.all()) {
            ProductItem productItem = new ProductItem();
            productItem
                    .itemName(element.locator(".inventory_item_name").textContent())
                    .description(element.locator(".inventory_item_desc").textContent())
                    .price(convertDollarStringToDouble(
                            element.locator(".inventory_item_price").textContent()));
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
