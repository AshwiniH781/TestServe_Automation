Feature: Company page

  @company @Smoke
  Scenario: Verify that users are able to create the company
    Given launch the browser login to the application
    When click on testserv logo
    And click on company button
    And click on create new company button
    And Enter valid credntials into the create company screen
    And click on the save button
    And Enter valid credentias into the profile screen
    And Click on save button
    And Enter valid credentials into the create credit screen
    And Click on the create button and click on information icon
    And Click on edit icon update the company
    And Click on view icon
    Then Click on profile and credit button