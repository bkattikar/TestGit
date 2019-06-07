Feature: Salesforce login
  #Scenario Outline: User can login
  @saasas
  Scenario Outline: User can login
    Given I login to Salesforce URL
   #Given I login to Salesforce URL
    When I click on Contacts Page
   # And I enter
    #And I enter following details under New Contact Page:
     # | First Name   | Last Name   |
      #| <First Name> | <Last Name> |

    Examples: | First Name | Last Name |
     #         | Oxfam      | Australia |








