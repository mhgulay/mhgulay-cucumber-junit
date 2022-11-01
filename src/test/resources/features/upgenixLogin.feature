@UpgenixLoginFunctionality
Feature: Upgenix login functionality with valid credentials
  Agile story: As a user, I should be able to log in so that I can land on homepage.

  @UPGN-788
  Scenario Outline: Salesmanager can login with valid credentials
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box
    Then user should see the main page title like "#Inbox - Odoo"
    Examples:
      | username                 | password     |
      | salesmanager10@info.com  | salesmanager |
      | salesmanager55@info.com  | salesmanager |
      | salesmanager105@info.com | salesmanager |

  @UPGN-
  Scenario Outline: Posmanager can login with valid credentials
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box
    Then user should see the main page title like "#Inbox - Odoo"
    Examples:
      | username               | password   |
      | posmanager10@info.com  | posmanager |
      | posmanager55@info.com  | posmanager |
      | posmanager155@info.com | posmanager |

    #User should see the password in bullet signs by default while typing (like ****)
  @UPGN-star
  Scenario Outline: Posmanager can login with valid credentials
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box wait
    Then user check input type "password"
    Examples:
      | username              | password   |
      | posmanager10@info.com | posmanager |


  @UPGN-enter
  Scenario Outline: Salesmanager can login with valid credentials with enter key
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box with enter key
    Then user should see the main page title like "#Inbox - Odoo"
    Examples:
      | username                 | password     |
      | salesmanager10@info.com  | salesmanager |
      | salesmanager55@info.com  | salesmanager |
      | posmanager10@info.com    | posmanager   |
      | posmanager55@info.com    | posmanager   |


