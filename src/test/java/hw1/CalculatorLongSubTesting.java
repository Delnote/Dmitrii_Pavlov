package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorLongSubTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "subLongData")
    public void subLongTesting(long num1, long num2, long num3) {
        System.out.println("sub long test");
        long actual = calc.sub(num1,num2);
        assertEquals(actual, num3);
    }

}
