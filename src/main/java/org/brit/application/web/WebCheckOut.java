package org.brit.application.web;

import org.brit.application.ICart;
import org.brit.application.ICheckOut;
import org.brit.application.IFinishCheckOut;
import org.brit.pages.web.CheckOut1Page;

public class WebCheckOut extends WebApplication implements ICheckOut {
    CheckOut1Page checkOut1Page = new CheckOut1Page();

    @Override
    public ICheckOut enterInfoForCheckout(String firstName, String lastName, String zipCode) {
        checkOut1Page.enterData(firstName, lastName, zipCode);
        return this;
    }

    @Override
    public ICart cancelCheckout() {
        checkOut1Page.cancel();
        return new WebCart();
    }

    @Override
    public IFinishCheckOut continueCheckOut() {
        checkOut1Page.continueCheckout();
        return new WebFinishCheckOut();
    }
}
