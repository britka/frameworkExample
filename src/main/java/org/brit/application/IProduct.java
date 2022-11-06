package org.brit.application;

import org.brit.models.ProductItem;

public interface IProduct extends IApplication{

    IProduct addProductToCart();
    IProduct removeProductFromCart();
    ProductItem getProductInfo();

    ProductItem getProductInformation();

    IAllItems backToProducts();
}