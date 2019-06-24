package hw2.ex2;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise02 extends BaseTest {

    @Test(groups = "All")
    public void testEpamGithubSiteOptions() {

        // TODO Method name is unclear
        // Fixed

        loginEpamGithubPage();

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        checkingActualElements(headerMenuServiceDropdownItemsPath, listOfDropdownMenuElements);

        // 6. Click on Service subcategory in the left section and check that drop down contains options

        driver.findElement(By.xpath("//a[@ui = 'label' and contains(string(), 'Service')]"))
                .click();
        checkingActualElements(leftSideMenuServiceDropdownPath, listOfLeftDropdownMenuElements);

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By
                .xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Different elements')]"))
                .click();

        // 8. Check interface on Different elements page, it contains all needed elements

        // assert checkboxes
        // TODO Is it possible avoid using index in locator
        // Fixed
        assertEquals(webElementsListSize(checkboxPath), checkboxesValue);
        // assert radio buttons
        // TODO Is it possible avoid using index in locator
        // Fixed
        assertEquals(webElementsListSize(radioButtonPath), checkboxesValue);
        // assert dropdown colors
        elementIsDisplayed(driver.findElement(By.cssSelector(".colors")));
        // buttons
        elementIsDisplayed(driver.findElement(By.name("Default Button")));
        elementIsDisplayed(driver.findElement(By.xpath("//input[@value = 'Button']")));


        // 9. Assert that there is Right Section
        elementIsDisplayed(driver.findElement(By.name("log-sidebar")));

        // 10. Assert that there is Left Section
        elementIsDisplayed(driver.findElement(By.name("navigation-sidebar")));

        // 11. Select checkboxes
        driver.findElement(By.xpath("//label[contains(string(), 'Water')]")).click();
        driver.findElement(By.xpath("//label[contains(string(), 'Wind')]")).click();

        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
      
        checkWeatherLog(water, true);
        checkWeatherLog(wind, true);

        // 13. Select radio Selen

        driver.findElement(By.xpath("//label[contains(string(), 'Selen')]")).click();

        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.

        checkLog(metal, selen);

        // 15. Select in dropdown

        driver.findElement(By.xpath("//option[contains(text(), 'Yellow')]")).click();

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.

        checkLog(colors, yellow);

        // 17. Unselect and assert checkboxes

        driver.findElement(By.xpath("//label[contains(string(), 'Water')]")).click();
        driver.findElement(By.xpath("//label[contains(string(), 'Wind')]")).click();

        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.

        checkWeatherLog(water, false);
        checkWeatherLog(wind, false);
    }
}
