package org.brit.application;

public interface ICheckOut extends IApplication{

    ICheckOut enterInfoForCheckout(String firstName, String lastName, String zipCode);
    ICart cancelCheckout();
    IFinishCheckOut continueCheckOut();
}
