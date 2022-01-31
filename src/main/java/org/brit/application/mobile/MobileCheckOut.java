package org.brit.application.mobile;

import org.brit.application.ICart;
import org.brit.application.ICheckOut;
import org.brit.application.IFinishCheckOut;
import org.brit.pages.mobile.MobileCheckout1Page;

public class MobileCheckOut extends MobileApplication implements ICheckOut {
  MobileCheckout1Page mobileCheckout1Page = new MobileCheckout1Page();

    @Override
    public ICheckOut enterInfoForCheckout(String firstName, String lastName, String zipCode) {
       mobileCheckout1Page.enterData(firstName, lastName, zipCode);
        return new MobileCheckOut();
    }

    @Override
    public ICart cancelCheckout() {
        mobileCheckout1Page.cancel();
        return new MobileCart();
    }

    @Override
    public IFinishCheckOut continueCheckOut() {
        mobileCheckout1Page.continueCheckout();
        return new MobileFinishCheckOut();
    }
}
