Feature: Documentation

  @Documentation @Smoke
  Scenario: Verify that users can see the CICD configuration
    Given Login to the company admin credentials
    When Click on documentation button
    And Click on view document button in the jenkins
    And Click on cicd intigration
    And Click on jenkins file configuration steps
    Then Click the documentation in breadcrumbs
