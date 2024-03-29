package hw3.ex2;

import hw3.base.BaseTest;
import hw3.enums.HeaderMenu;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceMenuDropdownItems;
import hw3.steps.ActionSteps;
import hw3.steps.AssertionSteps;
import hw5.AllureAttachmentListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static hw3.enums.DifferentElementsPageData.*;
import static hw3.enums.MainPageData.HOME_PAGE;

@Feature("HW3 EX2 EPAM JDI site testing")
@Listeners(AllureAttachmentListener.class)
public class Exercise02 extends BaseTest {

    private ActionSteps actionSteps;
    private AssertionSteps assertionSteps;

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp() {
        super.setUp();
        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @Story("Epam JDI site testing")
    @Description("HW3 ex1 to pass correctly")
    @Test (groups = "All")
    public void testEpamGithubSiteOptions() {

        // 2. Assert Browser title
        assertionSteps.webPageTitleCheck(HOME_PAGE.getName());
        // 3. Perform login
        actionSteps.loginToEpamGitHubIoTestSite(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));
        // 4. Assert User name in the left-top side of screen that user is loggined
        assertionSteps.checkingValidAccountName(userInfo.getProperty("user.data"));
        // 5. Click on "Service"  subcategory in the header and check that drop down contains options
        actionSteps.clickHeaderServiceButton(HeaderMenu.SERVICE);
        assertionSteps.checkHeaderServiceMenuItems();
        // 6. Click on Service subcategory in the left section and check that drop down contains options
        actionSteps.clickLeftSideServiceButton(LeftSideMenu.SERVICE);
        assertionSteps.checkLeftSideServiceMenuItems();
        // 7. Open through the header menu Service -> Different Elements Page
        actionSteps.clickHeaderServiceButton(HeaderMenu.SERVICE);
        actionSteps.clickDifferentElementsHeaderDropdownMenuItem(ServiceMenuDropdownItems.DIFFERENT_ELEMENTS);
        // 8. Check interface on Different elements page, it contains all needed elements
        // assert checkboxes
        assertionSteps.checkAmountOfCheckboxes();
        // assert radio buttons
        assertionSteps.checkAmountOfRadioButtons();
        // assert dropdown colors
        assertionSteps.checkColorsDropdownExists();
        // buttons
        assertionSteps.checkDefaultButtonExists();
        assertionSteps.checkButtonExists();
        // 9. Assert that there is Right Section
        assertionSteps.checkLogSideBarExists();
        // 10. Assert that there is Left Section
        assertionSteps.checkNavigationSideBar();
        // 11. Select checkboxes
        actionSteps.clickCheckbox(WATER.getName());
        actionSteps.clickCheckbox(WIND.getName());
        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        assertionSteps.checkWeatherLog(WATER.getName(), true);
        assertionSteps.checkWeatherLog(WIND.getName(), true);
        // 13. Select radio Selen
        actionSteps.clickRadioButton(SELEN.getName());
        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        assertionSteps.checkLog(METAL.getName(), SELEN.getName());
        // 15. Select in dropdown
        actionSteps.clickColorType(YELLOW.getName());
        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertionSteps.checkLog(COLORS.getName(), YELLOW.getName());
        // 17. Unselect and assert checkboxes
        actionSteps.clickCheckbox(WIND.getName());
        actionSteps.clickCheckbox(WATER.getName());
        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        assertionSteps.checkWeatherLog(WATER.getName(), false);
        assertionSteps.checkWeatherLog(WIND.getName(), false);
    }
}
