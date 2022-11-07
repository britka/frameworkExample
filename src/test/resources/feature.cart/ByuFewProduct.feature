Feature: Shopping cart test

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Buy and correct name and price
    Given User select products:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

    When Click on cart button

    And  On cart number 2

    Then Delete a product of cart "Sauce Labs Backpack"

    And  On cart number 1

    And The Sauce Labs Bike Light product in the shopping cart