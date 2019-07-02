package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import hw3.utils.FileUtils;
import hw4.HomePage;
import hw4.MetalsAndColorsPage;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static hw3.enums.MainPageData.HOME_PAGE;
import static hw3.enums.ServiceMenuDropdownItems.TABLE_WITH_PAGES;

public class Exercise01{

    private Properties userInfo = FileUtils.readUserFromFile("src/test/resources/properties/user.properties");

    @Test (groups = "All")
    public void testEpamGithubSiteOptions() {
        // 1. Open test site by URL
        HomePage homePage = open("https://epam.github.io/JDI", HomePage.class);
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();
        // 2. Assert Browser title
        homePage.checkTitle().shouldHave(attribute("text", HOME_PAGE.getName()));
        // 3. Perform login
        homePage.login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));
        // 4. Assert User name in the left-top side of screen that user is loggined
        homePage.userName().shouldHave(text(userInfo.getProperty("user.data")));
        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.clickHeaderMenuServiceOption();
        // TODO Looks like a bit tricky
        homePage.headerMenuServiceOption()
                .shouldHave(CollectionCondition.texts(homePage.enumMenuItemsList));
        // 6. Click on Service subcategory in the left section and check that drop down contains options
        homePage.clickLeftSideServiceDropdownMenuItem();
        // TODO Looks like a bit tricky
        homePage.leftSideMenuServiceOption()
                .shouldHave(CollectionCondition.textsInAnyOrder(homePage.enumMenuItemsList));
        // 7. Open through the header menu Service -> Table with pages
        homePage.clickHeaderMenuServiceOption();
        homePage.clickHeaderMenuItem(TABLE_WITH_PAGES.getName());
        // 8. Check that default value for “Show entries” dropdown is 5
        metalsAndColorsPage.selectedTableLengthOption().shouldHave(value("5"));
        // 9. Assert that there is Right Section
        metalsAndColorsPage.logDesk().shouldHave(visible);
        // 10. Assert that there is Left Section
        homePage.navigationSideBar().shouldHave(visible);
        // 11. Select new value for the entries in the dropdown list
        metalsAndColorsPage.selectedTableLengthOption().selectOptionByValue("10");
        // 12. Assert that for the dropdown there is an individual log row and value is corresponded to the value of dropdown.
        metalsAndColorsPage.logDesk().shouldHave(text("draw"), text(" length, new value=" +
                metalsAndColorsPage.selectedTableLengthOption().getSelectedValue()));
        // 13. Assert that in the table displayed corrected amount of entries
        metalsAndColorsPage.amountOfEntries().shouldHaveSize(10);
        // 14. Type in “Search” text field
        metalsAndColorsPage.searchField("custom");
        // 15. Assert the table contains only records with Search field value
        metalsAndColorsPage.checkTableRows("custom");
        close();
    }
}
