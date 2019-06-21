package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Calculator calc;

    @BeforeMethod(alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
    }


    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        calc = null;
    }

}
