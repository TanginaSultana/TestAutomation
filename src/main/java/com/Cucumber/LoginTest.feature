Feature: Login Functionality Test

  Scenario: Verify Login With Invalid CREDENTAILS
    Given Open Browser and Navigate to login page
    When Enter Email and Password
    Then Login Unsuccessful and close Test