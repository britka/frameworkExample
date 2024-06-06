package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.IProduct;
import org.brit.models.ProductItem;
import org.brit.pages.pw.ProductPagePW;

public class WebProductPW extends WebApplicationPW implements IProduct {
    ProductPagePW productPage = new ProductPagePW();

    @Override
    public IProduct addProductToCart() {
        productPage.addToCart();
        return this;
    }

    @Override
    public IProduct removeProductFromCart() {
        productPage.removeFromCart();
        return this;
    }

    @Override
    public ProductItem getProductInfo() {
        return productPage.getProductInfo();
    }

    @Override
    public IAllItems backToProducts() {
        productPage.backToProducts();
        return new WebAllItemsPW();
    }
}
