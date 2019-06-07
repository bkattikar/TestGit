Feature: Calculator
  As a user
  I want to use a calculator to add numbers
  So that I don't need to add myself

  Scenario Outline: Add two numbers <num1> & <num2>
    Given I login to Salesforce URL
    When I click on Contacts Page
    #And I enter following details under New Contact Page:
    #  | First Name   | Last Name   | Salutation   |
    #  | <First Name> | <Last Name> | <Salutation> |
    #And I select Key Supporter under Supporter level
    #And I click on Save Button
    #And I click on Details Tab
    #Then I verify following details under Details Page:


    #Then the result should be <total>

    Examples:
      | First Name | Last Name | Salutation |
      | Oxfam      | Australia | Mr         |
