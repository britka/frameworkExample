package org.brit.pages.pw;


public class CheckoutCompletePagePW extends BasePagePW {
    public AllItemsPagePW backToMainPage(){
        page.locator("#back-to-products").click();
        return new AllItemsPagePW();
    }

    public boolean isOnPage(){
        return page.locator("#back-to-products").isVisible();
    }
}
