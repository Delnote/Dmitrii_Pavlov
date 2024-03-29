package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    private static DifferentElementsPage instance;

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

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new DifferentElementsPage(driver);
        }
        return instance;
    }

    public static void closeInstance() {
        instance = null;
    }

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

    public void clickCheckbox(String element) {
        driver.findElement(By.xpath("//label[contains(string(), '" + element + "')]")).click();
    }

    public void clickRadioButton(String element) {
        driver.findElement(By.xpath("//label[contains(string(), '" + element +"')]")).click();
    }

    public void clickColorType(String element) {
        driver.findElement(By.xpath("//option[contains(text(), '" + element + "')]")).click();
    }
}
