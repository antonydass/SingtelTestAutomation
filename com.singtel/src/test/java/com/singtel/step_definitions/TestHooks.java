package com.singtel.step_definitions;

import java.util.Map;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.singtel.utilities.BrowserActions;
import com.singtel.utilities.ReadProperties;
import com.singtel.utilities.ScreenshotHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks extends ScreenshotHelper {

	public static Scenario myScenario;
	public static Properties envProperties = ReadProperties.getPropInstance().testProperties;
	BrowserActions actions = new BrowserActions();
	WebDriver driver = actions.getInstance();
	
	@Before
	public void before_everyScenario(Scenario scenraio){
		myScenario = scenraio;
		
	}

	@After
	public void after_everyScenario(Scenario scenario){

		try {
			Map<String, Object> screenShots = ScreenshotHelper.getScreenShotsForCurrentTest();
			for (Map.Entry<String, Object> screenShot : screenShots.entrySet()) {
				scenario.write(screenShot.getKey());
				scenario.embed((byte[]) screenShot.getValue(), "image/png");
			}

			ScreenshotHelper.tidyUpAfterTestRun();

			if (scenario.isFailed()) {
				scenario.write(webDriver.getCurrentUrl());
				byte[] screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenShot, "image/png");    	
			}
			
		} catch (WebDriverException | ClassCastException wde) {
			//  LOG.error(wde.getMessage());
		} finally {
			//webDriver.switchTo().defaultContent();
			//quitDriver();	
    	   //driver.close();
		}
		//quitDriver();
	}
	
	
	           
}
