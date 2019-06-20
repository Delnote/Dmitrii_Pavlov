package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinTesting extends BaseTest {

    @Test(groups = { "All", "Second group" }, dataProviderClass = DataProviders.class, dataProvider = "sinData")
    public void sinTesting(double num, double num2) {
        System.out.println("sin test");
        double actual = calc.sin(num);
        // TODO What is happens with the test if I change data in DataProviders.subSumLongData???

        // Если изменить условия в DataProviders то в нашем случае тест упадет, поскольку
        // мы ожидаем определенный результат в каждом конкретном тесте исходя из
        // заданных данных. Это касается всех тестов с подсчетом в данной HW.


        // TODO should our test failed if I change data in Data Provider ex. 15 - 15?
        // TODO What is the purpose of using DataProvider here?
        // TODO How match test data rows we could have in Data Provider?

        // In previous version test should be filed. Now all test data (actual, expected) takes from DataProvider.
        // Now I put few data set in each DataProvider, to use it's main purpose. All data we changing in DataProvider.
        // We can set any number of data to test all boarder conditions of necessary part of code.

        assertEquals(actual, num2);
    }

}
