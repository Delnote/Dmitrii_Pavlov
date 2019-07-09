package hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw3.enums.MainPageData;
import hw3.enums.ServiceMenuDropdownItems;
import hw3.enums.UnderIconsText;
import hw6.entities.UserData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseStep {

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String userName) {
        assertEquals(homePage.accountUserName(), userName);
    }

    // TODO It will be better made steps with each element or specify them on the current
    // Fixed
    @Then("(.+) icons on Home page")
    public void iconsOnUserTablePage(int size) {
        assertEquals(homePage.amountOfIconItems(), size);
    }

    @Then("(.+) icon description texts on Home page")
    public void iconDescriptionTextOnUserTablePage(int size) {
        assertEquals(homePage.iconDescriptionText().size() , size);
    }

    @Then("Under icon texts On Home Page are correct")
    public void underIconTextsOnHomePageAreCorrect() {
        assertEquals(homePage.iconDescriptionText().toArray(),
                Arrays.stream(UnderIconsText.values()).map(UnderIconsText::getName).toArray());
    }

    @Then("Main text title on Home page is (.+)")
    public void mainTextTitleOnHomePage(MainPageData textHeader) {
        assertEquals(homePage.mainPageTextTitle(), textHeader.getName());
    }

    @Then("Main page (.+) on Home page")
    public void mainTextOnHomePage(MainPageData text) {
        assertEquals(homePage.mainPageText(), text.getName());
    }

    @Then("Header dropdown menu contains correct elements")
    public void dropdownMenuContainsAllProperElements() {
        List<String> enumMenuItemsList = Arrays.stream(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.headerServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    @Then("Left side dropdown menu contains correct elements")
    public void checkLeftSideServiceMenuItems() {
        List<String> enumMenuItemsList = Stream.of(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.leftSideServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    @Then("(.+) checkboxes on the Different Elements page")
    // TODO It will be better made steps with each element or specify them on the current
    // Fixed
    public void checkboxesOnTheifferentElementsPage(int size) {
        assertEquals(differentElementsPage.checkboxesAmount(), size);
    }

    @Then("(.+) radio buttons on the Different Elements page")
    public void radioButtonsOnTheifferentElementsPage(int size) {
        assertEquals(differentElementsPage.radioButtonsAmount(), size);
    }

    @Then("There is a Button on Different Elements page")
    public void thereIsAButtonOnDifferentElementsPage() {
        assertTrue(differentElementsPage.buttonExists());
    }

    @Then("There is a Default Button on Different Elements page")
    public void thereIsADefaultButtonOnDifferentElementsPage() {
        assertTrue(differentElementsPage.defaultButtonExists());
    }

    @Then("There is a Colors dropdown on Different Elements page")
    public void thereIsAColorsDropdownOnDifferentElementsPage() {
        assertTrue(differentElementsPage.colorsDropdownExists());
    }

    @Then("Right section should be displayed")
    public void rightSectionShouldBeDisplayed() {
        assertTrue(differentElementsPage.logSideBarExists());
    }

    @Then("Left section should be displayed")
    public void leftSectionShouldBeDisplayed() {
        assertTrue(differentElementsPage.navigationSideBarExists());
    }

    // TODO From the scenario point of view it will be better to split this step to 2 ones
    // TODO I think you could improve here. using this step  @Then("1 log row has \"(.+): condition changed to (.+)\" text in log section")
    // Fixed
    @Then("Water log row has \"(.+): condition changed to (.+)\" text in log section")
    public void logRowForWaterInLogSection(String checkbox, String statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox, statement)));
    }

    @Then("Wind log row has \"(.+): condition changed to (.+)\" text in log section")
    public void logRowForWindInLogSection(String checkbox, String statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox, statement)));
    }

    @Then("Selen log row has \"(.+): condition changed to (.+)\" text in log section")
    public void metalLogRowInLogSection(String type, String radioButton) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: value changed to %s", type, radioButton)));
    }

    @Then("Colors log row has \"(.+): condition changed to (.+)\" text in log section")
    public void colorsLogRowInLogSection(String color, String type) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: value changed to %s", color, type)));
    }

    @Then("New Water log row has \"(.+): condition changed to (.+)\" text in log section")
    public void newLogRowForWaterInLogSection(String checkbox, String statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox, statement)));
    }

    @Then("New Wind log row has \"(.+): condition changed to (.+)\" text in log section")
    public void newLogRowForWindInLogSection(String checkbox, String statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox, statement)));
    }

    @Then("\"(.+)\" page is opened")
    public void userTablePageIsOpened(String pageTitle) {
        assertEquals(homePage.pageTitle(), pageTitle);
    }

    // TODO Why do you do not sent number as paramenter?
    // Fixed
    @And("(.+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void sixNumberTypeDropdownsAreDisplayed(int size) {
        assertEquals(userTablePage.dropdownsAmount(), size);
    }

    // TODO Why do you do not sent number as paramenter?
    // Fixed
    @And("(.+) User names are displayed on Users Table on User Table Page")
    public void sixUserNamesAreDisplayed(int size) {
        assertEquals(userTablePage.userNamesAmount(), size);
    }

    // TODO Why do you do not sent number as paramenter?
    // Fixed
    @And("(.+) Description images are displayed on Users Table on User Table Page")
    public void sixDescriptionImagesAreDisplayed(int size) {
        assertEquals(userTablePage.descriptionImagesAmount(), size);
    }

    // TODO Why do you do not sent number as paramenter?
    // Fixed
    @And("(.+) Description texts under images are displayed on Users Table on User Table Page")
    public void sixDescriptionTextsUnderImagesAreDisplayed(int size) {
        assertEquals(userTablePage.textUnderImagesAmount(), size);
    }

    // TODO Why do you do not sent number as paramenter?
    // Fixed
    @And("(.+) checkboxes are displayed on Users Table on User Table Page")
    public void sixCheckboxesAreDisplayed(int size) {
        assertEquals(userTablePage.userCheckboxesAmount(), size);
    }

    @And("Users table data on User Table page contains following values:")
    public void userTableContainsValues(List<UserData> users) {
        for (UserData user : users) {
            assertTrue(userTablePage.userNumbers().contains(user.getNumber()));
            assertTrue(userTablePage.userNames().contains(user.getUser().toUpperCase()));
            assertTrue(userTablePage.userDescription().contains(user.getDescription().toUpperCase()));

        }
    }

    @Then("1 log row has \"(.+): condition changed to (.+)\" text in log section")
    public void logRowHasProperTextInLogSection(String vip, String statement) {
        assertTrue(userTablePage.logStatus()
                .contains(String.format("%s: condition changed to %s", vip, statement)));
    }

    // TODO looks like as code duplication
    // Fixed
    @Then("(.+) user dropdown list on User Table page contains values:")
    public void dropdownListContainsValues(String name, List<String> items) {
        assertEquals(userTablePage.userOptionsList(name), items);
    }
}
