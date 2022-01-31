package org.brit.application.web;

import java.util.List;
import org.brit.application.IAllItems;
import org.brit.application.ICart;
import org.brit.application.ICheckOut;
import org.brit.models.ProductItem;
import org.brit.pages.web.CartPage;

public class WebCart extends WebApplication implements ICart {
    CartPage cartPage = new CartPage();

    @Override
    public IAllItems continueShopping() {
        cartPage.continueShopping();
        return new WebAllItems();
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
        return new WebCheckOut();
    }
}
