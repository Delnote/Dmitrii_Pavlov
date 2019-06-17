package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sqrtData")
    public void sqrtTesting(double num) {
        System.out.println("sqrt test");
        double actual = calc.sqrt(num);
        double expected = 7;
        assertEquals(actual, expected);
    }

}
