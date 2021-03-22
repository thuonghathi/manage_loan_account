package configuration;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testcases", //the path of the feature files
        glue={"stepdefinitions","configuration"} //the path of the step definition files
//        ,tags = {"@phone"}
        ,plugin = {"json:target/cucumber.json"}
)
public class TestRunner {

}
