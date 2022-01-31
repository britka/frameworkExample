package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;

public class CheckOut1Page extends BasePage{
    public CheckOut1Page enterData(String firstName, String lastName, String zip){
        $("#first-name").setValue(firstName);
        $("#last-name").setValue(lastName);
        $("#postal-code").setValue(zip);
        return this;
    }

    public CartPage cancel(){
        $("#cancel").click();
        return new CartPage();
    }

    public CheckOutFinishPage continueCheckout(){
        $("#continue").click();
        return new CheckOutFinishPage();
    }

}
