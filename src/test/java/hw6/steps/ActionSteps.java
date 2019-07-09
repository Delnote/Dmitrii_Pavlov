package hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw3.enums.HeaderMenu;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceMenuDropdownItems;

public class ActionSteps extends BaseStep {

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

    @When("I click (.+) checkbox on Different Elements page")
    public void iClickWaterCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @And("And I click (.+) checkbox on Different Elements page")
    public void iClickWindCheckboxOnDifferentElementsPage(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @When("I select (.+) radio button")
    public void iSelectRadioButtonOnDifferentElementsPage(String radioButton) {
        differentElementsPage.clickRadioButton(radioButton);
    }

    @When("I select (.+) in colors select")
    public void iSelectInColorsSelectOnDifferentElementsPage(String color) {
        differentElementsPage.clickColorType(color);
    }

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
