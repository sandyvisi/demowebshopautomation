Feature: Testing the tied facebook function

  Background: User has to landed over to the login page
    Given Get the url and open in browser

  Scenario: check that the facebook is loading properly
    When user clicks the socialMedia link at the bottom of the page
    Then the user should be moved to new tab of all social medias
