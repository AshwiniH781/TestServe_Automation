Feature: Credit
  I want to use this template for my feature file

  @Credit
  Scenario: Verfiy that users are able to edit and view the credit
    Given Launch the application login to the super admin
    When Click on credit button
    And Click on edit icon update the Credit
    Then Click on view icon see the details about the credit
    