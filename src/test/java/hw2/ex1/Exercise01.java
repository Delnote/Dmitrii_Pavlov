package hw2.ex1;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise01 extends BaseTest {


    @Test (groups = "All")
    public void testEpamGinhubSiteOptions() {

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI");

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        loginEpamGithubIoTest();

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");

        // 5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts

        assertEquals(checkItemsIsDisplayed(headerMenuPath).size(), 4);
        assertEquals(checkItemsIsDisplayed(headerMenuPath).get(0).getText(), "Home".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuPath).get(1).getText(), "Contact form".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuPath).get(2).getText(), "Service".toUpperCase());
        assertEquals(checkItemsIsDisplayed(headerMenuPath).get(3).getText(), "Metals & Colors".toUpperCase());

        // 7. Assert that there are 4 images on the Index Page and they are displayed

        driver.get("http://epam.github.io/JDI/index.html");
        assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text

        assertEquals(checkItemsIsDisplayed(iconsAtIndexPagePath).get(0)
                .getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(checkItemsIsDisplayed(iconsAtIndexPagePath).get(1)
                .getText(), "To be flexible and\ncustomizable");
        assertEquals(checkItemsIsDisplayed(iconsAtIndexPagePath).get(2)
                .getText(), "To be multiplatform");
        assertEquals(checkItemsIsDisplayed(iconsAtIndexPagePath).get(3)
                .getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        // 9. Assert a text of the main headers

        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.name("jdi-text")).getText(), epamText);

        // 10. Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

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
        assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());

        // 16. Assert that there is Footer
        assertTrue((driver.findElement(By.cssSelector(".footer-bg"))).isDisplayed());

    }


}
