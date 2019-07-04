package hw5.steps;


import hw3.enums.HeaderMenu;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceMenuDropdownItems;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import hw5.TestProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps {

    private WebDriver driver;

    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    public ActionSteps(WebDriver driver) {
        this.driver = driver;
        TestProvider.getInstance().setDriver(driver);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
    @Step("Login with test user credentials: '{0}'")
    public void loginToEpamGitHubIoTestSite(String login, String password) {
        homePage.login(login, password);
    }

    @Step("Return to page main content")
    public void returnToTheOriginalWindowFromIFrame() {
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

    public void clickCheckbox(String element) {
        differentElementsPage.clickCheckbox(element);
    }

    public void clickRadioButton(String element) {
        differentElementsPage.clickRadioButton(element);
    }

    public void clickColorType(String element) {
        differentElementsPage.clickColorType(element);
    }

}
