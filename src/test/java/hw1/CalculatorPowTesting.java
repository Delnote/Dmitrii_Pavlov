package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowTesting extends BaseMethods {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "powData")
    public void powTesting(double num1, double num2) {
        System.out.println("pow test");
        double actual = calc.pow(num1,num2);
        double expected = 125;
        assertEquals(actual, expected);
    }

}
