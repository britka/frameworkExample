package org.brit.application.mobile;

import org.brit.application.IAllItems;
import org.brit.application.ICompleteCheckout;
import org.brit.application.IFinishCheckOut;
import org.brit.models.PaymentInfo;
import org.brit.pages.mobile.MobileCheckOutFinishPage;

public class MobileFinishCheckOut extends MobileApplication implements IFinishCheckOut {
    MobileCheckOutFinishPage mobileCheckOutFinishPage = new MobileCheckOutFinishPage();

    @Override
    public PaymentInfo getFinishInfo() {
         return mobileCheckOutFinishPage.getAllPaymentInfo();
    }

    @Override
    public ICompleteCheckout finish() {
        mobileCheckOutFinishPage.finish();
        return new MobileCompleteCheckout();
    }

    @Override
    public IAllItems cancel() {
        mobileCheckOutFinishPage.cancel();
        return new MobileAllItems();
    }
}
