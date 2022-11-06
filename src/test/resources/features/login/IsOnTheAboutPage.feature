Feature: Is on the About page

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"


  Scenario: Is on the About page
    When User select in burger menu About
    Then User should be on page by url "https://saucelabs.com/"