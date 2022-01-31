package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.functions.ExpectedCondition;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.pages.web.AllItemsPage;
import org.brit.pages.web.CartPage;
import org.brit.pages.web.CheckOut1Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileCartPage extends MobileBasePage {

    public MobileAllItemsPage continueShopping() {
       scrollUntilElementIsVisibleAndClick($(MobileBy.AccessibilityId("test-CONTINUE SHOPPING")));
        return new MobileAllItemsPage();
    }

    @SneakyThrows
    public List<ProductItem> getAllItemsFromPage() {
        SelenideElement listElement = $(MobileBy.AccessibilityId("test-Cart Content"));
        Set<ProductItem> productItems = new HashSet<>();

        while (true) {
            List<SelenideElement> fullProducts = new ArrayList<>();
            ElementsCollection products = listElement.$$(MobileBy.AccessibilityId("test-Item"));
            for (SelenideElement element : products) {
                ElementsCollection childElements = element
                        .$$x(".//*");
                if (childElements.size() >= 12) {
                    fullProducts.add(element);
                }
            }
            if (fullProducts.size() == 0) {
                scrollUpToTop();
                return new ArrayList<>(productItems);
            }
            for (SelenideElement element : fullProducts) {
                ProductItem productItem = new ProductItem();

                ElementsCollection description = element.$(MobileBy.AccessibilityId("test-Description"))
                        .$$x(".//android.widget.TextView");

                productItem.itemName(description.get(0).text());
                productItem.description(description.get(1).text());
                SelenideElement price = element.$(MobileBy.AccessibilityId("test-Price"))
                        .$(By.xpath(".//android.widget.TextView"));
                productItem.price(convertDollarStringToDouble(price.text()));
                productItems.add(productItem);
            }
            scrollDown(0.5, 0.7, 0.25);
        }
    }

    public MobileCartPage removeProductFromCart(String productName) {
        while (true) {
            SelenideElement element = $(MobileBy.AccessibilityId("test-PRODUCTS"))
                    .$$(MobileBy.AccessibilityId("test-Item"))
                    .find(Condition.exactText(productName))
                    .$(MobileBy.AccessibilityId("test-REMOVE"));
            if (element.is(Condition.visible)) {
                element.click();
                scrollUpToTop();
                return this;
            } else {
                scrollDown();
            }
        }
    }

    public MobileCheckout1Page checkout() {
        scrollUntilElementIsVisibleAndClick($(MobileBy.AccessibilityId("test-CHECKOUT")));
        return new MobileCheckout1Page();
    }
}
