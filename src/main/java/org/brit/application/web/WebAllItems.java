package org.brit.application.web;

import java.util.List;
import org.brit.application.IAllItems;
import org.brit.application.IProduct;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.brit.pages.web.AllItemsPage;

public class WebAllItems extends  WebApplication implements IAllItems {
    AllItemsPage webAllItems = new AllItemsPage();

    @Override
    public IAllItems sort(SortDirection sortDirection) {
        webAllItems.sort(sortDirection);
        return this;
    }

    @Override
    public List<ProductItem> getItemsList() {
        return webAllItems.getAllItemsFromPage();
    }

    @Override
    public IProduct selectProduct(String productName) {
        webAllItems.selectProduct(productName);
        return new WebProduct();
    }

    @Override
    public IAllItems addProductToCart(String productName) {
        webAllItems.addProductToCard(productName);
        return this;
    }

    @Override
    public IAllItems removeProductFromCart(String productName) {
        webAllItems.removeFromCart(productName);
        return this;
    }
}
