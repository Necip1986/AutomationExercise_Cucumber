Feature: Contact Us Form function

  @contactUs
  Scenario: filling and submission of contact us form
    When Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
    When Click on Contact Us button
    Then Verify 'GET IN TOUCH' is visible
    Given Enter name, email, subject and message
    And Upload file
    And Click Submit button
    And  Click OK button
    Then Verify success message 'Success! Your details have been submitted successfully.' is visible
    Then Click Home button and verify that landed to home page successfully
    And Close driver