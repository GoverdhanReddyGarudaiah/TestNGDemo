package MyRunner;

import org.testng.annotations.AfterSuite;
import BaseFields.BaseFields;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/Feature_Test", glue = { "stepDefinitions" }, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, publish = true)

public class TestRunner_Test extends BaseFields {


	@AfterSuite(alwaysRun = true)
	public void TearDown() throws Throwable {
		if (chromedriver != null) {
			chromedriver.close();
			chromedriver.quit();
		}
	}

}
