Feature: Remove Produсt

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Remove Produсt
    Given User select products:
      | Sauce Labs Backpack |

    When Click on cart button
    And Click Remove
    Then The user will see an empty shopping cart
