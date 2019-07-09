Feature: Exercise01

  Scenario: Interface test
    Given I am on "Home Page"
    When I login as user: userName "epam" and password "1234"
    Then User name should be 'PITER CHAILOVSKII'
    Then 4 icons on Home page
    Then 4 icon description texts on Home page
    Then Under icon texts On Home Page are correct
    Then Main text title on Home page is MAIN_PAGE_TEXT_HEADER
    Then Main page MAIN_PAGE_TEXT on Home page
    When I click on "Service" button in Header
    # TODO What does 'correct elements' mean?
    Then Header dropdown menu contains correct elements
    When I click left side menu Service item
    # TODO What does 'correct elements' mean?
    Then Left side dropdown menu contains correct elements
    When I go to header Service dropdown menu
    And I click on "DIFFERENT_ELEMENTS" button in Service dropdown
    Then 4 checkboxes on the Different Elements page
    Then 4 radio buttons on the Different Elements page
    Then There is a Button on Different Elements page
    Then There is a Default Button on Different Elements page
    Then There is a Colors dropdown on Different Elements page
    Then Right section should be displayed
    Then Left section should be displayed
    When I click Water checkbox on Different Elements page
    When And I click Wind checkbox on Different Elements page
    Then Water log row has "Water: condition changed to true" text in log section
    Then Wind log row has "Wind: condition changed to true" text in log section
    When I select Selen radio button
    Then Selen log row has "metal: condition changed to Selen" text in log section
    When I select Yellow in colors select
    Then Colors log row has "Colors: condition changed to Yellow" text in log section
    When I uncheck Water checkbox
    When And I uncheck Water checkbox
    Then New Water log row has "Water: condition changed to false" text in log section
    Then New Wind log row has "Wind: condition changed to false" text in log section