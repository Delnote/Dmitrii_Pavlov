package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowTesting extends BaseTest {

    @Test(groups = { "All", "First group" }, dataProviderClass = DataProviders.class, dataProvider = "powData")
    public void powTesting(double num1, double num2) {
        System.out.println("pow test");
        double actual = calc.pow(num1,num2);
        // TODO What is happens with the test if I change data in DataProviders.subSumLongData???
        // Если изменить условия в DataProviders то в нашем случае тест упадет, поскольку
        // мы ожидаем определенный результат в каждом конкретном тесте исходя из
        // заданных данных. Это касается всех тестов с подсчетом в данной HW.
        double expected = 125;
        assertEquals(actual, expected);
    }

}
