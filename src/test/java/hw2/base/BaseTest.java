package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    // TODO Locator could be improved
    protected String headerMenuPath = "//header/div/nav/ul[1]/li";
    protected String iconsAtIndexPagePath = "//div[contains(@class, 'benefits')]//span[contains(@class, 'benefit-txt')]";
    protected String headerMenuServiceDropdownItemsPath = "//ul[@class='dropdown-menu']//a";
    // TODO Locator could be improved
    protected String leftSideMenuServiceDropdown = "//li[@index='3']//ul//span";

    protected String epamText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
            "TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
            "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
            "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";


    @BeforeSuite (alwaysRun = true)
    public void setUpDriverPath() {

        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
        // TODO Why do you create driver BeforeSuite?
        driver = new ChromeDriver();
    }

    // TODO Why do you close driver AfterSuite?
    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    // TODO Where is check in this method?
    protected List<WebElement> checkItemsIsDisplayed (String itemPath){

        return driver.findElements(By.xpath(itemPath));

    }

    protected void loginEpamGithubIoTest () {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();
    }
}
