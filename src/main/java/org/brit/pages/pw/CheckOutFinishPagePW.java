package org.brit.pages.pw;

import com.microsoft.playwright.Locator;
import org.brit.models.PaymentInfo;


public class CheckOutFinishPagePW extends BasePagePW {
    public PaymentInfo getAllPaymentInfo(){
        PaymentInfo paymentInfo = new PaymentInfo();

        paymentInfo
                .products(getProductItemsList(page.locator(".cart_item")))
                .cardInfo(page.locator(".summary_value_label").all().get(0).textContent())
                .shippingInfo(page.locator(".summary_value_label").all().get(1).textContent())
                .itemsPrice(getPriceFromTotalSection(page.locator(".summary_subtotal_label")))
                .tax(getPriceFromTotalSection(page.locator(".summary_tax_label")))
                .totalPrice(getPriceFromTotalSection(page.locator(".summary_total_label")));
        return paymentInfo;
    }

    public AllItemsPagePW cancel(){
        page.locator("#cancel").click();
        return new AllItemsPagePW();
    }

    public CheckoutCompletePagePW finish(){
        page.locator("#finish").click();
        return new CheckoutCompletePagePW();
    }

    private Double getPriceFromTotalSection(Locator summaryItem){
        String sectionPriceText = summaryItem.textContent().split(":")[1].trim();
        return convertDollarStringToDouble(sectionPriceText);
    }
}
