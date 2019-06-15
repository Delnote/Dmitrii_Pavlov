package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorIsPositiveTesting extends BaseMethods {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "isPositiveData")
    public void isPositiveTesting(long num) {
        System.out.println("isPositive test");
        boolean actual = calc.isPositive(num);
        boolean expected = true;
        assertEquals(actual, expected);
    }

}
