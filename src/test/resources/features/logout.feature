@logout
Feature: Upgenix logout functionality
  Agile Story: User can log out and ends up in login page.

  @UPGN-846
  Scenario Outline: user can logout and see login page.
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box
    When user should see the main page title like "#Inbox - Odoo"
    And user should click username on the page
    And user should click "Log out Button" on the page
    Then user should see log in page title like "Login | Best solution for startups"
    Examples:
      | username                 | password     |
      | salesmanager10@info.com  | salesmanager |
      | salesmanager55@info.com  | salesmanager |
      | salesmanager105@info.com | salesmanager |

  @UPGN-847
  Scenario Outline: user can not go to the home page again by clicking the step back button after successfully logged out.
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box
    When user should see the main page title like "#Inbox - Odoo"
    And user should click username on the page
    And user should click "Log out Button" on the page
    And user should see log in page title like "Login | Best solution for startups"
    And user should click to step back button
    Then user should not see the main page title like "#Inbox - Odoo"
    Examples:
      | username                 | password     |
      | salesmanager10@info.com  | salesmanager |
      | salesmanager55@info.com  | salesmanager |
      | salesmanager105@info.com | salesmanager |

  @UPGN-848
  Scenario Outline: user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to valid "<password>" in password box
    When user should see the main page title like "#Inbox - Odoo"
    And user should close all taps which is on browser
    When user should be on the login page
    Then user should not see the main page title like "#Inbox - Odoo"
    Then user should not see the "<user name>" on login page
    Examples:
      | username                | password     | user name      |
      | salesmanager10@info.com | salesmanager | SalesManager10 |
      | salesmanager55@info.com | salesmanager | SalesManager55 |
      | posmanager50@info.com   | posmanager   | POSManager50   |