Feature: Module

  @Module @Smoke
  Scenario: Verify that user are able to create edit the module
    Given Launch the application login with super admin credentials
    And Click on Module button and click on create new module button
    And Enter all valid credentials
    Then Click on edit icon edit the module
