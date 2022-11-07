package org.hyrenko.cucumber.step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.brit.application.web.WebApplication;
import org.brit.cucumber.step_defs.AllProductsStepdefs;
import org.brit.pages.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class MyStepDefs extends AllProductsStepdefs {
    @FindBy(css = "#shopping_cart_container > a")
    private WebElement cartLink;
    @FindBy(css = ".inventory_item")
    private List<WebElement> inventoryItems;


    @When("On cart number 1")
    public void userSeeNumberOneToCart() {
        Assert.assertEquals(new BasePage().getCartProductsCount(), 1);
    }

    @Then("On cart number {int}")
    public void addItemToCartTest() {
        BasePage basePage = new BasePage();

        String itemName = "Sauce Labs Backpack";
        int productsCountInCart =
                basePage.getCartProductsCount();

        Assert.assertEquals(productsCountInCart, 1);
    }

    @Then("On cart number")
    public void getNumberOfProductsInCart() {
        String cartLinkText = cartLink.getText();
        Assert.assertEquals(Integer.parseInt(cartLinkText), 1);
    }

    public String getButtonsText(String productName) {
        for (WebElement element : inventoryItems) {
            if (element.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)) {
                return element.findElement(By.cssSelector("button")).getText();
            }
        }
        return null;
    }

    public void getAssertNumberCart(String productName) {
        String buttonsText = getButtonsText(productName);
        Assert.assertEquals(buttonsText, "REMOVE");
    }
}

