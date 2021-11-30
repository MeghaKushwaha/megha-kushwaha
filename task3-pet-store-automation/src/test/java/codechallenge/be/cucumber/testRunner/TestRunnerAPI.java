package codechallenge.be.cucumber.testRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


/**
 * TestRunner class
 *
 * Cucumber options default set, change according to your needs
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        features={"src/test/resources/features/api/"},
        glue = {"codechallenge.be.cucumber.serenityDefinitions"}
)
public class TestRunnerAPI {

}
