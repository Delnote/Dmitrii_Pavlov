package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected WebDriver driver;

    protected int checkboxesValue = 4;

    protected String trueStatement = "true";
    protected String falseStatement = "false";
    protected String wind = "Wind";
    protected String water = "Water";
    protected String selen = "Selen";
    protected String yellow = "Yellow";
    protected String metal = "metal";
    protected String colors = "Colors";
    protected String pageTitle = "Home Page";
    // TODO Locator could be improved
    // Improved
    protected String headerMenuPath = "//ul[contains(@class, 'm-')]/li";
    protected String iconsAtIndexPagePath = "//div[contains(@class, 'benefits')]//span[contains(@class, 'benefit-txt')]";
    protected String headerMenuServiceDropdownItemsPath = "//ul[@class='dropdown-menu']//a";
    // TODO Locator could be improved
    // Improved
    protected String leftSideMenuServiceDropdownPath = "//li[@index='3' and contains (@class, ('menu-title'))]//li";
    protected String iconsPath = "//span[contains(@class, 'icons-benefit')]";
    protected String checkboxPath = "//div[@class = 'main-content-hg']/div[2]/label";
    protected String radioButtonPath = "//div[@class = 'main-content-hg']/div[3]/label";

    protected String epamText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
            "TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
            "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
            "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    protected List<String> listOfHeaderMenuItemsElements = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected List<String> listOfDropdownMenuElements = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");
    protected List<String> listOfLeftDropdownMenuElements = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");
    protected List<String> listOfUnderIconsText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    @BeforeSuite (alwaysRun = true)
    public void setUpDriverPath() {

        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
        // TODO Why do you create driver BeforeSuite?
        // Fixed, forgot to move it to BeforeMethod.
    }

    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://epam.github.io/JDI");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    protected void loginEpamGithubIoTest () {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();
    }

    protected void webpageTitleCheck () {
        assertEquals(driver.getTitle(), pageTitle);
    }

    protected void assertCommonFirstMethods() {

        // 2. Assert Browser title
        webpageTitleCheck();

        // 3. Perform login
        loginEpamGithubIoTest();

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");

        // 5. Assert Browser title
        webpageTitleCheck();

    }

    // TODO Where is check in this method?
    // Fixed name. This method gathering elements by given path if they exists.
    protected List<WebElement> creatingListOfItemsByPath(String itemPath){

        return driver.findElements(By.xpath(itemPath));

    }

    protected List<String> creatingListOfElements(String path) {
        List<WebElement> elements = creatingListOfItemsByPath(path);
        List<String> actualElements = new ArrayList<>();
            for (WebElement element : elements) {
                actualElements.add(element.getText());
            }

        return actualElements;
    }

    protected void checkingActualElements(String itemPath, List<String> itemList) {
        List<String> headerMenuElements = creatingListOfElements(itemPath);
        for (String item : itemList) {
            assertTrue(headerMenuElements.contains(item));
        }
    }

    protected void elementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    protected int webelementsListSize(String path) {

        return creatingListOfItemsByPath(path).size();
    }

    protected void checkWeatherLog(String element, String statement) {
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains(String.format("%s: condition changed to %s", element, statement)));
    }

    protected void checkLog(String type, String element) {
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains(String.format("%s: value changed to %s", type, element)));
    }

}
