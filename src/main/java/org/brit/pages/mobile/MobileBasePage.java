package org.brit.pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class MobileBasePage {

    SelenideElement shopping_cart_link = $(AppiumBy.accessibilityId("test-Cart"));
    MobileMenuComponent menuComponent;

    public Integer getCartProductsCount() {
        if (shopping_cart_link.$(By.className("android.widget.TextView")).is(Condition.visible)) {
            return Integer.parseInt(shopping_cart_link.$(By.className("android.widget.TextView")).text());
        }
        return 0;
    }

    public MobileCartPage goToCart() {
        shopping_cart_link.click();
        sleep(2000);
        return new MobileCartPage();
    }

    public MobileMenuComponent menu() {
        return menuComponent;
    }


    public void scrollDown() {
        scrollDown(0.5, 0.7, 0.18);
    }

    public void scrollDown(double anchorPercentage, double startPercentage, double endPercentage) {
        Dimension size = webdriver().object().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction((PerformsTouchActions) webdriver().object())
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    protected void scrollUpToTop() {
        webdriver().object().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward(3)"));
    }

    @SneakyThrows
    public Double convertDollarStringToDouble(String dollarsAsString) {
        NumberFormat nf = new DecimalFormat("$#,###.00");
        return nf.parse(dollarsAsString).doubleValue();
    }

    public void scrollUntilElementIsVisibleAndClick(SelenideElement element) {
        Wait().withTimeout(Duration.ofSeconds(15))
                .until((ExpectedCondition<Boolean>) driver -> {
                    if (element.is(Condition.visible)) {
                        element.click();
                        return true;
                    } else {
                        scrollDown();
                        return false;
                    }
                });
    }
}
