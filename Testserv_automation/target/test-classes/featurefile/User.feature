Feature: Users

  @User @Sanity
  Scenario: Verify that users are able to create the users
    Given Launch the application login by using the company credentials
    When Click on user button
    And Click on create new user button enter all credentials
    Then Click on the save button
