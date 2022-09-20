package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseFields.BaseFields;
import io.cucumber.java.Scenario;

public class ScreenShotUtils extends BaseFields {

	public void captureScreenShot(Scenario scenario) {
		System.out.println("inside screenshot Utils");

		String ScreenShot = "data:image/png;base64,"
				+ ((TakesScreenshot) chromedriver).getScreenshotAs(OutputType.BASE64);
		scenario.log("<img src=" + ScreenShot + ">");
	}
}
