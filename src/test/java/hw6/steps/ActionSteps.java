package hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import hw3.enums.HeaderMenu;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceMenuDropdownItems;
import hw6.entities.User;
import hw6.hooks.TestContext;

import java.util.List;

public class ActionSteps extends BaseStep {

    // TODO it is better to have separate class for the Given annotations
    @Given("I am on \"Home Page\"")
    public void IAmOnTheHomePage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

    // TODO It is should be 'I login as uses '...'' for the another user you will create one more step def
    @When("I login as user \"Piter Chailovskii\"")
    public void ILoginAsUserPiterChailovskii(List<User> users) {
        User user = users.get(0);

        homePage.userIconClick();
        homePage.fillLoginTextField(user.getUserName());
        homePage.fillPasswordTextFiels(user.getPassword());
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
    @When("I click (.+) and (.+) checkboxes")
    public void iClickWaterAndWindCheckboxes(String checkbox1, String checkbox2) {
        differentElementsPage.clickCheckbox(checkbox1);
        differentElementsPage.clickCheckbox(checkbox2);
    }

    @When("I select (.+) radio button")
    // TODO It will be better call method 'iSelectRadioButtonOn...'
    // TODO It will be better description of the page where radiobutton exist
    public void iSelectSelenRadioButton(String radioButton) {
        differentElementsPage.clickRadioButton(radioButton);
    }

    // TODO dropdown not dwopdown :)
    @When("I select (.+) in colors dwopdown")
    // TODO It will be better description of the page where dropdown exist
    // TODO It will be better call method 'iSelectInColorsDropdownOn...'
    public void iSelectYellowInColorsDwopdown(String color) {
        differentElementsPage.clickColorType(color);
    }

    // TODO From the scenario point of view it will be better to split this step to 2 ones
    // TODO It is looks like code duplication of the step @When("I click (.+) and (.+) checkboxes")
    @When("I uncheck (.+) and (.+) checkboxes")
    public void iUncheckWaterAndWindCheckboxes(String checkbox1, String checkbox2) {
        differentElementsPage.clickCheckbox(checkbox1);
        differentElementsPage.clickCheckbox(checkbox2);
    }

    @When("I select 'vip' checkbox for \"(.+)\"")
    public void iSelectVipCheckbox(String name) {
        userTablePage.clickCheckbox(name);
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void iClickOnDropdownInColumnTypeForUser(String name) {
        userTablePage.userDropdownClick(name);
    }
}
