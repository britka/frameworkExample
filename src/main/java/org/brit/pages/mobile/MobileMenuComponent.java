package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

import org.brit.pages.MenuItem;

public class MobileMenuComponent {
    public void selectMenuItem(MenuItem menuItem) {
        if ($(AppiumBy.accessibilityId("test-" + menuItem.getValue().toUpperCase())).is(Condition.not(Condition.visible))) {
            $(AppiumBy.accessibilityId("test-Menu")).click();
        }
        $(AppiumBy.accessibilityId("test-" + menuItem.getValue().toUpperCase())).click();
    }
}
