Feature: RegisterPage Feature

Background: User has to landed over to the login page
    Given Get the url and open in browser

  Scenario Outline: Enter the register details
    Given url to be loaded properly
    When user enters all the register page details "<firstName>" "<lastName>" "<email>" "<password>" "<confirmPassword>"
    Then the user details should be registered and login details should be created

    Examples:
      | firstName | lastName | email           | password   | confirmPassword |
      | santhosh  | kumar    | kumar@sandy.com | Saibaba1@3 | Saibaba1@3      |

  Scenario Outline: Enter the register with duplicate email details
    Given url to be loaded properly
    When user enters all the register page details "<firstName>" "<lastName>" "<email>" "<password>" "<confirmPassword>"
    Then the user details should not registered should be shown error message

    Examples:
      | firstName | lastName | email           | password   | confirmPassword |
      | santhosh  | kumar    | kumar@sandy.com | Saibaba1@3 | Saibaba1@3      |
