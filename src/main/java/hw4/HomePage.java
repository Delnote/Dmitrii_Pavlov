package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

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