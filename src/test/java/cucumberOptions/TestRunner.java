package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"stepDefinitions"},
		features="src/test/java/features",
		//tags="@Test123",
		plugin = { "html:target/cucumber-html-report.html", "json:target/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"junit:target/cucumber-results.xml" },
		 monochrome = true)
public class TestRunner {

}
