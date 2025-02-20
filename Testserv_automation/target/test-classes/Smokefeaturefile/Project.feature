Feature: Title of your feature

Feature: Project Module

  @Project @Smoke
  Scenario: Verify that users are able tpo create new project by entering valid credentials
    Given Launch the browser enter test url
    When Enter username and password and click on login button home page should displayed
    And Click on project button index page displayed
    And Click on create new project button the create project pop up displayed
    And Enter project name and select checkboxes
    And Click on save button toast message will appear navigates to the index page
    And Click on edit icon edit the project
    Then Click on projectId details icon and deleteicon

 