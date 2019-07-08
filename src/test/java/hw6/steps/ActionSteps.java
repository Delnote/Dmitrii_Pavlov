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

    @Given("I am on \"Home Page\"")
    public void IAmOnTheHomePage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

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

    @When("I click (.+) and (.+) checkboxes")
    public void iClickWaterAndWindCheckboxes(String checkbox1, String checkbox2) {
        differentElementsPage.clickCheckbox(checkbox1);
        differentElementsPage.clickCheckbox(checkbox2);
    }

    @When("I select (.+) radio button")
    public void iSelectSelenRadioButton(String radioButton) {
        differentElementsPage.clickRadioButton(radioButton);
    }

    @When("I select (.+) in colors dwopdown")
    public void iSelectYellowInColorsDwopdown(String color) {
        differentElementsPage.clickColorType(color);
    }

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
