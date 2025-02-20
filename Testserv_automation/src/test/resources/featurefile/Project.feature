Feature: Project Module

  @Project @Sanity
  Scenario: Verify that users are able tpo create new project by entering valid credentials
    Given Launch the browser enter test url
    When Enter username and password and click on login button home page should displayed
    And Click on project button index page displayed
   And Click on create new project button the create project pop up displayed
   And Enter project name and select checkboxes
   Then Click on save button toast message will appear navigates to the index page