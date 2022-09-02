Feature: Test Cases Page

  @testCases
  Scenario: Verify Test Cases Page
    Given Navigate to url 'http://automationexercise.com'
    Then Verify that home page is visible successfully
    When Click on Test Cases button
    Then Verify user is navigated to test cases page successfully
    And Close driver