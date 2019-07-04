package hw5.steps;


import hw3.voids.HomePage;
import hw5.TestProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps {

    private WebDriver driver;

    private HomePage homePage;

    public ActionSteps(WebDriver driver) {
        this.driver = driver;
        TestProvider.getInstance().setDriver(driver);
        homePage = new HomePage(driver);
    }
    @Step("Login with test user credentials: '{0}'")
    public void loginToEpamGitHubIoTestSite(String login, String password) {
        homePage.login(login, password);
    }

    @Step("Return to page main content")
    public void returnToTheOriginalWindowFromIFrame() {
        driver.switchTo().defaultContent();
    }
}
