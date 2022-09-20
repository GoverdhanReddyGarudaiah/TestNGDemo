package Utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.Scenario;

public class CucumberReportSupportUtils {

	public void CaptureScreenShots_Chrome(WebDriver cd, Scenario sc) {
		String ScreenShot = "data:image/png;base64," + ((TakesScreenshot) cd).getScreenshotAs(OutputType.BASE64);
		sc.log("<img src=" + ScreenShot + ">");
	}

	public void CaptureScreenShots_iPhone(IOSDriver iosd, Scenario sc) throws Throwable {

		byte[] bytes = ((TakesScreenshot) iosd).getScreenshotAs(OutputType.BYTES);

		String base64 = "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);

		sc.log("<img src=" + base64 + ">");
	}

	public void CaptureScreenShots_iPhone_Working(IOSDriver iosd, Scenario sc) throws Throwable {
		File screenshot = ((TakesScreenshot) iosd).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		sc.attach(fileContent, "image/png", "screenshot");
	}

	public String Execution_Report_File_Label() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyy_HH:mm:ss");

		return "Execution_Report_" + dateFormat.format(timestamp);
	}

}
