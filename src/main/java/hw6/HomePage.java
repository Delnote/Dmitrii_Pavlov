package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static HomePage instance;

    @FindBy(xpath = "//span[contains(@class, 'icons-benefit')]")
    private List<WebElement> iconItems;

    @FindBy(xpath = "//div[contains(@class, 'benefits')]//span[contains(@class, 'benefit-txt')]")
    private List<WebElement> iconDescriptionText;

    @FindBy(name = "main-title")
    private WebElement mainPageTextTitle;

    @FindBy(name = "jdi-text")
    private WebElement mainPageText;

    @FindBy(xpath = "//a[@ui='link']")
    private WebElement subHeaderText;

    @FindBy(xpath = "//a[@ui='link']")
    private WebElement mainPageLink;

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    public static void closeInstance() {
        instance = null;
    }

    public int amountOfIconItems() {
        return iconItems.size();
    }

    public List<String> iconDescriptionText() {
        List<WebElement> elements = iconDescriptionText;
        List<String> actualElements = new ArrayList<>();
        for (WebElement element : elements) {
            actualElements.add(element.getText());
        }
        return actualElements;
    }

    public String mainPageTextTitle() {
        return mainPageTextTitle.getText();
    }

    public String mainPageText() {
        return mainPageText.getText();
    }
}
