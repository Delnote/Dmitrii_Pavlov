package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@class = 'label-checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//label[@class = 'label-radio']")
    private List<WebElement> radioButtons;

    @FindBy(css = ".colors")
    private WebElement colorsDrodown;

    @FindBy(name = "Default Button")
    private WebElement defaultButton;

    @FindBy(xpath = "//input[@value = 'Button']")
    private WebElement button;

    // TODO It will be better use List<WebElements> here instead of element
    @FindBy(xpath = "//label[contains(string(), 'Water')]")
    private WebElement waterCheckbox;

    // TODO It will be better use List<WebElements> here instead of element
    @FindBy(xpath = "//label[contains(string(), 'Wind')]")
    private WebElement windCheckbox;

    // TODO It will be better use List<WebElements> here instead of element
    @FindBy(xpath = "//label[contains(string(), 'Selen')]")
    private WebElement selenRadioButton;

    // TODO It will be better use List<WebElements> here instead of element
    @FindBy(xpath = "//option[contains(text(), 'Yellow')]")
    private WebElement yellowColorType;

    public int checkboxesAmount() {
        return checkboxes.size();
    }

    public int radioButtonsAmount() {
        return radioButtons.size();
    }

    public boolean colorsDropdownExists() {
        return colorsDrodown.isDisplayed();
    }

    public boolean defaultButtonExists() {
        return defaultButton.isDisplayed();
    }

    public boolean buttonExists() {
        return button.isDisplayed();
    }

    public void clickWaterCheckbox() {
        waterCheckbox.click();
    }

    public void clickWindCheckbox() {
        windCheckbox.click();
    }

    public void clickSelenRadioButton() {
        selenRadioButton.click();
    }

    public void clickYellowColorType() {
        yellowColorType.click();
    }
}
