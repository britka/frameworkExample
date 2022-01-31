package org.brit.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class ProductItem {
    private String itemName;
    private String description;
    private Double price;
}
