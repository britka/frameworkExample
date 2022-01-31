package org.brit.application;

import java.util.List;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;

public interface IAllItems extends IApplication {

    IAllItems sort(SortDirection sortDirection);

    List<ProductItem> getItemsList();

    IProduct selectProduct(String productName);

    IAllItems addProductToCart(String productName);

    IAllItems removeProductFromCart(String productName);

}
