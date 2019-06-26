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

    public void loginToEpamGitHubIoTestSite(String login, String password) {
        homePage.login("epam", "1234");
    }

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

    public void clickWaterCheckbox() {
        differentElementsPage.clickWaterCheckbox();
    }

    public void clickWindCheckBox() {
        differentElementsPage.clickWindCheckbox();
    }

    public void clickSelenRadioButton() {
        differentElementsPage.clickSelenRadioButton();
    }

    public void clickYellowColorType() {
        differentElementsPage.clickYellowColorType();
    }

}
