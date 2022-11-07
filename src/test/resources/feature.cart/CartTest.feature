Feature: Shopping cart test


  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"

  Scenario: Adding an item to the cart

    Given User select products:
      | Sauce Labs Backpack |

    When On cart number one
