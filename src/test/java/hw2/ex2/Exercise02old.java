package hw2.ex2;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise02old extends BaseTest {

    @Test(groups = "All")
    public void testEpamGinhubSiteOptions() {

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI");

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        assertTrue(driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Support')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Dates')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Complex Table')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Simple Table')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Table with pages')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Different elements')]"))
                .isDisplayed());

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.xpath("//li[@index='3']"))
                .click();
        assertTrue(driver.findElement(By
                .xpath("//li[@index='3']//span[contains(text(), 'Support')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//li[@index='3']//span[contains(text(), 'Dates')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//li[@index='3']//span[contains(text(), 'Complex Table')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//li[@index='3']//span[contains(text(), 'Simple Table')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//li[@index='3']//span[contains(text(), 'Table with pages')]"))
                .isDisplayed());
        assertTrue(driver.findElement(By
                .xpath("//li[@index='3']//span[contains(text(), 'Different elements')]"))
                .isDisplayed());

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By
                .xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Different elements')]"))
                .click();

        // 8. Check interface on Different elements page, it contains all needed elements
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Water')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Earth')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Wind')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Fire')]")).isDisplayed();

        // 9. Assert that there is Right Section
        driver.findElement(By.name("log-sidebar")).isDisplayed();

        // 10. Assert that there is Left Section
        driver.findElement(By.name("navigation-sidebar")).isDisplayed();

        // 11. Select checkboxes
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Gold')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Silver')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Bronze')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Selen')]")).isDisplayed();

        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Water')]")).click();
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Water: condition changed to true"));

        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Wind')]")).click();
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Wind: condition changed to true"));

        // 13. Select radio Selen
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Selen')]")).click();

        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("metal: value changed to Selen"));

        // 15. Select in dropdown
        driver.findElement(By.xpath("//select[@class='uui-form-element']//option[contains(text(), 'Yellow')]")).click();

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Colors: value changed to Yellow"));

        // 17. Unselect and assert checkboxes
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Water')]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Wind')]")).click();

        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Water: condition changed to false"));
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Wind: condition changed to false"));
    }
}
