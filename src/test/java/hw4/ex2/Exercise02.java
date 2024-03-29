package hw4.ex2;

import hw3.utils.FileUtils;
import hw4.HomePage;
import hw4.MetalsAndColorsPage;
import hw4.builder.TestDataBuilder;
import hw4.dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static hw3.enums.HeaderMenu.METALS_AND_COLORS;
import static hw3.enums.MainPageData.HOME_PAGE;

public class Exercise02 {

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        close();
    }

    private Properties userInfo =
            FileUtils.readUserFromFile("src/test/resources/properties/user.properties");

    @Test(groups = {"All"}, dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void testEpamGithubSiteOptions(TestDataBuilder testDataBuilder) {
        // 1. Open test site by URL
        HomePage homePage = open("https://epam.github.io/JDI", HomePage.class);
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();
        // 2. Assert Browser title
        homePage.checkTitle().shouldHave(attribute("text", HOME_PAGE.getName()));
        // 3. Perform login
        homePage.login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));
        // 4. Click on the link on the Header section
        homePage.clickHeaderMenuItem(METALS_AND_COLORS.getName());
        // 5. Fill form on the page
        metalsAndColorsPage.fillFormAndCheckData(testDataBuilder.getOdd(), testDataBuilder.getEven(), testDataBuilder.getMetals(),
                testDataBuilder.getColors(), testDataBuilder.getElements(), testDataBuilder.getVegetables());

        $(By.id("submit-button")).click();

        if (testDataBuilder.getOdd() != null && testDataBuilder.getEven() != null) {
            $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Summary')]"))
                    .shouldHave(text("" + (Integer.parseInt(testDataBuilder.getOdd()) + Integer.parseInt(testDataBuilder.getEven()))));
        }

        if (testDataBuilder.getMetals() != null) {
            $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Metal')]"))
                    .shouldHave(text(testDataBuilder.getMetals()));
        }

        if (testDataBuilder.getColors() != null) {
            $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Color')]"))
                    .shouldHave(text(testDataBuilder.getColors()));
        }

        if (testDataBuilder.getElements() != null) {
            for (String element : testDataBuilder.getElements()) {
                $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Elements')]"))
                        .shouldHave(text(element));
            }
        }

        if (testDataBuilder.getVegetables() != null) {
            for (String element : testDataBuilder.getVegetables()) {
                $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Vegetables')]"))
                        .shouldHave(text(element));
            }
        }
        close();
    }
}
