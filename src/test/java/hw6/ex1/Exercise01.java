package hw6.ex1;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"}
        )
public class Exercise01 extends AbstractTestNGCucumberTests {
}
