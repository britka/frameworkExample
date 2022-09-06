package org.brit.pages.mobile;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.SneakyThrows;
import org.brit.models.PaymentInfo;
import org.brit.models.ProductItem;
import org.brit.pages.web.AllItemsPage;
import org.brit.pages.web.CheckoutCompletePage;

public class MobileCheckOutFinishPage extends MobileBasePage {

    public PaymentInfo getAllPaymentInfo() {
        PaymentInfo paymentInfo = new PaymentInfo();

        paymentInfo
                .products(getAllItemsFromPage());
        ElementsCollection selenideElements = $(AppiumBy.accessibilityId("test-CHECKOUT: OVERVIEW"))
                .$$x(".//android.widget.TextView");

        paymentInfo.cardInfo(findNodeAndReturnStringValueOfNext(selenideElements, "Payment Information:"))
                .shippingInfo(findNodeAndReturnStringValueOfNext(selenideElements, "Shipping Information:"));

        //TODO add scrolling to this elements
        String itemTotal = selenideElements.find(Condition.textCaseSensitive("Item total:")).text();
        String tax = selenideElements.find(Condition.textCaseSensitive("Tax:")).text();
        String total = selenideElements.find(Condition.textCaseSensitive("Total:")).text();
        paymentInfo.itemsPrice(convertDollarStringToDouble(itemTotal))
                .tax(convertDollarStringToDouble(tax))
                .totalPrice(convertDollarStringToDouble(total));
        return paymentInfo;
    }

    public MobileAllItemsPage cancel() {
        scrollUntilElementIsVisibleAndClick($(AppiumBy.accessibilityId("test-CANCEL")));
        return new MobileAllItemsPage();
    }

    public MobileCheckoutCompletePage finish() {
        scrollUntilElementIsVisibleAndClick($(AppiumBy.accessibilityId("test-FINISH")));
        return new MobileCheckoutCompletePage();
    }


    @SneakyThrows
    public List<ProductItem> getAllItemsFromPage() {
        SelenideElement listElement = $(AppiumBy.accessibilityId("test-CHECKOUT: OVERVIEW"));
        Set<ProductItem> productItems = new HashSet<>();

        while (true) {
            List<SelenideElement> fullProducts = new ArrayList<>();
            ElementsCollection products = listElement.$$(AppiumBy.accessibilityId("test-Item"));
            for (SelenideElement element : products) {
                ElementsCollection childElements = element
                        .$$x(".//*");
                if (childElements.size() >= 10) {
                    fullProducts.add(element);
                }
            }
            if (fullProducts.size() == 0) {
                scrollUpToTop();
                return new ArrayList<>(productItems);
            }
            for (SelenideElement element : fullProducts) {
                ProductItem productItem = new ProductItem();

                ElementsCollection description = element.$(AppiumBy.accessibilityId("test-Description"))
                        .$$x(".//android.widget.TextView");

                productItem.itemName(description.get(0).text());
                productItem.description(description.get(1).text());
                productItem.price(convertDollarStringToDouble(
                        element
                                .$(AppiumBy.accessibilityId("test-Price"))
                                .$x(".//android.widget.TextView")
                                .text()));
                productItems.add(productItem);
            }
            scrollDown();
        }
    }


    private String findNodeAndReturnStringValueOfNext(ElementsCollection textNodes, String nodeString) {
        for (int i = 0; i < textNodes.size(); i++) {
            if (nodeString.equals(textNodes.get(i).text())) {
                return textNodes.get(i + 1).text();
            }
        }
        return null;
    }

}
