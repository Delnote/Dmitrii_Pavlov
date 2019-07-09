package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends BasePage{

    private static UserTablePage instance;

    @FindBy(xpath = "//table[contains(@id, 'user-table')]//select")
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//table[contains(@id, 'user-table')]//a")
    private List<WebElement> userNames;

    @FindBy(xpath = "//table[contains(@id, 'user-table')]//img")
    private List<WebElement> descriptionImages;

    @FindBy(xpath = "//table[contains(@id, 'user-table')]//span")
    private List<WebElement> textUnderImages;

    @FindBy(xpath = "//table[contains(@id, 'user-table')]//input")
    private List<WebElement> userCheckboxes;

    @FindBy(xpath = "//table[contains(@id, 'user-table')]//tr/td[1]")
    private List<WebElement> userNumbers;


    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
        }
        return instance;
    }

    public static void closeInstance() {
        instance = null;
    }

    public int dropdownsAmount() {
        return dropdowns.size();
    }

    public int userNamesAmount() {
        return userNames.size();
    }

    public int descriptionImagesAmount() {
        return descriptionImages.size();
    }

    public int textUnderImagesAmount() {
        return textUnderImages.size();
    }

    public int userCheckboxesAmount() {
        return userCheckboxes.size();
    }

    public List<String> userNumbers() {
        return getListStringFromListWebElements(userNumbers);
    }

    public List<String> userNames() {
        return getListStringFromListWebElements(userNames);
    }

    public List<String> userDescription() {
        return getListStringFromListWebElements(textUnderImages);
    }

    public void clickCheckbox(String name) {
        driver.findElement(By.xpath("//td[contains(string(), '" + name + "')]/..//input")).click();
    }

    public void userDropdownClick(String name) {
        driver.findElement(By.xpath("//td[contains(string(), '" + name +"')]//..//select")).click();
    }

    public List<String> userOptionsList(String name) {
        List<WebElement> userOptions = driver
                .findElements(By.xpath("//td[contains(string(), '" + name + "')]//..//option"));
        return userOptions.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
