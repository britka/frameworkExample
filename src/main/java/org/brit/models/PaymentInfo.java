package org.brit.models;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PaymentInfo {
    List<ProductItem> products;
    String cardInfo;
    String shippingInfo;
    Double itemsPrice;
    Double tax;
    Double totalPrice;

}
