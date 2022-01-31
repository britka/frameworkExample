package org.brit.application.mobile;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.appium.ScreenObject.screen;

import org.brit.application.IAllItems;
import org.brit.application.IApplication;
import org.brit.application.ICart;
import org.brit.application.IMenu;
import org.brit.pages.mobile.MobileBasePage;
import org.brit.pages.mobile.MobileLoginPage;

public class MobileApplication implements IApplication {

    @Override
    public IMenu openMenu() {
        return new MobileMenu();
    }

    @Override
    public IAllItems login(String login, String password) {
        new MobileLoginPage().login(login, password);
        return new MobileAllItems();
    }

    @Override
    public Integer getProductsCountInCart() {
        return new MobileBasePage().getCartProductsCount();
    }

    @Override
    public ICart goToCart() {
        new MobileBasePage().goToCart();
        return new MobileCart();
    }

    @Override
    public IApplication goToApp() {
        open();
        return new MobileApplication();
    }
}
