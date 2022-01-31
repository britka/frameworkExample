package org.brit.application.web;

import org.brit.application.IAllItems;
import org.brit.application.ICompleteCheckout;
import org.brit.pages.web.CheckoutCompletePage;

public class WebCompleteCheckout extends WebApplication implements ICompleteCheckout {

    @Override
    public IAllItems goToItems() {
        new CheckoutCompletePage().backToMainPage();
        return new WebAllItems();
    }
}
