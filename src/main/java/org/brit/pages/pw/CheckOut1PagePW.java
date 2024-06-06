package org.brit.pages.pw;


public class CheckOut1PagePW extends BasePagePW {

    public CheckOut1PagePW enterData(String firstName, String lastName, String zip){
        page.locator("#first-name").fill(firstName);
        page.locator("#last-name").fill(lastName);
        page.locator("#postal-code").fill(zip);
        return this;
    }

    public CartPagePW cancel(){
        page.locator("#cancel").click();
        return new CartPagePW();
    }

    public CheckOutFinishPagePW continueCheckout(){
        page.locator("#continue").click();
        return new CheckOutFinishPagePW();
    }

}
