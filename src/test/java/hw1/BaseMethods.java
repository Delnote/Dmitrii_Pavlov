package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseMethods {

    protected Calculator calc;

    @BeforeClass (alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
    }


    @AfterClass (alwaysRun = true)
    public void afterClass() {
        calc = null;
    }

}
