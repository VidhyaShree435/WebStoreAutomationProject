package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {
	public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToTop(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
