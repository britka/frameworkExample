package org.brit.application.mobile;

import org.brit.application.IAllItems;
import org.brit.application.IProduct;
import org.brit.models.ProductItem;
import org.brit.pages.mobile.MobileProductPage;

public class MobileProduct extends MobileApplication implements IProduct {
    MobileProductPage mobileProductPage = new MobileProductPage();

    @Override
    public MobileProduct addProductToCart() {
        mobileProductPage.addToCart();
        return this;
    }

    @Override
    public MobileProduct removeProductFromCart() {
        mobileProductPage.removeFromCart();
        return this;
    }

    @Override
    public ProductItem getProductInfo() {
        return mobileProductPage.getProductInfo();
    }

    @Override
    public IAllItems backToProducts() {
        mobileProductPage.backToProducts();
        return new MobileAllItems();
    }
}
