package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.brit.pages.MenuItem;

public class MenuComponent {
    SelenideElement burgerButton = $("#react-burger-menu-btn");

    SelenideElement menu = $(".bm-item-list");

    public void selectMenuItem(MenuItem menuItem){
        if (menu.is(Condition.not(Condition.visible))){
            burgerButton.click();
        }
        menu.$$("a").find(Condition.exactText(menuItem.getValue())).click();
    }


}
