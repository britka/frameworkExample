package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.ICompleteCheckout;
import org.brit.application.IFinishCheckOut;
import org.brit.models.PaymentInfo;
import org.brit.pages.pw.CheckOutFinishPagePW;
import org.brit.pages.web.CheckOutFinishPage;

public class WebFinishCheckOutPW extends WebApplicationPW implements IFinishCheckOut {
    CheckOutFinishPagePW checkOutFinishPage = new CheckOutFinishPagePW();

    @Override
    public PaymentInfo getFinishInfo() {
         return checkOutFinishPage.getAllPaymentInfo();
    }

    @Override
    public ICompleteCheckout finish() {
        checkOutFinishPage.finish();
        return new WebCompleteCheckoutPW();
    }

    @Override
    public IAllItems cancel() {
        checkOutFinishPage.cancel();
        return new WebAllItemsPW();
    }


}
