package hw2.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.Paths;

public class BaseTest {

    protected WebDriver driver;

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
}
