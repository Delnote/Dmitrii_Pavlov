package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorIsPositiveTesting extends BaseTest {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "isPositiveData")
    public void isPositiveTesting(long num) {
        System.out.println("isPositive test");
        boolean actual = calc.isPositive(num);
        // TODO I think this variable is redundant
        boolean expected = true;
        // TODO Could be replaced to assertTrue
        assertEquals(actual, expected);
    }

}
