package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorIsNegativeTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "isNegativeData")
    public void isNegativeTesting(long num) {
        System.out.println("isNegative test");
        boolean actual = calc.isNegative(num);
        boolean expected = true;
        assertEquals(actual, expected);
    }

}
