package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sqrtData")
    public void sqrtTesting(double num) {
        System.out.println("sqrt test");
        double actual = calc.sqrt(num);
        // TODO What is happens with the test if I change data in DataProviders.subSumLongData???
        // Если изменить условия в DataProviders то в нашем случае тест упадет, поскольку
        // мы ожидаем определенный результат в каждом конкретном тесте исходя из
        // заданных данных. Это касается всех тестов с подсчетом в данной HW.
        double expected = 7;
        assertEquals(actual, expected);
    }

}
