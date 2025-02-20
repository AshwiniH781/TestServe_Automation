Feature: Users

  @User @Smoke
  Scenario: Verify that users are able to create the users
    Given Launch the application login by using the company credentials
    When Click on user button
    And Click on create new user button enter all credentials
    And Click on the save button
    And Click on edit icon update
    Then Click on view icon see the details
    