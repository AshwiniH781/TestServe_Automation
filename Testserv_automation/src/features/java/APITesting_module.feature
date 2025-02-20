Feature: API_Testing module Functionality

	@API_Testing @Sanity 
  Scenario: API environment functionality in API Testing module
    Given User launch the application and login with valid credentials
    When Verify that users are able to click on the API Environment button 
    #And Verify that users are able to create a New Environment
    And Verify that user are able to click on the API New Run button
    Then Verify that users are able to run the Live API testing.
    Then Verify that users are able to see the detailed report
    #And Verify that users are able to edit the post body
    
  @API_Testing @Sanity
  Scenario: API Report functionality in API Testing module
    Given User launch the application and login with valid credentials
    When Verify that users are able to click on the API Report button
    And Verify that users are able to click on the Test Case icon and Update the Test case
    Then Verify that users are able to see the History icon and passcount
    #And Verify that users are able to click on the View Report icon and filter Pass fail and not Run option
    #And verify that users can click the request body and copy the request body
    
    
    