Feature: testing the login feature

  Scenario Outline: Login with valid creds
    Given User has to landed over to the login page
    When User enters valid the "<email>" "<password>"
    Then User able to login successfully

    Examples:
      | email           | password   |
      | kumar@sandy.com | Saibaba1@3 |

  Scenario Outline: Login with Invalid creds
    Given User has to landed over to the login page
    When User enters the invalid "<invalidEmail>" "<password>"
    Then User should not be able login

    Examples:
      | invalidEmail      | password   |
      | kumassr@sandy.com | Saibaba1@3 |
