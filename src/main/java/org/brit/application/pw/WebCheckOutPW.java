package org.brit.application.pw;

import org.brit.application.ICart;
import org.brit.application.ICheckOut;
import org.brit.application.IFinishCheckOut;
import org.brit.pages.pw.CheckOut1PagePW;

public class WebCheckOutPW extends WebApplicationPW implements ICheckOut {
    CheckOut1PagePW checkOut1Page = new CheckOut1PagePW();

    @Override
    public ICheckOut enterInfoForCheckout(String firstName, String lastName, String zipCode) {
        checkOut1Page.enterData(firstName, lastName, zipCode);
        return this;
    }

    @Override
    public ICart cancelCheckout() {
        checkOut1Page.cancel();
        return new WebCartPW();
    }

    @Override
    public IFinishCheckOut continueCheckOut() {
        checkOut1Page.continueCheckout();
        return new WebFinishCheckOutPW();
    }
}
