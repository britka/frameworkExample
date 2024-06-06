package org.brit.pages.pw;

import org.brit.models.ProductItem;

public class ProductPagePW extends BasePagePW {

    public ProductPagePW addToCart() {
        page.locator("button[id^=add-to-cart]").click();
        return this;
    }

    public ProductPagePW removeFromCart() {
        page.locator("button[id^=remove-]").click();
        return this;
    }

    public ProductItem getProductInfo() {
        return getProductItemsList(page.locator(".inventory_details")).get(0);
    }

    public AllItemsPagePW backToProducts() {
        page.locator("#back-to-products").click();
        return new AllItemsPagePW();
    }
}
