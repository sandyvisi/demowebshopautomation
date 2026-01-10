Feature: Testing the tied facebook function

  Scenario: check that the facebook is loading properly
    Given User has to landed over to the login page
    When user clicks the socialMedia link at the bottom of the page
    Then the user should be moved to new tab of all social medias
