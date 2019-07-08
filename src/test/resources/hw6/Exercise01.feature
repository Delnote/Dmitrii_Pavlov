Feature: Exercise01

  Scenario: Interface test
    Given I am on "Home Page"
    When I login as user "Piter Chailovskii"
    | userName | password |
    | epam | 1234 |
    Then User name should be 'PITER CHAILOVSKII'
    Then Home page interface contains proper elements
    When I click on "Service" button in Header
    Then Header dropdown menu contains all proper elements
    When I click left side menu Service item
    Then Left side dropdown menu contains all proper elements
    When I go to header Service dropdown menu
    And I click on "DIFFERENT_ELEMENTS" button in Service dropdown
    Then Different Elements page interface contains proper elements
    Then Right section should be displayed
    Then Left section should be displayed
    When I click Water and Wind checkboxes
    Then Log status for Water and Wind is true
    When I select Selen radio button
    Then Proper log status for metal is Selen
    When I select Yellow in colors dwopdown
    Then I see log for Colors is Yellow
    When I uncheck Water and Wind checkboxes
    Then Log status for Water and Wind changed to false