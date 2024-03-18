package org.brit.pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import lombok.SneakyThrows;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

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
            int beforeAddingCount = productItems.size();
            for (SelenideElement element : fullProducts) {
                ProductItem productItem = new ProductItem();
                SelenideElement productElement = element
                        .$(AppiumBy.xpath("./android.view.ViewGroup"));
                productItem.itemName(productElement.$(AppiumBy.accessibilityId("test-Item title")).text());
                productItem.price(convertDollarStringToDouble(productElement.$(AppiumBy.accessibilityId("test-Price")).text()));
                productItems.add(productItem);
            }
            if (beforeAddingCount == productItems.size()){
                return new ArrayList<>(productItems);
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
