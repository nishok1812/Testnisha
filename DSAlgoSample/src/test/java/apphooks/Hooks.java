package apphooks;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverManager;
import io.cucumber.java.Before;
import utilities.CommonUtils;


public class Hooks {

		
		public static WebDriver driver;

	    @Before
	    public void beforeScenario() {
	    	
	    	try {
	    		CommonUtils.loadProperties();
	   
	    	
	    	if (DriverManager.getDriver()==null) {
	    	//Drivermanager.launchBrowser();
	    	driver = DriverManager.launchBrowser();
	    	System.out.println(" apps driver fetched is" +driver);
	    	
	    	}
	    	
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    }

	    public static WebDriver getDriver() {
	    	
	        return driver;
	    }
}

