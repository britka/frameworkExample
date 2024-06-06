package org.brit.application;

public interface IApplication {
    IMenu openMenu();
    IAllItems login(String login, String password);
    Integer getProductsCountInCart();
    ICart goToCart();
    IApplication goToApp();
    void closeApp();
}
