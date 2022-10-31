package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.brit.pages.web.BasePage;
import org.brit.pages.web.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class MobileAllItemsPage extends MobileBasePage {

    @SneakyThrows
    public List<ProductItem> getAllItemsFromPage() {
        SelenideElement listElement = $(AppiumBy.accessibilityId("test-PRODUCTS"));
        Set<ProductItem> productItems = new LinkedHashSet<>();

        while (true) {
            List<SelenideElement> fullProducts = new ArrayList<>();
            ElementsCollection products = listElement.$$(AppiumBy.accessibilityId("test-Item"));
            for (SelenideElement element : products) {
                ElementsCollection childElements = element
                        .$(AppiumBy.xpath("./android.view.ViewGroup"))
                        .$$x(".//*");
                if (childElements.size() == 11) {
                    fullProducts.add(element);
                }
            }
            if (fullProducts.size() == 0) {
                scrollUpToTop();
                return new ArrayList<>(productItems);
            }
            for (SelenideElement element : fullProducts) {
                ProductItem productItem = new ProductItem();
                SelenideElement productElement = element
                        .$(AppiumBy.xpath("./android.view.ViewGroup"));
                productItem.itemName(productElement.$(AppiumBy.accessibilityId("test-Item title")).text());
                productItem.price(convertDollarStringToDouble(productElement.$(AppiumBy.accessibilityId("test-Price")).text()));
                productItems.add(productItem);
            }
            scrollDown();
        }
    }

    public MobileAllItemsPage addProductToCard(String productName) {
        while (true) {
            ElementsCollection products = $(AppiumBy.accessibilityId("test-PRODUCTS"))
                    .$$(AppiumBy.accessibilityId("test-Item"));
            for (SelenideElement product : products) {
                if (product.$(AppiumBy.accessibilityId("test-Item title")).is(Condition.not(Condition.visible))){
                    break;
                }
                if (productName.equals(product.$(AppiumBy.accessibilityId("test-Item title")).text())) {
                    product.$(AppiumBy.accessibilityId("test-ADD TO CART")).click();
                    scrollUpToTop();
                    return new MobileAllItemsPage();
                }
            }
            scrollDown();
            sleep(1000);
        }
    }

    public MobileAllItemsPage removeFromCart(String productName) {
        while (true) {
            ElementsCollection products = $(AppiumBy.accessibilityId("test-PRODUCTS"))
                    .$$(AppiumBy.accessibilityId("test-Item"));
            for (SelenideElement product : products) {
                if (productName.equals(product.$(AppiumBy.accessibilityId("test-Item title")).text())) {
                    product.$(AppiumBy.accessibilityId("test-REMOVE")).click();
                    scrollUpToTop();
                    return new MobileAllItemsPage();
                }
            }
            scrollDown();
        }
    }

    public MobileAllItemsPage sort(SortDirection sortDirection) {
        scrollUpToTop();
        $(AppiumBy.accessibilityId("test-Modal Selector Button")).click();
        $(AppiumBy.accessibilityId("Selector container"))
                .$$x(".//android.widget.TextView")
                .find(Condition.exactText(sortDirection.getText()))
                .click();
        $(AppiumBy.accessibilityId("Selector container")).shouldNotBe(Condition.visible);
        sleep(2000);
        return new MobileAllItemsPage();
    }

    public MobileProductPage selectProduct(String productName) {
        while (true) {
            SelenideElement element = $(AppiumBy.accessibilityId("test-PRODUCTS"))
                    .$$(AppiumBy.accessibilityId("test-Item title"))
                    .find(Condition.exactText(productName));
            if (element.is(Condition.visible)) {
                element.click();
                return new MobileProductPage();
            } else {
                scrollDown();
            }
        }
    }


}
