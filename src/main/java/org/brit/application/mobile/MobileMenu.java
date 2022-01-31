package org.brit.application.mobile;

import org.brit.application.IAllItems;
import org.brit.application.IApplication;
import org.brit.application.IMenu;
import org.brit.pages.MenuItem;
import org.brit.pages.mobile.MobileMenuComponent;

public class MobileMenu implements IMenu {
    MobileMenuComponent mobileMenuComponent = new MobileMenuComponent();

    @Override
    public IAllItems goToAllItems() {
        mobileMenuComponent.selectMenuItem(MenuItem.ALL_ITEMS);
        return new MobileAllItems();
    }

    @Override
    public IApplication logout() {
        mobileMenuComponent.selectMenuItem(MenuItem.LOGOUT);
        return new MobileApplication();
    }
}
