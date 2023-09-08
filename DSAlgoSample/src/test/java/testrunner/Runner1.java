package testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty"},
		monochrome=false,  //console output color
		features = {"src/test/resources/features/Suite1"}, //location of feature files
		glue= {"apphooks","stepdefinitions"} )

public class Runner1 extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }

}
