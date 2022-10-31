package org.brit.application.mobile;

import java.util.List;
import org.brit.application.IAllItems;
import org.brit.application.IProduct;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.brit.pages.mobile.MobileAllItemsPage;

public class MobileAllItems extends MobileApplication implements IAllItems {
    MobileAllItemsPage mobileAllItemsPage = new MobileAllItemsPage();

    @Override
    public MobileAllItems sort(SortDirection sortDirection) {
        mobileAllItemsPage = mobileAllItemsPage.sort(sortDirection);
        return this;
    }

    @Override
    public List<ProductItem> getItemsList() {
        List<ProductItem> allItemsFromPage = mobileAllItemsPage.getAllItemsFromPage();
        return allItemsFromPage;
    }

    @Override
    public IProduct selectProduct(String productName) {
        mobileAllItemsPage.selectProduct(productName);
        return new MobileProduct();
    }

    @Override
    public IAllItems addProductToCart(String productName) {
        mobileAllItemsPage.addProductToCard(productName);
        return this;
    }

    @Override
    public IAllItems removeProductFromCart(String productName) {
        mobileAllItemsPage.removeFromCart(productName);
        return this;
    }
}
