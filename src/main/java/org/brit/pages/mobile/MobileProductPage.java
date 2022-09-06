package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.brit.models.ProductItem;
import org.brit.pages.web.AllItemsPage;
import org.brit.pages.web.ProductPage;

public class MobileProductPage extends MobileBasePage{
    public MobileProductPage addToCart() {
        scrollUntilElementIsVisibleAndClick($(AppiumBy.accessibilityId("test-ADD TO CART")));
        return this;
    }

    public MobileProductPage removeFromCart() {
        scrollUntilElementIsVisibleAndClick($(AppiumBy.accessibilityId("test-REMOVE")));
        return this;
    }

    public ProductItem getProductInfo() {
        scrollUpToTop();
        scrollDown();
        ProductItem productItem = new ProductItem();
        SelenideElement productElement = $(AppiumBy.accessibilityId("test-Inventory item page"));

        String name = productElement.
                $(AppiumBy.accessibilityId("test-Description"))
                .$$x(".//android.widget.TextView")
                .get(0)
                .text();
        String description = productElement
                .$(AppiumBy.accessibilityId("test-Description"))
                .$$x(".//android.widget.TextView")
                .get(1)
                .text();
        Double price = convertDollarStringToDouble(productElement
                .$(AppiumBy.accessibilityId("test-Price"))
                .text());

        productItem.itemName(name).description(description).price(price);
        return productItem;
    }

    public MobileAllItemsPage backToProducts() {
        $(MobileBy.AccessibilityId("test-BACK TO PRODUCTS")).click();
        return new MobileAllItemsPage();
    }

}
