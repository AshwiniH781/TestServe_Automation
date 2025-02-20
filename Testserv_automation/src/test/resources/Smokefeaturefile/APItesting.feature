Feature: API Environment

  @APIEnvironment @Smoke
  Scenario: Launch and Login
    Given Launch the browser login to the application
    And Click on the API Environment button the ManageEnvironments page
    And Click on the Add New Environment button index page is displayed
    And Enter all valid credentials into create environment screen
    And Click on the save button manage variable screen is displayed
    And Click on pickfrom API and enter response 
    And Click on save button data rule screen displayed
    And Click on back button the index page is displayed
    Then Click on ellipse the option is displayed and click genarte button
    