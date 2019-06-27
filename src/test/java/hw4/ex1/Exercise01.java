package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.impl.CollectionElementByCondition;
import hw3.enums.ServiceMenuDropdownItems;
import hw4.HomePage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class Exercise01{

    @Test (groups = "All")
    public void testEpamGithubSiteOptions() {
        // 1. Open test site by URL
        HomePage homePage = open("https://epam.github.io/JDI", HomePage.class);
        // 2. Assert Browser title

        // 3. Perform login
        homePage.login("epam", "1234");
        // 4. Assert User name in the left-top side of screen that user is loggined
        homePage.userName().shouldHave(text("PITER CHAILOVSKII"));
        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.clickHeaderMenuServiceOption();
        homePage.headerMenuServiceOption()
                .shouldHave((CollectionCondition.exactTexts(homePage.enumMenuItemsList)));
        // 6. Click on Service subcategory in the left section and check that drop down contains options
//        homePage.

    }
}
