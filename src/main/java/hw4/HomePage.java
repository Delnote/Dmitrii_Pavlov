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

// TODO Please follow structure of the class for Java Code Convention
public class HomePage {

    // TODO Please follow structure of the class for Java Code Convention
    // Fixed

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

    public HomePage() {
        page(this);
    }

    public SelenideElement checkTitle() {
        return $("title");
    }

    public SelenideElement navigationSideBar() {
        return navigationSideBar;
    }

    // TODO Why do you decide store this properties inside of the HomePage PO
    // TODO I assume, that it will be better invoke this set of test data in the test
    // Fixed

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

    public ElementsCollection headerServiceDropdownMenuItems() {
        return $$(By.xpath("//ul[@class='dropdown-menu']//a"));
    }

    public ElementsCollection leftSideServiceDropdownMenuItems() {
        return $$(By.xpath("//li[contains(@class, 'menu-title') and contains(@index, '3')]/ul/li"));
    }

    public void clickHeaderMenuItem(String menuItem) {
        $(By.linkText(menuItem)).click();
    }

}