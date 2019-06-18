package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CalculatorIsPositiveTesting extends BaseTest {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "isPositiveData")
    public void isPositiveTesting(long num) {
        System.out.println("isPositive test");
    // TODO I think this variable is redundant
    // TODO Could be replaced to assertTrue
    // исправлено
        assertTrue(calc.isPositive(num));
    }

}
