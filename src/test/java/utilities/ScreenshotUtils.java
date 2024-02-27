package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshots/" + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
