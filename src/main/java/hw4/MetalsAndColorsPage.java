package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MetalsAndColorsPage {

    public MetalsAndColorsPage() {
        page(this);
    }

    @FindBy(name = "table-with-pages_length")
    private SelenideElement selectedTableLengthOption;

    @FindBy(css = ".logs")
    private SelenideElement logDesk;

    @FindBy(xpath = "//input[@type='search']")
    private SelenideElement searchField;

    @FindBy(xpath = "//table[@ui='d-table']/tbody/tr")
    private ElementsCollection table;

    public SelenideElement logDesk() {
        return logDesk;
    }

    public ElementsCollection amountOfEntries() {
        return $$(".sorting_1");
    }

    public SelenideElement selectedTableLengthOption() {
        return selectedTableLengthOption;
    }

    public void searchField(String text) {
        searchField.sendKeys(text);
    }

    public ElementsCollection table() {
        return table;
    }

    public void checkTableRows(String text) {
        for (SelenideElement element : table) {
            element.shouldHave(text(text));
        }
    }

    public void fillFormAndCheckData(String odd, String even, String metals, String colors, List<String> elements, List<String> vegetables) {

        // check add and even not null
        if (odd == null) {
            odd = $(By.xpath("//input[@name='custom_radio_odd' and @checked]/..//label")).getText();
        } else {
            $(By.xpath("//input[@name='custom_radio_odd']/..//label[contains (text(), '" + odd + "')]")).click();
        }
        if (even == null) {
            even = $(By.xpath("//input[@name='custom_radio_even' and @checked]/..//label")).getText();
        } else {
            $(By.xpath("//input[@name='custom_radio_even']/..//label[contains (text(), '" + even + "')]")).click();
        }

        // check metals  not null
        if (metals == null) {
            metals = $(By.xpath("//button[@title='Metals']/span")).getText();
        } else {
            $(By.xpath("//button[@title='Metals']/span[@class='caret']")).click();
            $(By.xpath("//span[contains (text(), '"+ metals +"')]")).click();
        }

        // check colors not null
        if (colors == null) {
            colors = $(By.xpath("//button[@title='Colors']/span")).getText();
        } else {
            $(By.xpath("//div[@id ='colors']")).click();
            $(By.xpath("//span[contains (text(), '"+ colors +"')]")).click();
        }

        // check elements not null
        if (elements != null) {
            for (String element : elements){
                $(By.xpath("//label[contains(text(), '" + element + "')]")).click();
            }
        }

        // check vegetables not null
        if (vegetables != null) {
            for (String element : vegetables){
                $(By.xpath("//button[@class='btn btn-default dropdown-toggle']/span")).click();
                $(By.xpath("//label[contains(text(), '" + element + "')]")).click();
            }
        } else {
            vegetables = Arrays.asList($(By.xpath("//button[@class='btn btn-default dropdown-toggle']")).getText());
        }

        $(By.id("submit-button")).click();

        $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Summary')]"))
                .shouldHave(text("" + (Integer.parseInt(odd) + Integer.parseInt(even))));
        $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Metal')]"))
                .shouldHave(text(metals));
        $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Color')]"))
                .shouldHave(text(colors));
        if (elements != null) {
            for (String element : elements){
                $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Elements')]"))
                        .shouldHave(text(element));
            }
        }
            for (String element : vegetables) {
                $(By.xpath("//ul[@class='panel-body-list results']/li[contains (text(), 'Vegetables')]"))
                        .shouldHave(text(element));
            }
    }
}