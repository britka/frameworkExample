package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.IProduct;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.brit.pages.pw.AllItemsPagePW;

import java.util.List;

public class WebAllItemsPW extends WebApplicationPW implements IAllItems {
    AllItemsPagePW webAllItems = new AllItemsPagePW();

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
        return new WebProductPW();
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
