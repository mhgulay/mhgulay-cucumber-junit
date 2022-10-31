Feature: Upgenix login functionality
  Agile story: As a user, I should be able to log in so that I can land on homepage.


  @UPGN-547
  Scenario: Users can log in with valid credentials
    When user is on upgenix login page
    And user try to login with valid credentials
    Then user should see home page