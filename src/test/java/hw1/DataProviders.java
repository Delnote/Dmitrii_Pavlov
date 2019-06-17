package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // TODO What is the purpose of the using DataProviders?
    // TODO Why do you decide use this set of test data?

    @DataProvider(name = "subSumLongData")
    public static Object[][] subSumLongData(){
        return new Object[][]{{20L, 5L}};
    }

    @DataProvider(name = "powData")
    public static Object[][] powData(){
        return new Object[][]{{5d, 3d}};
    }

    @DataProvider(name = "sinData")
    public static Object[][] sinData(){
        return new Object[][]{{0}};
    }

    @DataProvider(name = "sqrtData")
    public static Object[][] sqrtData(){
        return new Object[][]{{49}};
    }

    @DataProvider(name = "isNegativeData")
    public static Object[][] isNegativeData(){
        return new Object[][]{{-20}};
    }

    @DataProvider(name = "isPositiveData")
    public static Object[][] isPositiveData(){
        return new Object[][]{{20}};
    }

}
