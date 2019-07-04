package hw3.steps;

import hw3.enums.*;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps{

    private WebDriver driver;

    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    public AssertionSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Verify page title: '{0}'")
    public void webPageTitleCheck(String pageTitle) {
        assertEquals(driver.getTitle(), pageTitle);
    }

    @Step("Check proper test user name: '{0}'")
    public void checkingValidAccountName(String accountName) {
        assertEquals(homePage.accountUserName(), accountName);
    }

    @Step("Check amount and proper header menu items")
    public void checkingSizeAndProperHeaderMenuItemsNames() {
        assertEquals(homePage.headerMenuItems().size(), 4);
        assertEquals(homePage.headerMenuItems().toArray(),
                Arrays.stream(HeaderMenu.values()).map(HeaderMenu::getName).toArray());
    }

    @Step("Check amount of image icons")
    public void checkingThatIconsExistsOnPage() {
        assertEquals(homePage.amountOfIconItems(), 4);
    }

    @Step("Proper text under image icons")
    public void checkingExistingAndProperTextUnderIcons() {
        assertEquals(homePage.iconDescriptionText().size() , 4);
        assertEquals(homePage.iconDescriptionText().toArray(),
                Arrays.stream(UnderIconsText.values()).map(UnderIconsText::getName).toArray());
    }

    @Step("Proper of main text and title: '{0}'")
    public void checkingProperMainTextHeaderAndBody(String testHeader, String text) {
        assertEquals(homePage.mainPageTextTitle(), testHeader);
        assertEquals(homePage.mainPageText(), text);
    }

    @Step("iFrame is displayed")
    public void iFrameIsDisplayed() {
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());
    }

    @Step("EPAM logo image in iframe is displayed")
    public void checkEpamLogoInIFrameIsDisplayed() {
        assertTrue(driver.switchTo().frame(0).findElement(By.id("epam_logo")).isDisplayed());
    }

    @Step("Proper sub header text: '{0}'")
    public void checkProperSubHeaderText(String subHeaderText) {
        assertEquals(homePage.subHeaderText(), subHeaderText);
    }

    @Step("Check proper link text")
    public void checkingProperLinkText(String link) {
        assertEquals(homePage.mainPageLink(), link);
    }

    @Step("Left side section is displayed")
    public void checkLeftSectionIsDisplayed() {
        assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());
    }

    @Step("Footer is displayed")
    public void checkFooterExist() {
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());
    }

    @Step("Header menu items proper")
    public void checkHeaderServiceMenuItems() {
        List<String> enumMenuItemsList = Arrays.stream(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.headerServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    @Step("Left side menu items proper")
    public void checkLeftSideServiceMenuItems() {
        List<String> enumMenuItemsList = Stream.of(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.leftSideServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    @Step("Right amount of checkboxes")
    public void checkAmountOfCheckboxes() {
        assertEquals(differentElementsPage.checkboxesAmount(), 4);
    }

    @Step("Right amount of radio buttons")
    public void checkAmountOfRadioButtons() {
        assertEquals(differentElementsPage.radioButtonsAmount(), 4);
    }

    @Step("Colors dropdown exists")
    public void checkColorsDropdownExists() {
        assertTrue(differentElementsPage.colorsDropdownExists());
    }

    @Step("Default button exists")
    public void checkDefaultButtonExists() {
        assertTrue(differentElementsPage.defaultButtonExists());
    }

    @Step("Check button exists")
    public void checkButtonExists() {
        assertTrue(differentElementsPage.buttonExists());
    }

    @Step("Log sidebar exists")
    public void checkLogSideBarExists() {
        assertTrue(differentElementsPage.logSideBarExists());
    }

    @Step("Navigation sidebar exists")
    public void checkNavigationSideBar() {
        assertTrue(differentElementsPage.navigationSideBarExists());
    }

    @Step("Right log for: '{0}'")
    public void checkWeatherLog(String weather, Boolean statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", weather, statement)));
    }

    @Step("Right log for: '{0}'")
    public void checkLog(String metal, String type) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: value changed to %s", metal, type)));
    }

}
