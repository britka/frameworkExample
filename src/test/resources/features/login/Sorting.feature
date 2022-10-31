Feature: Sorting feature

  Background:
    Given User is on login page
    And User enter login with login "standard_user" and password "secret_sauce"

  Scenario Outline: Sort in different direction
    When User select sorting "<sorting direction>"
    Then Product list should be sorted correctly by "<sorting direction>"

    Examples:
      | sorting direction |  |
      | NAME_A_TO_Z       |  |
      | NAME_Z_TO_A       |  |
      | PRICE_LOW_TO_HIGH |  |
      | PRICE_HIGH_TO_LOW |  |
