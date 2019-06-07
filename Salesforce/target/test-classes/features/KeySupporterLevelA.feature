Feature:  Set Supporter Level as Key Supporter and verify the details
  As a Salesforce user, login to Salesforce and set Supporter Level as
  "Key Supporter" and Verify the details

  Scenario Outline:  Login to Salesforce URL and Set Supporter level as Key Supporter
    Given I login to Salesforce URL
    When I click on Contacts Page
    And I enter following details under New Contact Page:
      | First Name   | Last Name   | Salutation   |
      | <First Name> | <Last Name> | <Salutation> |
    And I select Key Supporter under Supporter level
    And I select Levels of service as A
    And I click on Save Button
    And I click on Details Tab
    And I retrieve Name, Supporter Level and Levels of service fields under Details Page
    Then I Verify Name and Supporter Level fields under Details page

    Examples:
      | First Name | Last Name | Salutation |
      | Oxfam      | Australia | Mr         |


