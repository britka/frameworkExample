package org.brit.pages;

public enum MenuItem {
    ALL_ITEMS("All Items"),
    ABOUT("About"),
    LOGOUT("Logout");

    private String value;

    MenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
