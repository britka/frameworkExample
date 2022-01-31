package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.MobileBy;
import org.brit.pages.web.AllItemsPage;

public class MobileCheckoutCompletePage extends MobileBasePage{
    public MobileAllItemsPage backToMainPage(){
        $(MobileBy.AccessibilityId("test-BACK HOME")).click();
        return new MobileAllItemsPage();
    }
}
