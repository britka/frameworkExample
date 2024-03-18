package org.brit.pages.mobile;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class MobileLoginPage extends MobileBasePage {

    private final SelenideElement userNameField = $(AppiumBy.accessibilityId("test-Username"));
    private final SelenideElement passwordField = $(AppiumBy.accessibilityId("test-Password"));
    private final SelenideElement loginButton = $(AppiumBy.accessibilityId("test-LOGIN"));

    public MobileAllItemsPage login(String userName, String userPass) {
        userNameField
                .shouldBe(Condition.visible)
                .setValue(userName);
        passwordField.setValue(userPass);
        loginButton.click();
        sleep(2000);
        return new MobileAllItemsPage();
    }
}
