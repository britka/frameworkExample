package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage extends BasePage{
    public AllItemsPage backToMainPage(){
        $("#back-to-products").click();
        return new AllItemsPage();
    }
}
