Feature: Exercise02

  Scenario: User Table Page test
    Given I am on "Home Page"
    And I login as user: userName "epam" and password "1234"
    When I click on "Service" button in Header
    And I click on "USER_TABLE" button in Service dropdown
    Then "User Table" page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    # TODO Without context is not clear what is User table should have values
    # Fixed
    And Users table data on User Table page contains following values:
      | Number | User             |  Description                       |
      | 1      | Roman            |  Wolverine                         |
      | 2      | Sergey Ivan      |  Spider Man                        |
      | 3      | Vladzimir        |  Punisher                          |
      | 4      | Helen Bennett    |  Captain America\nsome description |
      | 5      | Yoshi Tannamuri  |  Cyclope\nsome description         |
      | 6      | Giovanni Rovelli |  Hulk\nsome description            |
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
    When I click on dropdown in column Type for user Roman
    # TODO Without context is not clear what is dropdown should have values
    # Fixed
    Then Roman user dropdown list on User Table page contains values:
      | Admin           |
      | User            |
      | Manager         |
