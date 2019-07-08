package hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw3.enums.ServiceMenuDropdownItems;
import hw3.enums.UnderIconsText;
import hw6.entities.UserData;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hw3.enums.MainPageData.MAIN_PAGE_TEXT;
import static hw3.enums.MainPageData.MAIN_PAGE_TEXT_HEADER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseStep {

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String userName) {
        assertEquals(homePage.accountUserName(), userName);
    }

    @Then("Home page interface contains proper elements")
    public void allInterfacesContainProperElements() {
        assertEquals(homePage.amountOfIconItems(), 4);
        assertEquals(homePage.iconDescriptionText().size() , 4);
        assertEquals(homePage.iconDescriptionText().toArray(),
                Arrays.stream(UnderIconsText.values()).map(UnderIconsText::getName).toArray());
        assertEquals(homePage.mainPageTextTitle(), MAIN_PAGE_TEXT_HEADER.getName());
        assertEquals(homePage.mainPageText(), MAIN_PAGE_TEXT.getName());
    }

    @Then("Header dropdown menu contains all proper elements")
    public void dropdownMenuContainsAllProperElements() {
        List<String> enumMenuItemsList = Arrays.stream(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.headerServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    @Then("Left side dropdown menu contains all proper elements")
    public void checkLeftSideServiceMenuItems() {
        List<String> enumMenuItemsList = Stream.of(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.leftSideServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    @Then("Different Elements page interface contains proper elements")
    public void DifferentElementsPageInterfaceContainProperElements() {
        assertEquals(differentElementsPage.checkboxesAmount(), 4);
        assertEquals(differentElementsPage.radioButtonsAmount(), 4);
        assertTrue(differentElementsPage.buttonExists());
        assertTrue(differentElementsPage.defaultButtonExists());
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

    @Then("Log status for (.+) and (.+) is (.+)")
    public void properLogRowAndValueShouldBeDisplayed(String checkbox1, String checkbox2, String statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox1, statement)));
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox2, statement)));
    }

    @Then("Proper log status for (.+) is (.+)")
    public void logStatusForSelenIsTrue(String type, String radioButton) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: value changed to %s", type, radioButton)));
    }

    @Then("I see log for (.+) is (.+)")
    public void properLogStatusForYellowColor(String color, String type) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: value changed to %s", color, type)));
    }

    @Then("Log status for (.+) and (.+) changed to (.+)")
    public void logStatusForWaterAndWindChangedToFalse(String checkbox1, String checkbox2, String statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox1, statement)));
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", checkbox2, statement)));
    }

    @Then("\"(.+)\" page is opened")
    public void userTablePageIsOpened(String pageTitle) {
        assertEquals(homePage.pageTitle(), pageTitle);
    }

    @And("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void sixNumberTypeDropdownsAreDisplayed() {
        assertEquals(userTablePage.dropdownsAmount(), 6);
    }

    @And("6 User names are displayed on Users Table on User Table Page")
    public void sixUserNamesAreDisplayed() {
        assertTrue(userTablePage.userNamesIsDisplayed());
    }

    @And("6 Description images are displayed on Users Table on User Table Page")
    public void sixDescriptionImagesAreDisplayed() {
        assertTrue(userTablePage.descriptionImagesIsDisplayed());
    }

    @And("6 Description texts under images are displayed on Users Table on User Table Page")
    public void sixDescriptionTextsUnderImagesAreDisplayed() {
        assertTrue(userTablePage.textUnderImagesIsDisplayed());
    }

    @And("6 checkboxes are displayed on Users Table on User Table Page")
    public void sixCheckboxesAreDisplayed() {
        assertTrue(userTablePage.userCheckboxesIsDisplayed());
    }

    @And("User table contains following values:")
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

    @Then("Droplist contains values:")
    public void droplistContainsValues(List<String> items) {
        List<WebElement> userOptions = TestContext.getDriver()
                .findElements(By.xpath("//td[contains(string(), 'Roman')]//..//option"));
        List<String> userOptionsList = userOptions.stream()
                .map(WebElement::getText)
                        .collect(Collectors.toList());
        assertEquals(userOptionsList, items);
    }
}
