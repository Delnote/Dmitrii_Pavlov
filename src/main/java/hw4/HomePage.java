package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.ServiceMenuDropdownItems;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public HomePage() {
        page(this);
    }

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "login-button")
    private SelenideElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement userName;

    @FindBy(xpath = "//a[@class='dropdown-toggle' and contains(text(), 'Service')]")
    private SelenideElement headerServiceDropdownMenuItem;

    @FindBy(name = "navigation-sidebar")
    private SelenideElement navigationSideBar;

    public void checkTitle(String title) {
        $(String.valueOf(title().equalsIgnoreCase(title)));
    }

    public SelenideElement navigationSideBar() {
        return navigationSideBar;
    }

    public List<String> enumMenuItemsList = Arrays.stream(ServiceMenuDropdownItems.values())
            .map(ServiceMenuDropdownItems::getUpperCaseName).collect(Collectors.toList());

    public void login(String userName, String password) {
        $("#user-icon").click();
        $(By.id("name")).sendKeys(userName);
        $(By.id("password")).sendKeys(password);
        $(By.id("login-button")).click();
    }

    public SelenideElement userName() {
        return userName;
    }

    public void clickHeaderMenuServiceOption() {
        headerServiceDropdownMenuItem.click();
    }

    public void clickLeftSideServiceDropdownMenuItem() {
        $(By.xpath("//li[@class='menu-title' and contains(string(), 'Service')]")).click();
    }

    public ElementsCollection headerMenuServiceOption() {
        return $$(By.xpath("//ul[@class='dropdown-menu']//a"));
    }

    public ElementsCollection leftSideMenuServiceOption() {
        return $$(By.xpath("//li[contains(@class, 'menu-title') and contains(@index, '3')]/ul/li"));
    }

    public void clickHeaderMenuItem(String menuItem) {
        $(By.linkText(menuItem)).click();
    }

}