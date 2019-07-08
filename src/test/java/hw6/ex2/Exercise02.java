package hw6.ex2;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"}
        )
public class Exercise02 extends AbstractTestNGCucumberTests {
}
