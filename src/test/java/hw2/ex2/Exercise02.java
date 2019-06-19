package hw2.ex2;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise02 extends BaseTest {

    @Test(groups = "All")
    public void testEpamGinhubSiteOptions() {

        // TODO It could be extracted to the BeforeMethod
        // TODO It is allow avoid code duplication
        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI");

        // TODO Code duplication with Exercise1
        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        loginEpamGithubIoTest();

        // TODO Code duplication with Exercise1
// 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        // TODO IS it possible to avoid using indexes to check elements?
        // TODO This check could be extracted to separate paraetrized method
        assertEquals(checkItemsIsDisplayed(headerMenuServiceDropdownItemsPath).get(0).getText(), "Support".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuServiceDropdownItemsPath).get(1).getText(), "Dates".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuServiceDropdownItemsPath).get(3).getText(), "Complex Table".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuServiceDropdownItemsPath).get(4).getText(), "Simple Table".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuServiceDropdownItemsPath).get(6).getText(), "Table with pages".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuServiceDropdownItemsPath).get(7).getText(), "Different elements".toUpperCase());

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        // TODO Locator could be improved
        driver.findElement(By.xpath("//li[@index='3']")).click();
        // TODO IS it possible to avoid using indexes to check elements?
        // TODO This check could be extracted to separate paraetrized method
        assertEquals(checkItemsIsDisplayed(leftSideMenuServiceDropdown).get(0).getText(), "Support".toUpperCase());
        assertEquals(checkItemsIsDisplayed(leftSideMenuServiceDropdown).get(1).getText(), "Dates".toUpperCase());
        assertEquals(checkItemsIsDisplayed(leftSideMenuServiceDropdown).get(2).getText(), "Complex Table".toUpperCase());
        assertEquals(checkItemsIsDisplayed(leftSideMenuServiceDropdown).get(3).getText(), "Simple Table".toUpperCase());
        assertEquals(checkItemsIsDisplayed(leftSideMenuServiceDropdown).get(6).getText(), "Table with pages".toUpperCase());
        assertEquals(checkItemsIsDisplayed(leftSideMenuServiceDropdown).get(7).getText(), "Different elements".toUpperCase());

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By
                .xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Different elements')]"))
                .click();

        // 8. Check interface on Different elements page, it contains all needed elements
        // TODO Is it possible to simplify this peace of code?
        // TODO What do you expect from this peace of code?
        // TODO Locator could be simplified
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Water')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Earth')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Wind')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Fire')]")).isDisplayed();

        // 9. Assert that there is Right Section
        // TODO What do you expect from this method?
        driver.findElement(By.name("log-sidebar")).isDisplayed();

        // 10. Assert that there is Left Section
        // TODO What do you expect from this method?
        driver.findElement(By.name("navigation-sidebar")).isDisplayed();

        // 11. Select checkboxes
        // TODO What do you expect from this methods?
        // TODO Locator could be simplified
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Gold')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Silver')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Bronze')]")).isDisplayed();
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Selen')]")).isDisplayed();

        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        // TODO Locator could be simplified
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Water')]")).click();
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Water: condition changed to true"));

        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Wind')]")).click();
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Wind: condition changed to true"));

        // 13. Select radio Selen
        // TODO Locator could be simplified
        driver.findElement(By.xpath("//label[@class='label-radio' and contains(string(), 'Selen')]")).click();

        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("metal: value changed to Selen"));

        // 15. Select in dropdown
        // TODO Locator could be simplified
        driver.findElement(By.xpath("//select[@class='uui-form-element']//option[contains(text(), 'Yellow')]")).click();

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Colors: value changed to Yellow"));

        // 17. Unselect and assert checkboxes
        // TODO Locator could be simplified
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Water')]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox' and contains(string(), 'Wind')]")).click();

        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Water: condition changed to false"));
        assertTrue(driver.findElement(By.cssSelector(".logs"))
                .getText().contains("Wind: condition changed to false"));
    }
}
