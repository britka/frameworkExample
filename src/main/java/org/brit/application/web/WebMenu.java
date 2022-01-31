package org.brit.application.web;

import org.brit.application.IAllItems;
import org.brit.application.IApplication;
import org.brit.application.IMenu;
import org.brit.pages.web.BasePage;
import org.brit.pages.MenuItem;

public class WebMenu implements IMenu {

    @Override
    public IAllItems goToAllItems() {
        new BasePage().menu().selectMenuItem(MenuItem.ALL_ITEMS);
        return new WebAllItems();
    }

    @Override
    public IApplication logout() {
        new BasePage().menu().selectMenuItem(MenuItem.LOGOUT);
        return new WebApplication();
    }
}
