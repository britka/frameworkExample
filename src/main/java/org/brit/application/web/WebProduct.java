package org.brit.application.web;

import org.brit.application.IAllItems;
import org.brit.application.IProduct;
import org.brit.models.ProductItem;
import org.brit.pages.web.ProductPage;

public class WebProduct extends WebApplication implements IProduct {
    ProductPage productPage = new ProductPage();

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
    public ProductItem getProductInformation() {
        return null;
    }

    @Override
    public IAllItems backToProducts() {
        productPage.backToProducts();
        return new WebAllItems();
    }
}
