Feature: Feedback

  @Feedback @Smoke
  Scenario: Verify that users are able to give the feedback
    Given Launch the browser login to the company admin credentials
    When Click on feedback button
    And Enter all the credentials
    And Click on Sumbit button
    And Click on logout icon login with superadmin
    And Click on feedback button and download the feedbacks
    Then Click on sort the ratings
