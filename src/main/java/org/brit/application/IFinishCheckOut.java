package org.brit.application;

import org.brit.models.PaymentInfo;

public interface IFinishCheckOut extends IApplication{
   PaymentInfo getFinishInfo();
   ICompleteCheckout finish();
   IAllItems cancel();

}
