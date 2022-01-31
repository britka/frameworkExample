package org.brit.application.mobile;

import org.brit.application.IAllItems;
import org.brit.application.ICompleteCheckout;
import org.brit.pages.mobile.MobileCheckoutCompletePage;

public class MobileCompleteCheckout extends MobileApplication implements ICompleteCheckout {

    @Override
    public IAllItems goToItems() {
        new MobileCheckoutCompletePage().backToMainPage();
        return new MobileAllItems();
    }
}
