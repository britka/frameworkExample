Feature: Remove products from Cart

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"
    And Cart is empty

  Scenario: Add to cart 2 products and remove 1 on Main page
    Given User select products:
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
    And Remove product on AllItems page
      | Sauce Labs Backpack |
    When Click on cart button
    Then Cart should have product
      | Sauce Labs Fleece Jacket |















