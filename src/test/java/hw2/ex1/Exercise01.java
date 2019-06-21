package hw2.ex1;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


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


        commonFirstMethods();

        // TODO Code duplication with line assertEquals(driver.getTitle(), "Home Page");
        // Fixed. This is step 5 in HW. Moved to commonFirstMethods().


        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts

        assertEquals(creatingListOfItemsByPath(headerMenuPath).size(), 4);
        // TODO IS it possible to avoid using indexes to check elements?
        // TODO This check could be extracted to separate paraetrized method


//        assertEquals(creatingListOfItemsByPath(headerMenuPath).get(0).getText(), "Home".toUpperCase());
//        assertEquals(creatingListOfItemsByPath(headerMenuPath).get(1).getText(), "Contact form".toUpperCase());
//        assertEquals(creatingListOfItemsByPath(headerMenuPath).get(2).getText(), "Service".toUpperCase());
//        assertEquals(creatingListOfItemsByPath(headerMenuPath).get(3).getText(), "Metals & Colors".toUpperCase());

        // 7. Assert that there are 4 images on the Index Page and they are displayed

        // TODO What is the purpose of the current driver invocation?
        driver.get("http://epam.github.io/JDI/index.html");
        // TODO It is could be simplified
        assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text


        assertEquals(creatingListOfItemsByPath(iconsAtIndexPagePath).get(0)
                .getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(creatingListOfItemsByPath(iconsAtIndexPagePath).get(1)
                .getText(), "To be flexible and\ncustomizable");
        assertEquals(creatingListOfItemsByPath(iconsAtIndexPagePath).get(2)
                .getText(), "To be multiplatform");
        assertEquals(creatingListOfItemsByPath(iconsAtIndexPagePath).get(3)
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
