package org.brit.cucumber.step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.brit.pages.web.AllItemsPage;
import org.brit.pages.web.CartPage;
import org.brit.pages.web.LoginPage;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs extends BaseStepDef{

    @Then("User should be on main product page")
    public void userShouldBeOnMainProductPage() {
        Assert.assertTrue(new AllItemsPage().isOnPage());
    }

    @When("User enter login with login {string} and password {string}")
    public void userEnterLoginWithLoginAndPassword(String login, String password) {
        new LoginPage().login(login, password);
    }

    @When("Usel login with {string} and {string}")
    public void uselLoginWithAnd(String login, String password) {
        new LoginPage().login(login, password);
    }

    @Then("User should stay on Login Page")
    public void userShouldStayOnLoginPage() {
        Assert.assertTrue(new LoginPage().isOnPage());
    }

    @And("Error message should have {string}")
    public void errorMessageShouldHave(String errorMessage) {
        Assert.assertTrue(new LoginPage().getErrorMessage().contains(errorMessage));
    }

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        open("https://www.saucedemo.com");
    }

    @Then("User should be on the cart page, and the cart must have selected products")
    public void userShouldBeOnTheCartPageAndTheCartMustHaveSelectedProducts() {
        new CartPage();
    }
    @And("Click Remove")
    public void clickRemove() {
        new CartPage().removeProductFromCart("Sauce Labs Backpack");
    }

    @Then("The user will see an empty shopping cart")
    public void theUserWillSeeAnEmptyShoppingCart() {
        new CartPage();
    }
}
