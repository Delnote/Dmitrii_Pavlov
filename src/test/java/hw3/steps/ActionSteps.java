package hw3.steps;


import hw3.enums.HeaderMenu;
import hw3.enums.ServiceMenuDropdownItems;
import hw3.enums.LeftSideMenu;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;

public class ActionSteps {

    private WebDriver driver;

    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    public ActionSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    // TODO Why do you hard-coded parameters here?
    public void loginToEpamGitHubIoTestSite(String login, String password) {
        homePage.login("epam", "1234");
    }

    // TODO returnToTheOriginalWindowFromIFrame
    public void returnToTheOriginalWindowFromIframe() {
        driver.switchTo().defaultContent();
    }

    public void clickHeaderServiceButton(HeaderMenu menuItem) {
        homePage.clickHeaderServiceButton(menuItem);
    }

    public void clickLeftSideServiceButton(LeftSideMenu menuItem) {
        homePage.clickLeftSideServiceButton(menuItem);
    }

    public void clickDifferentElementsHeaderDropdownMenuItem(ServiceMenuDropdownItems menuItem) {
        homePage.clickDifferentElementsHeaderDropdownMenuItem(menuItem);
    }

    // TODO It will be better if you send name of checkboxes as parameter
    public void clickWaterCheckbox() {
        differentElementsPage.clickWaterCheckbox();
    }

    // TODO It will be better if you send name of checkboxes as parameter
    public void clickWindCheckBox() {
        differentElementsPage.clickWindCheckbox();
    }

    // TODO It will be better if you send name of radio button as parameter
    public void clickSelenRadioButton() {
        differentElementsPage.clickSelenRadioButton();
    }

    // TODO It will be better if you send name of value in dropdown as parameter
    public void clickYellowColorType() {
        differentElementsPage.clickYellowColorType();
    }

}
