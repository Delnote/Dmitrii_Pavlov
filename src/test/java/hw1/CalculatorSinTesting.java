package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinTesting extends BaseMethods {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sinData")
    public void sinTesting(double num) {
        System.out.println("sin test");
        double actual = calc.sin(num);
        double expected = 0;
        assertEquals(actual, expected);
    }

}
