package hw2.ex1;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise01 extends BaseTest {


    @Test (groups = "All")
    public void testEpamGithubSiteOptions() {

        // TODO It could be extracted to the BeforeMethod
        // TODO It is allow avoid code duplication
        // Fixed

        // TODO Code duplication with Exercise2
        // Fixed

        // TODO Code duplication with Exercise2

        assertCommonFirstMethods();

        // TODO Code duplication with line assertEquals(driver.getTitle(), "Home Page");
        // Fixed. This is step 5 in HW. Moved to BaseTest().


        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts

        assertEquals(creatingListOfItemsByPath(headerMenuPath).size(), 4);
        // TODO IS it possible to avoid using indexes to check elements?
        // TODO This check could be extracted to separate parametrized method

        assertEquals(creatingListOfElements(headerMenuPath) ,listOfHeaderMenuItemsElements);

        // 7. Assert that there are 4 images on the Index Page and they are displayed

        // TODO What is the purpose of the current driver invocation?
        // Don't know, what I thought about...

        // TODO It is could be simplified
        // Fixed
        assertEquals(creatingListOfElements(iconsPath).size(), 4);

        List<WebElement> icons = creatingListOfItemsByPath(iconsPath);
        for (WebElement icon : icons){
            assertTrue(icon.isDisplayed());
        }

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text

        // TODO IS it possible to avoid using indexes to check elements?
        // TODO This check could be extracted to separate paraetrized method
        // Fixed
        assertEquals(creatingListOfElements(iconsAtIndexPagePath) ,listOfUnderIconsText);
//
        // 9. Assert a text of the main headers

        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.name("jdi-text")).getText(), epamText);

        // 10. Assert that there is the iframe in the center of page
        elementIsDisplayed(driver.findElement(By.id("iframe")));

        // 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        assertTrue(driver.switchTo().frame(0).findElement(By.id("epam_logo")).isDisplayed());

        // 12. Switch to original window back
        driver.switchTo().defaultContent();

        // 13. Assert a text of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@ui='link']")).getText(), "JDI GITHUB");

        // 14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.xpath("//a[@ui='link']"))
                .getAttribute("href"), "https://github.com/epam/JDI");

        // 15. Assert that there is Left Section
        elementIsDisplayed(driver.findElement(By.name("navigation-sidebar")));

        // 16. Assert that there is Footer
        elementIsDisplayed(driver.findElement(By.cssSelector(".footer-bg")));

    }


}
