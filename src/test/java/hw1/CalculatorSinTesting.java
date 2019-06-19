package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sinData")
    public void sinTesting(double num) {
        System.out.println("sin test");
        double actual = calc.sin(num);
        // TODO What is happens with the test if I change data in DataProviders.subSumLongData???

        // Если изменить условия в DataProviders то в нашем случае тест упадет, поскольку
        // мы ожидаем определенный результат в каждом конкретном тесте исходя из
        // заданных данных. Это касается всех тестов с подсчетом в данной HW.

        // TODO should our test failed if I change data in Data Provider ex. 15 - 15?
        // TODO What is the purpose of using DataProvider here?
        // TODO How match test data rows we could have in Data Provider?
        double expected = 0;
        assertEquals(actual, expected);
    }

}
