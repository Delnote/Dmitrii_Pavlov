package hw3.voids;

import hw3.enums.HeaderMenu;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceMenuDropdownItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "navigation-sidebar")
    private WebElement navigationSideBar;

    @FindBy(css = ".logs")
    private WebElement logDesk;

    @FindBy(name = "log-sidebar")
    private WebElement logSideBar;

    @FindBy(id = "user-name")
    private WebElement accountUserName;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[contains(@class, 'm-')]/li")
    private List<WebElement> headerMenuItems;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a")
    private List<WebElement> headerServiceDropdownMenuItems;

    @FindBy(xpath = "//li[@index='3' and contains (@class, ('menu-title'))]//li")
    private List<WebElement> leftSideServiceDropdownMenuItems;

    public void login(String userName, String password) {
        userIcon.click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public String accountUserName() {
        return accountUserName.getText();
    }

    public String logStatus() {
        return logDesk.getText();
    }

    public boolean logSideBarExists() {
        return logSideBar.isDisplayed();
    }

    public boolean navigationSideBarExists() {
        return navigationSideBar.isDisplayed();
    }

    public List<String> headerMenuItems() {
        return getListStringFromListWebElements(headerMenuItems);
    }

    public void clickHeaderServiceButton(HeaderMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public List<String> headerServiceDropdownMenuItems() {
        return getListStringFromListWebElements(headerServiceDropdownMenuItems);
    }

    public void clickLeftSideServiceButton(LeftSideMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public void clickDifferentElementsHeaderDropdownMenuItem(ServiceMenuDropdownItems menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public List<String> leftSideServiceDropdownMenuItems() {
        return getListStringFromListWebElements(leftSideServiceDropdownMenuItems);
    }



    public List<String> getListStringFromListWebElements(List<WebElement> list) {
        List<String> actualElements = new ArrayList<>();
        for (WebElement item : list) {
            actualElements.add(item.getText().toUpperCase());
        }
        return actualElements;
    }
}
