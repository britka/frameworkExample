package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.brit.pages.MenuItem;

import java.time.Duration;

public class MenuComponent {
    SelenideElement burgerButton = $("#react-burger-menu-btn");

    SelenideElement menu = $(".bm-item-list");

    public void selectMenuItem(MenuItem menuItem){
        if (menu.is(Condition.not(Condition.visible), Duration.ofSeconds(2))){
            burgerButton.click();
        }
        menu.$$("a").find(Condition.exactText(menuItem.getValue())).click();
        sleep(700);
        if (menu.is(Condition.visible)){
            menu.parent().parent().$(".bm-cross-button").click();
        }
    }


}
