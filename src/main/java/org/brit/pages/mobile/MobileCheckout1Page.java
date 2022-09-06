package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.brit.pages.web.CartPage;
import org.brit.pages.web.CheckOut1Page;
import org.brit.pages.web.CheckOutFinishPage;

public class MobileCheckout1Page extends MobileBasePage{
    public MobileCheckout1Page enterData(String firstName, String lastName, String zip){
        $(AppiumBy.accessibilityId("test-First Name")).setValue(firstName);
        $(AppiumBy.accessibilityId("test-Last Name")).setValue(lastName);
        $(AppiumBy.accessibilityId("test-Zip/Postal Code")).setValue(zip);
        return this;
    }

    public MobileCartPage cancel(){
        scrollUntilElementIsVisibleAndClick($(AppiumBy.accessibilityId("test-CANCEL")));
        return new MobileCartPage();
    }

    public MobileCheckOutFinishPage continueCheckout(){
        scrollUntilElementIsVisibleAndClick($(AppiumBy.accessibilityId("test-CONTINUE")));
        return new MobileCheckOutFinishPage();
    }



}
