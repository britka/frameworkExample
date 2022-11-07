Feature: ContinueShopping

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Add to cart 2 products and continue shopping
    Given User select products:
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |
    When Click on cart button
    And Click on ContinueShopping button
    Then User should be on main product page


