package org.brit.cucumber.step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.brit.application.web.WebApplication;
import org.brit.models.ProductItem;
import org.brit.pages.web.AllItemsPage;
import org.brit.pages.web.CartPage;
import org.brit.pages.web.LoginPage;
import org.testng.Assert;

import java.util.List;

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
    @And("On cart number {int}")
    public void userSeeNumberOneToCart(int expectNumber) {
        Assert.assertEquals(new WebApplication().getProductsCountInCart(),expectNumber);
//        Assert.assertEquals(new BasePage().getCartProductsCount(), expectNumber);
    }
    @Then("On cart number one")
    public void on_cart_number_one() {

        Assert.assertEquals(new WebApplication().getProductsCountInCart(),1);
    }

    @Then("Delete a product of cart \"Sauce Labs Backpack\"")
    public void deleteAProductOfCart() {
        CartPage cartPage=new CartPage();
        String nameProduct = "Sauce Labs Backpack";
        cartPage.removeProductFromCart(nameProduct);
    }

    @And("The Sauce Labs Bike Light product in the shopping cart")
    public void theCorrectNameAndPriceOfTheProductInTheShoppingCart() {
        String nameProduct = "Sauce Labs Bike Light";
        List<ProductItem> nameItems= new CartPage().getProductItemsList();
        Assert.assertFalse(nameItems.contains(nameProduct));
    }
}
