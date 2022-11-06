Feature: Check the name of the product on the Product page

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Check the name of the product on the Product page
    When User select product by name "Sauce Labs Backpack"
    Then User should be on Product Page
    And Name of the product on the Product Page should be corresponds selected product name "Sauce Labs Backpack"