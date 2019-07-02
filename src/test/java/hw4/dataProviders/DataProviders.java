package hw4.dataProviders;

import hw4.builder.TestDataBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;


import static hw4.enams.Colors.*;
import static hw4.enams.Elements.*;
import static hw4.enams.Metals.*;
import static hw4.enams.Vegetables.*;

public class DataProviders {

    // TODO What is the length of the line of code should be by java code convention?
    // 70 - 80 characters.
    // Fixed
    @DataProvider(name = "testData")
    public Object[][] testData(){

        TestDataBuilder testData1 = TestDataBuilder.builder()
                .elements(Arrays.asList(EARTH.getName()))
                .colors(YELLOW.getName())
                .metals(GOLD.getName())
                .build();

        TestDataBuilder testData2 = TestDataBuilder.builder()
                .odd("3").even("8")
                .vegetables(Arrays.asList(
                        CUCUMBER.getName(),
                        TOMATO.getName()))
                .build();

        TestDataBuilder testData3 = TestDataBuilder.builder()
                .odd("3").even("2")
                .elements(Arrays.asList(
                        WATER.getName(),
                        WIND.getName(),
                        FIRE.getName()))
                .metals(BRONZE.getName())
                .vegetables(Arrays.asList(ONION.getName()))
                .build();

        TestDataBuilder testData4 = TestDataBuilder.builder()
                .odd("5").even("6")
                .elements(Arrays.asList(WATER.getName()))
                .colors(GREEN.getName())
                .metals(SELEN.getName())
                .vegetables(Arrays.asList(
                        ONION.getName(),
                        TOMATO.getName(),
                        VEGETABLES.getName(),
                        CUCUMBER.getName()))
                .build();

        TestDataBuilder testData5 = TestDataBuilder.builder()
                .elements(Arrays.asList(FIRE.getName()))
                .colors(BLUE.getName())
                .vegetables(Arrays.asList(
                        CUCUMBER.getName(),
                        TOMATO.getName(),
                        VEGETABLES.getName()))
                .build();

        return new Object[][]{
                {testData1},
                {testData2},
                {testData3},
                {testData4},
                {testData5}
        };
    }
}
