Feature: RegisterPage Feature

  Scenario Outline: Enter the register details
    Given url to be loaded properly
    When user enters all the register page details "<firstName>" "<lastName>" "<email>" "<password>" "<confirmPassword>"
    Then the user details should be registered and login details should be created

    Examples:
      | firstName | lastName | email                | password   | confirmPassword |
      | santhosh  | kumar    | priy.santh@gmail.com | Saibaba1@3 | Saibaba1@3      |
