package org.example.testcases;

import java.time.Duration;

import org.example.pages.HomePage;
import org.example.pages.ProductSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ScreenshotUtils;
import utilities.WaitUtils;

public class ProductSearch_TC {

	WebDriver driver;
    ProductSearchPage searchMethod;
    HomePage homePage;
    ScreenshotUtils screenutils;
    WaitUtils wait;
	
	 @BeforeClass
	    public void setUp() {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C:\\browserDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        homePage = new HomePage(driver);
	        searchMethod = new ProductSearchPage(driver);
	        screenutils = new ScreenshotUtils(driver);
	        wait = new WaitUtils(driver);
	    }
	 
	 @Test
	 public void someMethod() {
		    
		    homePage.open();
		    
		    searchMethod.searchProduct("Science");
	        By yourLocator = By.xpath("//a[normalize-space()='Science']"); // Define your locator
	        Duration timeout = Duration.ofSeconds(50); // Define your timeout duration
	        wait.waitForVisibilityOfElementLocated(yourLocator, timeout);
	        // Now the element is visible, you can proceed with further actions
	        screenutils.captureScreenshot("img2");
	    }
	  
	  @AfterClass
	    public void tearDown() {
	       driver.quit();
	    }
	
}
