package hw3.steps;


import hw3.enums.HeaderMenu;
import hw3.enums.ServiceMenuDropdownItems;
import hw3.enums.LeftSideMenu;
import hw3.voids.DifferentElementsPage;
import hw3.voids.HomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
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

    @Step("Login with test user credentials: '{0}'")
    public void loginToEpamGitHubIoTestSite(String login, String password) {
        homePage.login(login, password);
    }

    @Step("Return to original form")
    public void returnToTheOriginalWindowFromIFrame() {
        driver.switchTo().defaultContent();
    }

    @Step("Header service button click")
    public void clickHeaderServiceButton(HeaderMenu menuItem) {
        homePage.clickHeaderServiceButton(menuItem);
    }

    @Step("Left side Service button click")
    public void clickLeftSideServiceButton(LeftSideMenu menuItem) {
        homePage.clickLeftSideServiceButton(menuItem);
    }

    @Step("Different Elements item in header Service dropdown click")
    public void clickDifferentElementsHeaderDropdownMenuItem(ServiceMenuDropdownItems menuItem) {
        homePage.clickDifferentElementsHeaderDropdownMenuItem(menuItem);
    }

    @Step("Click checkbox: '{0}'")
    public void clickCheckbox(String element) {
        differentElementsPage.clickCheckbox(element);
    }

    @Step("Click radio: '{0}'")
    public void clickRadioButton(String element) {
        differentElementsPage.clickRadioButton(element);
    }

    @Step("Click color: '{0}'")
    public void clickColorType(String element) {
        differentElementsPage.clickColorType(element);
    }

}
