package org.brit.pages.web;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AboutSauceLab extends BasePage{
    public boolean isOnPage(){
        return $("#headerMainNav").is(Condition.visible);
    }
}
