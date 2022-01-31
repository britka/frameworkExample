package org.brit.application.mobile;

import java.util.List;
import org.brit.application.IAllItems;
import org.brit.application.ICart;
import org.brit.application.ICheckOut;
import org.brit.models.ProductItem;
import org.brit.pages.mobile.MobileCartPage;

public class MobileCart extends MobileApplication implements ICart {
    MobileCartPage cartPage = new MobileCartPage();

    @Override
    public IAllItems continueShopping() {
        cartPage.continueShopping();
        return new MobileAllItems();
    }

    @Override
    public List<ProductItem> getAllItemsInCart() {
        return cartPage.getAllItemsFromPage();
    }

    @Override
    public ICart removeItemFromCart(String cartName) {
        cartPage.removeProductFromCart(cartName);
        return this;
    }

    @Override
    public ICheckOut checkout() {
        cartPage.checkout();
        return new MobileCheckOut();
    }
}
