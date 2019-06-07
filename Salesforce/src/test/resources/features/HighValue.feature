Feature: Set Supporter Level as High Value and verify the details
  As a Salesforce user, login to Salesforce and set Supporter Level as "High Value" and Verify
  the details

  Scenario Outline: Login to Salesforce URL and Set Supporter level as High Value
    Given I login to Salesforce URL
    When I click on Contacts Page
    And I enter following details under New Contact Page:
      | First Name   | Last Name   | Salutation   |
      | <First Name> | <Last Name> | <Salutation> |
    And I select High Value under Supporter level
    And I click on Save Button
    And I click on Details Tab
    And I retrieve Name and Supporter Level fields under Details Page
    Then I Verify Name and Supporter Level fields under Details page

    Examples:
      | First Name | Last Name | Salutation |
      | Oxfam      | Australia | Mr         |


