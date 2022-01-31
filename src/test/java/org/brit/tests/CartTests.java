package org.brit.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.brit.application.ICart;
import org.brit.application.IFinishCheckOut;
import org.brit.models.PaymentInfo;
import org.brit.models.ProductItem;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addItemToCartTest() {
        String itemName = "Sauce Labs Backpack";
        Integer productsCountInCart = application
                .goToApp()
                .login("standard_user", "secret_sauce")
                .addProductToCart(itemName)
                .getProductsCountInCart();

        assertThat(productsCountInCart).isEqualTo(1);

        ICart iCart = application
                .goToCart();
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
                .goToItems()
                .openMenu()
                .logout();


    }

}
