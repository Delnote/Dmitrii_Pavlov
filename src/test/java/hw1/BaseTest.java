package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Calculator calc;

    // TODO Why do you use @BeforeClass?
    // BeforeClass используется для задания условий, которые будут выполняться перед каждым взванным тестовым классом.
    // TODO Why not @BeforeMethod?

    // Because we have only one test method in each class and we're running through xml by classes. BeforeMethod works in that test the same.
    // So if we need to run few methods in one class and necessary to run by methods in clear environment, we'll write BeforeMethod too, and run by methods in xml.

    @BeforeMethod(alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
    }


    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        calc = null;
    }

}
