package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.ICompleteCheckout;
import org.brit.pages.pw.CheckoutCompletePagePW;

public class WebCompleteCheckoutPW extends WebApplicationPW implements ICompleteCheckout {

    @Override
    public IAllItems goToItems() {
        new CheckoutCompletePagePW().backToMainPage();
        return new WebAllItemsPW();
    }
}
