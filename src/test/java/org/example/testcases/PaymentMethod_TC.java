package org.example.testcases;


import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.PaymentMethodPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentMethod_TC {
    
	WebDriver driver;
    PaymentMethodPage paymentMethod;
    HomePage homePage;
    LoginPage loginPage;
	
	 @BeforeClass
	    public void setUp() {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C:\\browserDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
	        paymentMethod = new PaymentMethodPage(driver);
	    }
	 
	 @Test
	  public void paymentMethod() {
		  
		  homePage.open();
		  paymentMethod.selectPaymentMethod("Cash On Delivery (COD) (7.00)");
		  paymentMethod.continueButton();
		  paymentMethod.confirmOrder();
	  }
	  
	  @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}
