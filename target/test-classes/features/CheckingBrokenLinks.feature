Feature: Broken link present or not

  Scenario: Checking the broken links login page
  
Background: User has to landed over to the login page
    Given Get the url and open in browser
    
    When check broken links are present in the page
    Then check broken links are showing the response code as expected
    
