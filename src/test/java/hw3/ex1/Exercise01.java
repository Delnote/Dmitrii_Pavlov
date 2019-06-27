package hw3.ex1;

import hw3.base.BaseTest;
import hw3.steps.ActionSteps;
import hw3.steps.AssertionSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.enums.MainPageData.*;

public class Exercise01 extends BaseTest {

    private ActionSteps actionSteps;
    private AssertionSteps assertionSteps;

    @BeforeMethod(alwaysRun = true)
    @Override
    public void setUp() {
        super.setUp();
        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);

    }

    @Test (groups = "All")
    public void testEpamGithubSiteOptions() {
        // 2. Assert Browser title
        assertionSteps.webPageTitleCheck(HOME_PAGE.getName());
        // 3. Perform login
        // TODO It could be extracted to User class :)
        // But user class we did only on 4th lecture
        actionSteps.loginToEpamGitHubIoTestSite(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));
        // 4. Assert User name in the left-top side of screen that user is loggined
        // TODO It could be extracted to User class :)
        // But user class we did only on 4th lecture
        assertionSteps.checkingValidAccountName(userInfo.getProperty("user.data"));
        // 5. Assert Browser title
        assertionSteps.webPageTitleCheck(HOME_PAGE.getName());
        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionSteps.checkingSizeAndProperHeaderMenuItemsNames();
        // 7. Assert that there are 4 images on the Index Page and they are displayed
        assertionSteps.checkingThatIconsExistsOnPage();
        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionSteps.checkingExistingAndProperTextUnderIcons();
        // 9. Assert a text of the main headers
        assertionSteps.checkingProperMainTextHeaderAndBody(MAIN_PAGE_TEXT_HEADER.getName(), MAIN_PAGE_TEXT.getName());
        // 10. Assert that there is the iframe in the center of page
        assertionSteps.iFrameIsDisplayed();
        // 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        assertionSteps.checkEpamLogoInIFrameIsDisplayed();
        // 12. Switch to original window back
        actionSteps.returnToTheOriginalWindowFromIFrame();
        // 13. Assert a text of the sub header
        assertionSteps.checkProperSubHeaderText(SUB_HEADER_TEXT.getName());
        // 14. Assert that JDI GITHUB is a link and has a proper URL
        assertionSteps.checkingProperLinkText("https://github.com/epam/JDI");
        // 15. Assert that there is Left Section
        assertionSteps.checkLeftSectionIsDisplayed();
        // 16. Assert that there is Footer
        assertionSteps.checkFooterExist();
    }
}
