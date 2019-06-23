package hw2.ex2;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise02 extends BaseTest {

    @Test(groups = "All")
    public void testEpamGithubSiteOptions() {

        // TODO It could be extracted to the BeforeMethod
        // Fixed
        // TODO It is allow avoid code duplication
        // Fixed
        // 1. Open test site by URL

        assertCommonFirstMethods();

        // TODO Code duplication with Exercise1
        // Fixed
        // 2. Assert Browser title


        // 3. Perform login


        // TODO Code duplication with Exercise1
        // Fixed
        // 4. Assert User name in the left-top side of screen that user is loggined


        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        // TODO IS it possible to avoid using indexes to check elements?
        // Fixed
        // TODO This check could be extracted to separate parametrized method
        // Fixed
        checkingActualElements(headerMenuServiceDropdownItemsPath, listOfDropdownMenuElements);

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        // TODO Locator could be improved
        // Improved
        driver.findElement(By.xpath("//a[@ui = 'label' and contains(string(), 'Service')]")).click();
        // TODO IS it possible to avoid using indexes to check elements?
        // Fixed
        // TODO This check could be extracted to separate parametrized method
        // Fixed
        checkingActualElements(leftSideMenuServiceDropdownPath, listOfLeftDropdownMenuElements);

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By
                .xpath("//li[@class='dropdown']//a[contains(text(), 'Service')]"))
                .click();
        driver.findElement(By
                .xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Different elements')]"))
                .click();

        // 8. Check interface on Different elements page, it contains all needed elements
        // TODO Is it possible to simplify this peace of code?
        // done
        // TODO What do you expect from this peace of code?
        // Forgot assert
        // TODO Locator could be simplified
        // Fixed

        // assert checkboxes
        assertEquals(webelementsListSize("//div[@class = 'main-content-hg']/div[2]/label"), checkboxesValue);
        // assert radio buttons
        assertEquals(webelementsListSize("//div[@class = 'main-content-hg']/div[3]/label"), checkboxesValue);
        // assert dropdown colors
        elementIsDisplayed(driver.findElement(By.cssSelector(".colors")));
        // buttons
        elementIsDisplayed(driver.findElement(By.name("Default Button")));
        elementIsDisplayed(driver.findElement(By.xpath("//input[@value = 'Button']")));


        // 9. Assert that there is Right Section
        // TODO What do you expect from this method?
        // Forgot assert, fixed
        elementIsDisplayed(driver.findElement(By.name("log-sidebar")));

        // 10. Assert that there is Left Section
        // TODO What do you expect from this method?
        // Forgot assert, fixed
        elementIsDisplayed(driver.findElement(By.name("navigation-sidebar")));

        // 11. Select checkboxes
        // TODO What do you expect from this methods?
        // Forgot assert
        // TODO Locator could be simplified
        // Fixed
        driver.findElement(By.xpath("//label[contains(string(), 'Water')]")).click();
        driver.findElement(By.xpath("//label[contains(string(), 'Wind')]")).click();

        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        // TODO Locator could be simplified
        //fixed
        checkWeatherLog(water, trueStatement);
        checkWeatherLog(wind, trueStatement);

        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        // Fixed

        // 13. Select radio Selen
        // TODO Locator could be simplified
        //fixed
        driver.findElement(By.xpath("//label[contains(string(), 'Selen')]")).click();

        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        checkLog(metal, selen);

        // 15. Select in dropdown
        // TODO Locator could be simplified
        // Fixed
        driver.findElement(By.xpath("//option[contains(text(), 'Yellow')]")).click();

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        // Fixed
        checkLog(colors, yellow);

        // 17. Unselect and assert checkboxes
        // TODO Locator could be simplifie
        // Fixed
        driver.findElement(By.xpath("//label[contains(string(), 'Water')]")).click();
        driver.findElement(By.xpath("//label[contains(string(), 'Wind')]")).click();

        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        // TODO code duplication
        // TODO it is could be extracted to separate parametrized method
        // Fixed
        checkWeatherLog(water, falseStatement);
        checkWeatherLog(wind, falseStatement);
    }
}
