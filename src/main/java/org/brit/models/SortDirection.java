package org.brit.models;

public enum SortDirection {
    NAME_A_TO_Z("az", "Name (A to Z)"),
    NAME_Z_TO_A("za", "Name (Z to A)"),
    PRICE_LOW_TO_HIGH("lohi", "Price (low to high)"),
    PRICE_HIGH_TO_LOW("hilo", "Price (high to low)");

    private String value;
    private String  text;

    SortDirection(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
