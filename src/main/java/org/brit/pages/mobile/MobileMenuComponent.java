package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.brit.pages.MenuItem;

public class MobileMenuComponent {
    public void selectMenuItem(MenuItem menuItem){
        if ($(MobileBy.AccessibilityId("test-" + menuItem.getValue().toUpperCase())).is(Condition.not(Condition.visible))){
            $(MobileBy.AccessibilityId("test-Menu")).click();
        }
        $(MobileBy.AccessibilityId("test-" + menuItem.getValue().toUpperCase())).click();
    }
}
