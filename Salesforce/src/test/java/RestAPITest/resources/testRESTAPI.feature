Feature: Supporters API v2(Salesforce)

  Scenario Outline: Supporters API POST Request
    Given I post Supporters Request Online channel
    #When I post Supporters Request Waysact - CC failed transaction
    #Given I execute Mulesoft API


    Examples:
      | First Name | Last Name | Salutation |
      | Oxfam      | Australia | Mr         |



