package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorLongSumTesting extends BaseTest {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "sumLongData")
    public void sumLongTesting(long num1, long num2, long num3) {
        System.out.println("sum long test");
        long actual = calc.sum(num1,num2);
        assertEquals(actual, num3);
    }

}
