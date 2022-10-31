package org.brit.pages.web;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage extends BasePage{
    public AllItemsPage backToMainPage(){
        $("#back-to-products").click();
        return new AllItemsPage();
    }

    public boolean isOnPage(){
        return $("#back-to-products").is(Condition.visible);
    }
}
