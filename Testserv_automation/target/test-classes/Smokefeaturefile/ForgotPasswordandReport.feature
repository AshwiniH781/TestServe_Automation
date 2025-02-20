Feature: Forgot password and Reports

  @ForgotPasswordReports @Smoke
  Scenario: Verfiy that user are able to update the password
    Given Launch the browser enter test url login page displayed
    When Click on forgot password link
    And Enter Username or Email and click on Resend reset link sucssfull toast message displayed
    And Launch the browser login to the application homepage is displayed
    And Click on the Reports dropdown all the options displayed
    And Click on the Login Activity button the page is displayed
    Then Click on the Trace User Activity button the page is displayed
