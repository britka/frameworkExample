package org.brit.cucumber.step_defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.brit.models.ProductItem;
import org.brit.models.SortDirection;
import org.brit.pages.web.*;
import org.brit.webdriver.AppFactory;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AllProductsStepdefs{

    private List<ProductItem> listBeforeSorting;
    private List<ProductItem> listAfterSorting;

    private AllItemsPage allItemsPage = new AllItemsPage();

    @When("User select sorting {string}")
    public void userSelectSorting(String sortingDirection) {
        listBeforeSorting = allItemsPage.getAllItemsFromPage();
        allItemsPage.sort(SortDirection.valueOf(sortingDirection));
        listAfterSorting = allItemsPage.getAllItemsFromPage();
    }


    @Then("Product list should be sorted correctly by {string}")
    public void productListShouldBeSortedCorrectly(String sortingDirection) {
        SortDirection sortDirection = SortDirection.valueOf(sortingDirection);
        Comparator<ProductItem> comparator = null;
        switch (sortDirection){
            case NAME_A_TO_Z:
                comparator = Comparator.comparing(ProductItem::itemName);
                break;
            case NAME_Z_TO_A:
                comparator = (o1, o2) -> o2.itemName().compareTo(o1.itemName());
                break;
            case PRICE_LOW_TO_HIGH:
                comparator = Comparator.comparing(ProductItem::price);
                break;
            case PRICE_HIGH_TO_LOW:
                comparator = (o1,o2) -> o2.price().compareTo(o1.price());
                break;
        }

        listBeforeSorting.sort(comparator);
        Assert.assertEquals(listAfterSorting, listBeforeSorting);
    }

    @Given("User select products:")
    public void userSelectProducts(List<String> products) {
        for (String product: products){
            allItemsPage.addProductToCard(product);
        }
    }

    @When("Click on cart button")
    public void clickOnCartButton() {
        allItemsPage.goToCart();
    }

    @And("Click Checkout")
    public void clickCheckout() {
        new CartPage().checkout();
    }

    @And("Enter data:")
    public void enterData(DataTable dataTable) {
        Map<String, String > strings = dataTable.asMap();
        new CheckOut1Page()
                .enterData(strings.get("firstName"), strings.get("lastName"), strings.get("zipCode"))
                .continueCheckout();
    }

    @And("Click Finish")
    public void clickFinish() {
        new CheckOutFinishPage().finish();
    }

    @Then("User should be on THANK YOU FOR YOUR ORDER page")
    public void userShouldBeOnTHANKYOUFORYOURORDERPage() {
        Assert.assertTrue(new CheckoutCompletePage().isOnPage());
    }

}
