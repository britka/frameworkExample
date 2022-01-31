package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.MobileBy;
import org.brit.pages.web.CartPage;
import org.brit.pages.web.CheckOut1Page;
import org.brit.pages.web.CheckOutFinishPage;

public class MobileCheckout1Page extends MobileBasePage{
    public MobileCheckout1Page enterData(String firstName, String lastName, String zip){
        $(MobileBy.AccessibilityId("test-First Name")).setValue(firstName);
        $(MobileBy.AccessibilityId("test-Last Name")).setValue(lastName);
        $(MobileBy.AccessibilityId("test-Zip/Postal Code")).setValue(zip);
        return this;
    }

    public MobileCartPage cancel(){
        scrollUntilElementIsVisibleAndClick($(MobileBy.AccessibilityId("test-CANCEL")));
        return new MobileCartPage();
    }

    public MobileCheckOutFinishPage continueCheckout(){
        scrollUntilElementIsVisibleAndClick($(MobileBy.AccessibilityId("test-CONTINUE")));
        return new MobileCheckOutFinishPage();
    }



}
