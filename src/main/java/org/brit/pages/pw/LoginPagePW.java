package org.brit.pages.pw;

import com.microsoft.playwright.Page;
import org.brit.webdriver.PlaywrightDriver;;

public class LoginPagePW {
    private Page page = PlaywrightDriver.getInstance().getPage();

    public AllItemsPagePW login(String userName, String userPass){
        page.locator("#user-name").fill(userName);
        page.locator("#password").fill(userPass);
        page.locator("#login-button").click();
        return new AllItemsPagePW();
    }

    public boolean isOnPage(){
        return page.locator("#user-name").isVisible()
                &&  page.locator("#password").isVisible();
    }

    public String getErrorMessage(){
        return page.locator(".error-message-container").textContent();
    }
}
