package hw4.dataProviders;

import hw4.builder.TestDataBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;


import static hw4.enams.Colors.*;
import static hw4.enams.Elements.*;
import static hw4.enams.Metals.*;
import static hw4.enams.Vegetables.*;

public class DataProviders {

    @DataProvider(name = "testData")
    public Object[][] testData(){

        TestDataBuilder testData1 = TestDataBuilder.builder().Elements(Arrays.asList(EARTH.getName())).Colors(YELLOW.getName()).Metals(GOLD.getName()).build();
        TestDataBuilder testData2 = TestDataBuilder.builder().Odd("3").Even("8").Vegetables(Arrays.asList(CUCUMBER.getName(), TOMATO.getName())).build();
        TestDataBuilder testData3 = TestDataBuilder.builder().Odd("3").Even("2").Elements(Arrays.asList(WATER.getName(), WIND.getName(), FIRE.getName())).Metals(BRONZE.getName()).Vegetables(Arrays.asList(ONION.getName())).build();
        TestDataBuilder testData4 = TestDataBuilder.builder().Odd("5").Even("6").Elements(Arrays.asList(WATER.getName())).Colors(GREEN.getName()).Metals(SELEN.getName()).Vegetables(Arrays.asList(ONION.getName(), TOMATO.getName(), VEGETABLES.getName(), CUCUMBER.getName())).build();
        TestDataBuilder testData5 = TestDataBuilder.builder().Elements(Arrays.asList(FIRE.getName())).Colors(BLUE.getName()).Vegetables(Arrays.asList(CUCUMBER.getName(), TOMATO.getName(), VEGETABLES.getName())).build();

        return new Object[][]{
                {testData1},
                {testData2},
                {testData3},
                {testData4},
                {testData5}
        };
    }
}
