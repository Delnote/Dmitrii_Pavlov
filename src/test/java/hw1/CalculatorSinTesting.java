package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sinData")
    public void sinTesting(double num, double num2) {
        System.out.println("sin test");
        double actual = calc.sin(num);
        assertEquals(actual, num2);
    }

}
