Feature: Login logout feature
"""
  Here many scenarios about login and logout.
  I try to show different kind of scenarios
  """

  Background:
    Given User is on login page

  Scenario: Login successful
    When User enter login with login "standard_user" and password "secret_sauce"
    Then User should be on main product page

  Scenario Outline: Check unsuccessful login
    When Usel login with "<login>" and "<password>"
    Then User should stay on Login Page
    And Error message should have "<error message>"

    Examples:
      | login         | password     | error message                      |  |  |
      | standard_user |              | Epic sadface: Password is required |  |  |
      |               |              | Epic sadface: Username is required |  |  |
      |               | secret_sauce | Epic sadface: Username is required |  |  |
