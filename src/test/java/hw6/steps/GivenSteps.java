package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;

public class GivenSteps extends BaseStep {

    @Given("I am on \"Home Page\"")
    public void IAmOnTheHomePage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

}
