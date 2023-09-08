package testrunner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(
			plugin = {"pretty"},
			monochrome=false,  //console output color
			features = "src/test/resources/features", //location of feature files
			glue= {"apphooks","stepDefinitions"} 
			
			) //location of step definition files


	public class TestRunner extends AbstractTestNGCucumberTests{
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }

	}