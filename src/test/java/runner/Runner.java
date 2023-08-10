package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //save failed tests to rerun.txt
        plugin = {"json:target/cucumber.json", "rerun:target/rerun.txt"},
        //path from content root (folder -> features)
        features = "src/test/resources/features",
        glue = "steps",
        dryRun = false, // (true) if I don't have some steps implemented yet in features.class it will show the issue
        //(false) if I don't have some steps implemented yet in features.class will run and after show the issue
        tags = "@MB8-101"
)

public class Runner {
}
