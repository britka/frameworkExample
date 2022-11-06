Feature: From Product Page go to the Main Page

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: From Product Page go to the Main Page
    When User select product by name "Sauce Labs Backpack"
    And User click Back to products
    Then User should be on main product page