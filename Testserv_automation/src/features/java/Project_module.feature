Feature: Project module Functionality

	@Project @Sanity
  Scenario: Project page functionality
    Given User login to the application with valid credentials
    When User Clicks on the Project button 
    And Verify that users are able to click on the Create New Project button
    Then Verify that users are able to create the project
    
    