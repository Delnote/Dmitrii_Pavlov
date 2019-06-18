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
    protected String headerMenuPath = "//header/div/nav/ul[1]/li";


    @BeforeSuite (alwaysRun = true)
    public void setUpDriverPath() {

        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
        driver = new ChromeDriver();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    protected List<WebElement> checkMenuItemsIsDisplayed (String itemPath){

        return driver.findElements(By.xpath(itemPath));

    }

}
