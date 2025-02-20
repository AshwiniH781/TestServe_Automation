Feature: Login

  @Loginpracticefeaturefile @Sanity
  Scenario: Verify that users are able to login with the application
    Given Launch the browser enter test url login page is displayed
    When enter username and password
    Then click on login button home page is displayed
