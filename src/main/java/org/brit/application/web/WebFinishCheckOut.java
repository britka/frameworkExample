package org.brit.application.web;

import org.brit.application.IAllItems;
import org.brit.application.ICompleteCheckout;
import org.brit.application.IFinishCheckOut;
import org.brit.models.PaymentInfo;
import org.brit.pages.web.CheckOutFinishPage;

public class WebFinishCheckOut extends WebApplication implements IFinishCheckOut {
    CheckOutFinishPage checkOutFinishPage = new CheckOutFinishPage();

    @Override
    public PaymentInfo getFinishInfo() {
         return checkOutFinishPage.getAllPaymentInfo();
    }

    @Override
    public ICompleteCheckout finish() {
        checkOutFinishPage.finish();
        return new WebCompleteCheckout();
    }

    @Override
    public IAllItems cancel() {
        checkOutFinishPage.cancel();
        return new WebAllItems();
    }


}
