package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "sumLongData")
    public static Object[][] subSumLongData(){
        return new Object[][]{{20L, 5L, 25L},
                {-100L, 140L, 40L},
                {0L, 0L, 0L},
                {-40L, 40L, 0L},
                {-20L, -50L, -70L}};
    }

    @DataProvider(name = "subLongData")
    public static Object[][] subSubLongData(){
        return new Object[][]{{20L, 5L, 15L},
                {-100L, 140L, -240L},
                {0L, 0L, 0L},
                {40L, -40L, 80L},
                {-20L, -50L, 30L}};
    }

    @DataProvider(name = "powData")
    public static Object[][] powData(){
        return new Object[][]{{5d, 3d, 125d},
                {10d, 2d, 100d},
                {2d, 10d, 1024d},
                {3d, 0d, 1d},
                {1d, 100d, 1d}};
    }

    @DataProvider(name = "sinData")
    public static Object[][] sinData(){
        return new Object[][]{{0d, 0d}};
    }

    @DataProvider(name = "sqrtData")
    public static Object[][] sqrtData(){
        return new Object[][]{{49d, 7d},
                {225d, 15d},
                {9d, 3d},
                {1d, 1d},
                {100d, 10d}};
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
