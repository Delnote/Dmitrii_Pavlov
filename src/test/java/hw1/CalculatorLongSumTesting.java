package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorLongSumTesting extends BaseTest {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "subSumLongData")
    public void sumLongTesting(long num1, long num2) {
        System.out.println("sum long test");
        long actual = calc.sum(num1,num2);
        // TODO What is happens with the test if I change data in DataProviders.subSumLongData???
        // Если изменить условия в DataProviders то в нашем случае тест упадет, поскольку
        // мы ожидаем определенный результат в каждом конкретном тесте исходя из
        // заданных данных. Это касается всех тестов с подсчетом в данной HW.
        long expected = 25;
        assertEquals(actual, expected);
    }

}
