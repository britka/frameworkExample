package org.brit.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.brit.application.IAllItems;
import org.brit.application.ICart;
import org.brit.application.IFinishCheckOut;
import org.brit.models.PaymentInfo;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class CartTests extends BaseTest {

    @Test
    public void addItemToCartTest() {
        String itemName = "Sauce Labs Backpack";
        Integer productsCountInCart = application
                .openMenu()
                .goToAllItems()
                .addProductToCart(itemName)
                .getProductsCountInCart();

        assertThat(productsCountInCart).isEqualTo(1);

        ICart iCart = application.goToCart();
        ProductItem productItem = iCart
                .getAllItemsInCart()
                .get(0);

        assertThat(productItem.itemName())
                .isEqualTo(itemName);
        iCart
                .checkout()
                .enterInfoForCheckout("some", "some", "Some")
                .continueCheckOut()
                .finish()
                .goToItems();
    }

    @Test
    public void sortTest(){
        IAllItems allItems = application
                .openMenu()
                .goToAllItems();
        List<ProductItem> itemsList = allItems.getItemsList();
        List<ProductItem> itemsList1 = allItems
                .sort(SortDirection.NAME_A_TO_Z)
                .getItemsList();

        itemsList.sort(Comparator.comparing(ProductItem::itemName));
        Assert.assertEquals(itemsList1, itemsList);
    }

    @Test
    public void sortTest1(){
        IAllItems allItems = application
                .openMenu().goToAllItems();
        List<ProductItem> itemsList = allItems.getItemsList();
        List<ProductItem> itemsList1 = allItems.sort(SortDirection.NAME_Z_TO_A)
                .getItemsList();
        itemsList.sort((o1, o2) -> o2.itemName().compareTo(o1.itemName()));
        Assert.assertEquals(itemsList1, itemsList);
    }

    @Test
    public void sortTest3(){
        IAllItems allItems = application
                .openMenu()
                .goToAllItems();
        List<ProductItem> itemsList = allItems.getItemsList();
        List<ProductItem> itemsList1 = allItems.sort(SortDirection.PRICE_LOW_TO_HIGH)
                .getItemsList();

        itemsList.sort(Comparator.comparing(ProductItem::price));
        Assert.assertEquals(itemsList1, itemsList);
    }
}
