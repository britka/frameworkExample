package org.brit.application;

import java.util.List;
import org.brit.models.ProductItem;

public interface ICart extends IApplication{
    IAllItems continueShopping();
    List<ProductItem> getAllItemsInCart();
    ICart removeItemFromCart(String cartName);
    ICheckOut checkout();
}
