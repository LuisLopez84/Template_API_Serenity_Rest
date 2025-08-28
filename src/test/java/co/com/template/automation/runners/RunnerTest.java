package co.com.template.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.template.automation.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html" , "json:target/cucumber-reports/cucumber.json"}
)
public class RunnerTest {
}