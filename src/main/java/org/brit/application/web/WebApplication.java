package org.brit.application.web;

import static com.codeborne.selenide.Selenide.open;

import org.brit.application.IAllItems;
import org.brit.application.IApplication;
import org.brit.application.ICart;
import org.brit.application.IMenu;
import org.brit.pages.web.BasePage;
import org.brit.pages.web.LoginPage;

public class WebApplication implements IApplication {

    @Override
    public IMenu openMenu() {
        return new WebMenu();
    }

    @Override
    public IAllItems login(String login, String password) {
        new LoginPage().login(login, password);
        return new WebAllItems();
    }

    @Override
    public Integer getProductsCountInCart() {
        return new BasePage().getCartProductsCount();
    }

    @Override
    public ICart goToCart() {
        new BasePage().goToCart();
        return new WebCart();
    }

    @Override
    public IApplication goToApp() {
        open("https://www.saucedemo.com");
        return this;
    }
}
