package hw3.steps;

import hw3.enums.*;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
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

    public void webPageTitleCheck(String pageTitle) {
        assertEquals(driver.getTitle(), pageTitle);
    }

    public void checkingValidAccountName(String accountName) {
        assertEquals(homePage.accountUserName(), accountName);
    }

    public void checkingSizeAndProperHeaderMenuItemsNames() {
        assertEquals(homePage.headerMenuItems().size(), 4);
        assertEquals(homePage.headerMenuItems().toArray(),
                Arrays.stream(HeaderMenu.values()).map(HeaderMenu::getName).toArray());
    }

    public void checkingThatIconsExistsOnPage() {
        assertEquals(homePage.amountOfIconItems(), 4);
    }

    public void checkingExistingAndProperTextUnderIcons() {
        assertEquals(homePage.iconDescriptionText().size() , 4);
        assertEquals(homePage.iconDescriptionText().toArray(),
                Arrays.stream(UnderIconsText.values()).map(UnderIconsText::getName).toArray());
    }

    public void checkingProperMainTextHeaderAndBody(String testHeader, String text) {
        assertEquals(homePage.mainPageTextTitle(), testHeader);
        assertEquals(homePage.mainPageText(), text);
    }

    // TODO iFrameIsDisplayed
    // Fixed
    public void iFrameIsDisplayed() {
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());
    }

    // TODO checkEpamLogoInIFrameIsDisplayed
    // Fixed
    public void checkEpamLogoInIFrameIsDisplayed() {
        assertTrue(driver.switchTo().frame(0).findElement(By.id("epam_logo")).isDisplayed());
    }

    // TODO checkProperSubHeaderText
    // Fixed
    public void checkProperSubHeaderText(String subHeaderText) {
        assertEquals(homePage.subHeaderText(), subHeaderText);
    }

    public void checkingProperLinkText(String link) {
        assertEquals(homePage.mainPageLink(), link);
    }

    public void checkLeftSectionIsDisplayed() {
        assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());
    }

    // TODO checkFooterExist
    // Fixed
    public void checkFooterExist() {
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());
    }

    public void checkHeaderServiceMenuItems() {
        List<String> enumMenuItemsList = Arrays.stream(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.headerServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    public void checkLeftSideServiceMenuItems() {
        List<String> enumMenuItemsList = Stream.of(ServiceMenuDropdownItems.values())
                .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());
        assertTrue(homePage.leftSideServiceDropdownMenuItems().containsAll(enumMenuItemsList));
    }

    public void checkAmountOfCheckboxes() {
        assertEquals(differentElementsPage.checkboxesAmount(), 4);
    }

    // TODO checkAmountOfRadioButtons
    // Fixed
    public void checkAmountOfRadioButtons() {
        assertEquals(differentElementsPage.radioButtonsAmount(), 4);
    }

    public void checkColorsDropdownExists() {
        assertTrue(differentElementsPage.colorsDropdownExists());
    }

    public void checkDefaultButtonExists() {
        assertTrue(differentElementsPage.defaultButtonExists());
    }

    public void checkButtonExists() {
        assertTrue(differentElementsPage.buttonExists());
    }

    public void checkLogSideBarExists() {
        assertTrue(differentElementsPage.logSideBarExists());
    }

    public void checkNavigationSideBar() {
        assertTrue(differentElementsPage.navigationSideBarExists());
    }

    public void checkWeatherLog(String weather, Boolean statement) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: condition changed to %b", weather, statement)));
    }

    public void checkLog(String metal, String type) {
        assertTrue(differentElementsPage.logStatus()
                .contains(String.format("%s: value changed to %s", metal, type)));
    }

}
