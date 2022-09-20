package stepDefinitions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import BaseFields.BaseFields;
import Utils.CucumberReportSupportUtils;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class stepDefs extends BaseFields{
	
	private Scenario ExecutionScenario;
	CucumberReportSupportUtils CucumberReportSupportUtils = new CucumberReportSupportUtils();

	@BeforeStep
	public void SetTheScenario(Scenario scenario) {
		ExecutionScenario = scenario;
	}
	
	@Given("Start the Test")
	public void start_the_test() {

		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("setAcceptUntrustedCertificates", true);
		// options.addArguments("--headless", "--window-size=1920,1200");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("start-maximized");
		options.addArguments("chrome.switches", "--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", "/Users/goverdhanreddygarudaiah/Documents/git/TestNGDemo/src/test/resources/Drivers/chromedriver");
		capabilities.setCapability("chrome.binary", "/Users/goverdhanreddygarudaiah/Documents/git/TestNGDemo/src/test/resources/Drivers/chromedriver");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		chromedriver = new ChromeDriver(options);
		chromedriver.get("https://google.com");
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CucumberReportSupportUtils.CaptureScreenShots_Chrome(chromedriver, ExecutionScenario);
	}

}
