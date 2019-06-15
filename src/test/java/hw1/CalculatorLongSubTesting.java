package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorLongSubTesting extends BaseMethods {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "subSumLongData")
    public void subLongTesting(long num1, long num2) {
        System.out.println("sub long test");
        long actual = calc.sub(num1,num2);
        long expected = 15;
        assertEquals(actual, expected);
    }

}
