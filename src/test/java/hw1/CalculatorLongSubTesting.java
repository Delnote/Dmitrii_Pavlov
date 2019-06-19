package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorLongSubTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "subSumLongData")
    public void subLongTesting(long num1, long num2) {
        System.out.println("sub long test");
        long actual = calc.sub(num1,num2);
        // TODO What is happens with the test if I change data in DataProviders.subSumLongData???

        // Если изменить условия в DataProviders то в нашем случае тест упадет, поскольку
        // мы ожидаем определенный результат в каждом конкретном тесте исходя из
        // заданных данных. Это касается всех тестов с подсчетом в данной HW.

        // TODO should our test failed if I change data in Data Provider ex. 15 - 15?
        // TODO What is the purpose of using DataProvider here?
        // TODO How match test data rows we could have in Data Provider?

        long expected = 15;
        assertEquals(actual, expected);
    }

}
