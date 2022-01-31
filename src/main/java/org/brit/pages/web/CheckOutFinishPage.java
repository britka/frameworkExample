package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.brit.models.PaymentInfo;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.PageFactory;

public class CheckOutFinishPage extends BasePage{
    public PaymentInfo getAllPaymentInfo(){
        PaymentInfo paymentInfo = new PaymentInfo();

        paymentInfo
                .products(getProductItemsList($$(".cart_item")))
                .cardInfo($$(".summary_value_label").get(0).text())
                .shippingInfo($$(".summary_value_label").get(1).text())
                .itemsPrice(getPriceFromTotalSection($(".summary_subtotal_label")))
                .tax(getPriceFromTotalSection($(".summary_tax_label")))
                .totalPrice(getPriceFromTotalSection($(".summary_total_label")));
        return paymentInfo;
    }

    public AllItemsPage cancel(){
        $("#cancel").click();
        return new AllItemsPage();
    }

    public CheckoutCompletePage finish(){
        $("#finish").click();
        return new CheckoutCompletePage();
    }

    private Double getPriceFromTotalSection(SelenideElement summaryItem){
        String sectionPriceText = summaryItem.text().split(":")[1].trim();
        return convertDollarStringToDouble(sectionPriceText);
    }
}
