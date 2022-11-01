@UpgenixInvalidLoginFunctionality
Feature: Upgenix login functionality with invalid credentials
  Agile story: As a user, I should try invalid credentials log in so that I can not land on homepage.

  @UPGN-1
  Scenario Outline: User can not login with invalid credentials
    When user should be on the login page
    And user can try to invalid "<username>" in email box
    And user can try to valid "<password>" in password box
    Then user should see "Wrong login/password" message
    Examples:
      | username                 | password     |
      | salesmanager-1@info.com  | salesmanager |
      | salesmanager550@info.com | salesmanager |
      | posmanager----@info.com  | posmanager   |
      | posmanager5000@info.com  | posmanager   |

  @UPGN-233
  Scenario Outline: User can not login with invalid credentials
    When user should be on the login page
    And user can try to valid "<username>" in email box
    And user can try to invalid "<password>" in password box
    Then user should see "Wrong login/password" message
    Examples:
      | username                | password        |
      | salesmanager10@info.com | salesmanager123 |
      | salesmanager55@info.com | manager.?       |
      | posmanager55@info.com   | posmanager---   |

  @UPGN-mes
    #Please fill out this field" message should be displayed if the password or username is empty
  Scenario Outline: User can not login with empty password
    When user should be on the login page
    And user can try to valid "<username>" in email box
    Then user should see "Please fill out this field." password message
    Examples:
      | username                |
      | salesmanager10@info.com |
      | salesmanager55@info.com |
      | posmanager55@info.com   |
      | posmanager155@info.com  |

  @UPGN-mes
    #Please fill out this field" message should be displayed if the password or username is empty
  Scenario Outline: User can not login with empty username
    When user should be on the login page
    And user can try to invalid "<password>" in password box
    Then user should see "Please fill out this field." username message
    Examples:
      | password     |
      | salesmanager |
      | salesmanager |
