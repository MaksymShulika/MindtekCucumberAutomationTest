@regression @smoke @elarLogisticsDataBase
Feature: Validating Existing Created Company on Data Base

  @test1Sun123
  Scenario: Validating Existing Created Company on Data Base
    Given User navigates to ElarLogistics application and create company
    When User logs in with  username "student@mindtekbootcamp.com" and password "ilovejava"
    And User clicks on Log in button
    And User clicks on Company button
    And User clicks on Add Company button
    And User create company with personal data
      | NAME     | COMPANY TYPE   | STATUS | MC#  | DOT# | IFTA | PHONE      | STREET           | CITY    | STATE | ZIP CODE | EMAIL            | INSURANCE   | PRODUCER PHONE | PRODUCER STREET     | PRODUCER CITY | PRODUCED STATE | PRODUCED ZIP CODE | PRODUCER EMAIL       | EMPLOYER ID NUMBER | OTHER LICENSES | NOTES | Contact name | Policy effective day | Policy expiration | Type of insurance1 | Automobile liability | Numbers of trucks insured | Policy number         | Employer id number     | Billing address (for check) | Bank name(for ACH payment) | Routing Number (for ACH payment) | Account Number(for ACH payment)              | President full name | Trucks in fleet | SCAC code | Other licenses | Incorporated in | Warning | ContactName2 | Ext1       | ProducerPhoneExt | Fax        | Apt1 | Ext2     | Apt2 | Type of insurance |
      | Sun123   | broker company | active | 1234 | 4321 | true | 7733153678 | 5441 Main Avenue | Chicago | IL    | 60539    | sundid@gamil.com | Progressive | 7753153677     | 4567 Levaine Avenue | Lombard       | Illinois       | 45789             | ginapistol@gmail.com | 12-3456789         | false          |       |              |                      |                   |                    |                      |                           |                       |                        |                             |                            |                                  |                                              |                     |                 |           |                |                 |         |              |            |                  |            |      |          |      |                   |
    And User clicks on Add Company button in company creating page and go on companies list
    Then User will Validates all unique fields from company profile to Data Base by using Name of company and unique MC#


  @test2Sun12345
  Scenario: Validating Existing Created Company on Data Base with all fields required or not required
    Given User navigates to ElarLogistics application and create company
    When User logs in with  username "student@mindtekbootcamp.com" and password "ilovejava"
    And User clicks on Log in button
    And User clicks on Company button
    And User clicks on Add Company button
    And User create company with full personal data
      | NAME     | COMPANY TYPE   | STATUS | MC#  | DOT# | IFTA | PHONE      | STREET           | CITY    | STATE | ZIP CODE | EMAIL            | INSURANCE   | PRODUCER PHONE | PRODUCER STREET     | PRODUCER CITY | PRODUCED STATE | PRODUCED ZIP CODE | PRODUCER EMAIL       | EMPLOYER ID NUMBER | OTHER LICENSES | NOTES | Contact name | Policy effective day | Policy expiration | Type of insurance1 | Automobile liability | Numbers of trucks insured | Policy number         | Employer id number     | Billing address (for check) | Bank name(for ACH payment) | Routing Number (for ACH payment) | Account Number(for ACH payment) | President full name | Trucks in fleet | SCAC code | Other licenses | Incorporated in | Warning | ContactName2 | Ext1       | ProducerPhoneExt | Fax        | Apt1 | Ext2     | Apt2 | Type of insurance |
      | Sun12345 | broker company | active | 1234 | 4321 | true | 7733153678 | 5441 Main Avenue | Chicago | IL    | 60539    | sundid@gamil.com | Progressive | 7753153677     | 4567 Levaine Avenue | Lombard       | Illinois       | 45789             | ginapistol@gmail.com | 12-3456789         | false          | hello | Moon         | 05012023             | 09302023          | Madrid             | any_auto             | 33                        | 233456788990033323323 | wBxSPvbew5Jh5EOShLm1dA | 124 sss avenue              | BOFA                       | 123131231312                     | 12321313132131                  | Alex                | 23              | lac       | No             | 07/06/2023      | Test    | Maria        | 3445667677 | 232323222        | 3456777888 | 1 c  | 34445455 | 2 c  | AUTO              |
    And User clicks on Add Company button in company creating page and go on companies list
    Then User will Validates all unique fields from company profile to Data Base by using Name of company and unique MC#

