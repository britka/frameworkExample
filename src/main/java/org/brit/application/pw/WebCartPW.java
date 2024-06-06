package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.ICart;
import org.brit.application.ICheckOut;
import org.brit.models.ProductItem;
import org.brit.pages.pw.CartPagePW;

import java.util.List;

public class WebCartPW extends WebApplicationPW implements ICart {
    CartPagePW cartPage = new CartPagePW();

    @Override
    public IAllItems continueShopping() {
        cartPage.continueShopping();
        return new WebAllItemsPW();
    }

    @Override
    public List<ProductItem> getAllItemsInCart() {
        return cartPage.getProductItemsList();
    }

    @Override
    public ICart removeItemFromCart(String productName) {
        cartPage.removeProductFromCart(productName);
        return this;
    }

    @Override
    public ICheckOut checkout() {
        cartPage.checkout();
        return new WebCheckOutPW();
    }
}
