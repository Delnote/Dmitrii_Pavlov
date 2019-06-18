package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CalculatorIsNegativeTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "isNegativeData")
    public void isNegativeTesting(long num) {
        System.out.println("isNegative test");
        // TODO I think this variable is redundant
        // TODO Could be replaced to assertTrue

        assertTrue(calc.isNegative(num));

    }

}
