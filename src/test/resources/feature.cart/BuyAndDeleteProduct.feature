Feature: Shopping cart test

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Buy and delete a product
    Given User select products:
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |

    When Click on cart button

    And On cart number 2

    Then Delete a product of cart "Sauce Labs Backpack"

    And On cart number 1


