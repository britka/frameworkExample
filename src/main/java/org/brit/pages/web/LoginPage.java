package org.brit.pages.web;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import lombok.AllArgsConstructor;

public class LoginPage {

    public AllItemsPage login(String userName, String userPass){
        $("#user-name").setValue(userName);
        $("#password").setValue(userPass);
        $("#login-button").click();
        return new AllItemsPage();
    }

    public boolean isOnPage(){
        return $("#user-name").is(Condition.visible)
                &&  $("#password").is(Condition.visible);
    }

    public String getErrorMessage(){
        return $(".error-message-container").text();
    }
}
