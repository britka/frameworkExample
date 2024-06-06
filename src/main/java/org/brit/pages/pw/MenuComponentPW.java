package org.brit.pages.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.brit.pages.MenuItem;
import org.brit.webdriver.PlaywrightDriver;

public class MenuComponentPW {
    private Page page = PlaywrightDriver.getInstance().getPage();

    Locator burgerButton = page.locator("#react-burger-menu-btn");

    Locator menu = page.locator(".bm-item-list");

    public void selectMenuItem(MenuItem menuItem) {
        page.waitForTimeout(2000);
        if (!menu.isVisible()) {
            burgerButton.click();
        }
        menu.locator("a").filter(new Locator.FilterOptions().setHasText(menuItem.getValue())).click();
        page.waitForTimeout(700);
        if (menu.isVisible()) {
            menu
                    .locator("..")
                    .locator("..")
                    .locator(".bm-cross-button")
                    .click();
        }
    }


}
