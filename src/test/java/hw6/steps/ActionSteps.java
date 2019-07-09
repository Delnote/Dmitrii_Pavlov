package hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw3.enums.HeaderMenu;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceMenuDropdownItems;

public class ActionSteps extends BaseStep {

    // TODO it is better to have separate class for the Given annotations
    // Fixed

    // TODO It is should be 'I login as uses '...'' for the another user you will create one more step def
    // Fixed
    @When("I login as user: userName \"(.+)\" and password \"(.+)\"")
    public void iLoginAs(String userName, String password) {
        homePage.userIconClick();
        homePage.fillLoginTextField(userName);
        homePage.fillPasswordTextFiels(password);
        homePage.loginButtonClick();
    }

    @When("I click on \"(.+)\" button in Header")
    public void iClickHeaderMenuServiceItem(HeaderMenu menuItem) {
        homePage.clickHeaderMenuItem(menuItem.getName());
    }

    @When("I click left side menu (.+) item")
    public void iClickLeftSideMenuServiceItem(LeftSideMenu menuItem) {
        homePage.clickLeftSideServiceButton(menuItem);
    }

    @When("I go to header (.+) dropdown menu")
    public void iGoToHeaderServiceDropdownMenu(HeaderMenu menuItem) {
        homePage.clickHeaderMenuItem(menuItem.getName());
    }

    @And("I click on \"(.+)\" button in Service dropdown")
    public void IGoToDropdownMenuItemPage(ServiceMenuDropdownItems menuItem) {
        homePage.clickHeaderDropdownMenuItems(menuItem);
    }

    // TODO It will be better to split this step for 2 from the Scenario ppoint of view
    // TODO It will be better description of the page where checkbox exist
    // Fixed
    @When("I click (.+) checkbox on Different Elements page")
    public void iClickWaterCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @And("And I click (.+) checkbox on Different Elements page")
    public void iClickWindCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @When("I select (.+) radio button")
    // TODO It will be better call method 'iSelectRadioButtonOn...'
    // TODO It will be better description of the page where radiobutton exist
    // Fixed
    public void iSelectRadioButtonOnDifferentElementsPage(String radioButton) {
        differentElementsPage.clickRadioButton(radioButton);
    }

    // TODO dropdown not dwopdown :)
    // Fixed
    @When("I select (.+) in colors select")
    // TODO It will be better description of the page where dropdown exist
    // TODO It will be better call method 'iSelectInColorsDropdownOn...'
    // Fixed
    public void iSelectInColorsSelectOnDifferentElementsPage(String color) {
        differentElementsPage.clickColorType(color);
    }

    // TODO From the scenario point of view it will be better to split this step to 2 ones
    // TODO It is looks like code duplication of the step @When("I click (.+) and (.+) checkboxes")
    // Fixed
    @When("I uncheck (.+) checkbox")
    public void iUncheckWaterCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @When("And I uncheck (.+) checkbox")
    public void iUncheckWindCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @When("I select 'vip' checkbox for \"(.+)\"")
    public void iSelectVipCheckboxOnDifferentElementsPage(String name) {
        userTablePage.clickCheckbox(name);
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void iClickOnDropdownInColumnTypeForUser(String name) {
        userTablePage.userDropdownClick(name);
    }
}
