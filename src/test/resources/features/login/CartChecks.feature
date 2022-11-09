Feature: Checking Basket

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Checking Basket
    Given User select products:
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Fleece Jacket          |

    When Click on cart button
    Then User should be on the cart page, and the cart must have selected products