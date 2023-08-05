@regression @smoke @elarLogistics
  Feature: Validation search functionality
   Background:Logging in
     Given User navigates to ElarLogistics application
     When User logs in with  username "student@mindtekbootcamp.com" and password "ilovejava"
     And User clicks on Log in button
     And User clicks on Company button
     And User clicks on Add Company button
     And User create company with data
       | NAME | COMPANY TYPE   | STATUS | MC# | DOT# | IFTA | PHONE      | STREET           | CITY    | STATE    | ZIP CODE | EMAIL                    | INSURANCE   | PRODUCER PHONE | PRODUCER STREET     | PRODUCER CITY | PRODUCED STATE | PRODUCED ZIP CODE | PRODUCER EMAIL       | EMPLOYER ID NUMBER | OTHER LICENSES | NOTES              |
       | ABC  | broker company | active | 1234   | 4321    | true | 7733153678 | 5441 Main Avenue | Chicago | IL | 60539    | marielagongales@gmail.com | Progressive | 7753153677     | 4567 Levaine Avenue | Lombard       | Illinois       | 45789             | ginapistol@gmail.com | 12-3456789         | false          | please Pay in time |
     And User clicks on Add Company button in company creating page
     And User clicks on Search  button

     @appearEngine
     Scenario: Validating the search engine appear
       Then User validates the search engine appear

    @anyMatch
    Scenario:Validate Search engine with any match
      And User typed any match "abc"
      Then Validates List of companies with match "abc"

    @Name
    Scenario: Validating Search engine's "Name" tag with beginning of the value
        And User clicks on Name tag
        And User types beginning of the value "ab"
        Then Validates list of companies with the beginning of the value "ab"

    @MC_Test1
    Scenario: Validating Search engine's "MC#" tag with beginning of the value
          And User clicks on MC# tag
          And User types beginning of the value of MC# "1234"
          Then User validates list of companies with beginning of the value "1234"

    @MC_Test2
    Scenario: Validating Search engine's "MC#" tag by searching a data that doesn't exist
      And User clicks on MC# tag
      And User types beginning of the value "CRS"
      Then User validates message of page "The system has not found companies"

    @DOT_Test1
    Scenario: Validating Search engine's "DOT#" tag with beginning of the value
      And User clicks on DOT# tag
      And User types beginning of the value "4321"
      Then User validates list of companies with beginning of the value of DOT "4321"

    @DOT_Test2
    Scenario: Validating Search engine's "DOT#" tag by searching a data that doesn't exist
      And User clicks on DOT# tag
      And User types beginning of the value "hpo"
      Then User validates message of page by DOT# "The system has not found companies"

    @Phone_Test1
    Scenario: Validating Search engine's "Phone" tag by searching existing phone number
      And User clicks on Phone tag
      And User types beginning of the value "773-315-3678"
      Then User validates list of companies with beginning of the value of Phone "773-315-3678"

    @Phone_Test2
    Scenario: Validating Search engine's "Phone" tag by searching a data that doesn't exist
      And User clicks on Phone tag
      And User types beginning of the value "Phone"
      Then User validates message of page by Phone "The system has not found companies"

    @Email_Test1
    Scenario: Validating Search engine's "Email" tag with beginning of the value
      And User clicks on Email tag
      And User types beginning of the value "mariela"
      Then Validates list of companies with the beginning of the value by Email "mariela"

    @Address_Test1
    Scenario: Validating Search engine's "Address" tag with beginning of the value
      And User clicks on Address tag
      And User types beginning of the value "Main"
      And User clicks on first company in list and go to profile of company
      Then User validates "Main" in address

    @Notes_Test1
    Scenario: Validating Search engine's "Notes" tag with beginning of the value
      And User clicks on Notes tag
      And User types beginning of the value "please"
      And User clicks on first company in list and go to profile of company
      And User clicks on edit button
      Then User validates "please" in notes









   