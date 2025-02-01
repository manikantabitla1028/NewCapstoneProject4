package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/MiniProject.feature", // Path to feature files
        glue = "stepdefinitions",                // Package containing step definitions
        plugin = {                               // Plugins for reporting
                "pretty",                            // Print Gherkin steps in the console
                "html:target/cucumber-reports.html", // Generate HTML report
                "json:target/cucumber-reports.json"  // Generate JSON report
        },
        monochrome = true,
        dryRun=false

)
public class TestRunner {


}
