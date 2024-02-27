package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
  
	private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfElementLocated(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
}
