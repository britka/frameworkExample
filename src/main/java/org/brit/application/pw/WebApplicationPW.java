package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.IApplication;
import org.brit.application.ICart;
import org.brit.application.IMenu;
import org.brit.pages.pw.BasePagePW;
import org.brit.pages.pw.LoginPagePW;
import org.brit.webdriver.PlaywrightDriver;

public class WebApplicationPW implements IApplication {

    @Override
    public IMenu openMenu() {
        return new WebMenuPW();
    }

    @Override
    public IAllItems login(String login, String password) {
        new LoginPagePW().login(login, password);
        return new WebAllItemsPW();
    }

    @Override
    public Integer getProductsCountInCart() {
        return new BasePagePW().getCartProductsCount();
    }

    @Override
    public ICart goToCart() {
        new BasePagePW().goToCart();
        return new WebCartPW();
    }

    @Override
    public IApplication goToApp() {
        PlaywrightDriver.getInstance().getPage().navigate("https://www.saucedemo.com");
        return this;
    }

    @Override
    public void closeApp() {
        PlaywrightDriver.getInstance().getPlaywright().close();
    }
}
