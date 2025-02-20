Feature: Company module Functionality

	@company @Sanity
  Scenario: Company page functionality
    Given User launches the application and login with valid credentials
    When Verify that user clicks on the Company button
    Then User is navigated to the Company page 
    And Verify that Users are create the company by entering all valid credentials.
    Then Verify that Users can see the Profile and Credit name
    