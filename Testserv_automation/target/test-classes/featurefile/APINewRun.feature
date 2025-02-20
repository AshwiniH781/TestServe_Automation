Feature: APINewRunReport

  @APINewRun @Sanity
  Scenario: Verify that users are able to Run the API and see the Report
    Given Login to the application using companyadmin credentials
    When Click on API New Run button
    And Select the environment and project
     And Click on API Report button
    And Click on ellipse and  View testcases options
    Then Click on edit option update the test cases fail to pass
