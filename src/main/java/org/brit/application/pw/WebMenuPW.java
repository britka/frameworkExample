package org.brit.application.pw;

import org.brit.application.IAllItems;
import org.brit.application.IApplication;
import org.brit.application.IMenu;
import org.brit.pages.MenuItem;
import org.brit.pages.pw.BasePagePW;

public class WebMenuPW implements IMenu {

    @Override
    public IAllItems goToAllItems() {
        new BasePagePW().menu().selectMenuItem(MenuItem.ALL_ITEMS);
        return new WebAllItemsPW();
    }

    @Override
    public IApplication logout() {
        new BasePagePW().menu().selectMenuItem(MenuItem.LOGOUT);
        return new WebApplicationPW();
    }
}
