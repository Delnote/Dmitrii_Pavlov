package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorLongSumTesting extends BaseMethods {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "subSumLongData")
    public void sumLongTesting(long num1, long num2) {
        System.out.println("sum long test");
        long actual = calc.sum(num1,num2);
        long expected = 25;
        assertEquals(actual, expected);
    }

}
