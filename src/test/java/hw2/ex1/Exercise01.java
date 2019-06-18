package hw2.ex1;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");

        // 5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(driver
                .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]//a[text()='Home']"))
                .isDisplayed());
        assertTrue(driver
                .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]//a[text()='Contact form']"))
                .isDisplayed());
        assertTrue(driver
                .findElement(By.cssSelector(".dropdown-toggle"))
                .isDisplayed());
        assertTrue(driver
                .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]//a[text()='Metals & Colors']"))
                .isDisplayed());

        // 6.1 Assert correct button names in header section
        assertEquals(driver
                .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]//a[text()='Home']"))
                .getText(), "HOME");
        assertEquals(driver
                .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]//a[text()='Contact form']"))
                .getText(), "CONTACT FORM");
        assertEquals(driver
                .findElement(By.cssSelector(".dropdown-toggle"))
                .getText(), "SERVICE");
        assertEquals(driver
                .findElement(By.xpath("//ul[contains(@class, 'uui-navigation')]//a[text()='Metals & Colors']"))
                .getText(), "METALS & COLORS");

        // 7. Assert that there are 4 images on the Index Page and they are displayed
        driver.get("http://epam.github.io/JDI/index.html");
        assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By
                .xpath("//div[@class='benefit-icon']//span[contains(@class, 'icon-practise')]/../following-sibling::span[@class='benefit-txt']"))
                .getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(driver.findElement(By
                .xpath("//div[@class='benefit-icon']//span[contains(@class, 'icon-custom')]/../following-sibling::span[@class='benefit-txt']"))
                .getText(), "To be flexible and\ncustomizable");
        assertEquals(driver.findElement(By
                .xpath("//div[@class='benefit-icon']//span[contains(@class, 'icon-multi')]/../following-sibling::span[@class='benefit-txt']"))
                .getText(), "To be multiplatform");
        assertEquals(driver.findElement(By
                .xpath("//div[@class='benefit-icon']//span[contains(@class, 'icon-base')]/../following-sibling::span[@class='benefit-txt']"))
                .getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        // 9. Assert a text of the main headers
        String epamText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
                "TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
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
