package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Calculator calc;

    // TODO Why do you use @BeforeClass?
    // BeforeClass используется для задания условий, которые будут выполняться перед каждым взванным тестовым классом.
    // TODO Why not @BeforeMethod?
    @BeforeClass (alwaysRun = true)
    public void beforeClass() {
        calc = new Calculator();
    }


    @AfterClass (alwaysRun = true)
    public void afterClass() {
        calc = null;
    }

}
