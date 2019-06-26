package hw3.base;

import hw3.utils.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;


public class BaseTest {

    protected WebDriver driver;
    protected Properties userInfo;

    @BeforeSuite (alwaysRun = true)
    public void setUpData() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();

        userInfo = FileUtils.readUserFromFile("src/test/resources/properties/user.properties");

        driver.get("https://epam.github.io/JDI");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
