Feature: Gmail Tests
  Open Gmail, clear first incoming message, clear spam messages

  Scenario: Login and delete letter from google incoming mail. Check spam messages
    Given open stack overflow page and login with google account
    And proceed with google account
    When delete first letter from Incoming
    And delete spam messages if they exist
    Then log out