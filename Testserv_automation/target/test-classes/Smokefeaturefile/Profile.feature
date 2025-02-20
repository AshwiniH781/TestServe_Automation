Feature: Profile
  
  @ProfileUserinfo @Smoke
  Scenario: Verify that users are able to create the profile by entering valid credentials and update the password
    Given Login to the application by entering valid credentials
    When Click on the profile button
    And Click on the create new profile button
    And Click on save button the succssfully message and manage profile page displayed
    And Click on edit icon update the profile
    And Click on profile image and upload the image
    Then Click on update password button update the password
    
   