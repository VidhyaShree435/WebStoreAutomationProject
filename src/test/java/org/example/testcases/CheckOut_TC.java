package org.example.testcases;

import java.time.Duration;

import org.example.pages.CheckOutPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ScreenshotUtils;

public class CheckOut_TC {
    
	WebDriver driver;
    CheckOutPage checkout;
    ScreenshotUtils screenshot;
    HomePage homePage;
    LoginPage loginPage;
	
	 @BeforeClass
	    public void setUp() {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C:\\browserDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        checkout = new CheckOutPage(driver);
	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
	        screenshot = new ScreenshotUtils(driver);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    }
	 
	 @Test
	  public void checkOut() {
		  
		  homePage.open();
		  homePage.clickLoginLink();
		  loginPage.login();
		  homePage.clickshoppingCartLink();
		  homePage.clickshoppingCartLink();
		  checkout.selectCheckBox();
	//	  checkout.selectDropdownByVisibleText("//select[@id='CountryId']", "India");
		  checkout.zipCodeAddress("560076");
		  checkout.checkBoxTerms();
		  screenshot.captureScreenshot("image4");
	  }
	  
	  @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
