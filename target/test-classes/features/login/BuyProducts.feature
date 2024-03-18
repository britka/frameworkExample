Feature: By products

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: By 2 products
    Given User select products:
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |

    When Click on cart button
    And Click Checkout
    And Enter data:
      | firstName | FirstName |
      | lastName  | LastName  |
      | zipCode   | 1234567   |

    And Click Finish
    Then User should be on THANK YOU FOR YOUR ORDER page
