Feature: Remove products from Cart

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"
    And Cart is empty

  Scenario: Add to cart 2 products and remove 1 on Cart page
    Given User select products:
      | Sauce Labs Onesie      |
      | Sauce Labs Fleece Jacket   |
    When Click on cart button
    And Remove product on Cart page
      | Sauce Labs Onesie       |
    Then Cart should have product
      | Sauce Labs Fleece Jacket |














