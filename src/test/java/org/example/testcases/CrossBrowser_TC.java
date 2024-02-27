package org.example.testcases;

import java.time.Duration;

import org.example.pages.CheckOutPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenshotUtils;

public class CrossBrowser_TC {

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
	    
		@Parameters("browser")
		@Test
		public void openFirefoxBrowser(@Optional("firefox") String browser)
		{
			homePage.open();
			
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
		}
		
		@AfterClass
		public void teardown()
		{
			driver.close();
		}
		
	}

