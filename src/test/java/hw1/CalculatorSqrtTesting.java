package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sqrtData")
    public void sqrtTesting(double num, double num2) {
        System.out.println("sqrt test");
        double actual = calc.sqrt(num);
        assertEquals(actual, num2);
    }

}
