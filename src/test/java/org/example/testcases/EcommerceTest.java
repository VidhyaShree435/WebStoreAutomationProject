package org.example.testcases;


import java.time.Duration;
import org.testng.Assert;
import org.example.pages.AddToCartPage;
import org.example.pages.CheckOutPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ScreenshotUtils;


public class EcommerceTest {
     
	WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    private AddToCartPage cartPage;
    CheckOutPage checkout;
    ScreenshotUtils screenshot;

    @BeforeClass
    public void setUp() {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new AddToCartPage(driver);
        checkout = new CheckOutPage(driver);
        screenshot = new ScreenshotUtils(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        }

    @Test(priority = 1)
    public void testLaunchApplication() {
        homePage.open();
        // Add assertions for application launch
        Assert.assertEquals(driver.getTitle(), "Demo Web Shop");   
        
        // Verify that the page title is not empty
        Assert.assertFalse(driver.getTitle().isEmpty(), "Page title is empty");
        
        // Verify that the page URL is as expected
        String expectedUrl = "https://demowebshop.tricentis.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL mismatch");
        screenshot.captureScreenshot("Image6");
    }

    @Test(priority = 3)
    public void testViewProducts() {
        homePage.open();
        // Navigate to product page
        productPage.viewProductCategories("Computers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        productPage.viewProductCategories("Desktops");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        productPage.viewProductCategories("Build your own computer");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        screenshot.captureScreenshot("image5");
    }
    
    @Test(priority = 4)
    public void addToCart() {
    	
   // 	homePage.open();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
    	cartPage.hddRadioButton("320");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	cartPage.enterQuantity("3");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	cartPage.cartButton();
    	screenshot.captureScreenshot("image4");
    	
    }
    
    @Test(priority = 5)
    public void checkOut() {
		  
		  homePage.clickshoppingCartLink();
		  checkout.selectCheckBox();
     	  By dropdownLocator = By.xpath("//select[@id='CountryId']");
	      String optionVisibleText = "India";
	      checkout.selectDropdownByVisibleText(driver, dropdownLocator, optionVisibleText);
		  checkout.zipCodeAddress("560076");
		  checkout.checkBoxTerms();
		  checkout.checkOutButton();
		  screenshot.captureScreenshot("image4");
	  }

    @Test(priority = 6)
    public void testCustomerRegistration() {
        homePage.open();
        // Click on registration link
        homePage.clickRegiterLink();
        // Register as a new customer
        
        // Add assertions for successful registration
    }

    @Test(priority = 2)
    public void testCustomerLogin() {
        homePage.open();       //open url
        // Click on login link
        homePage.clickLoginLink();
        // Login with valid credentials
        // loginPage.login("test@example.com", "password");
        
        loginPage.login();
        // Add assertions for successful login
    }

    // Other test methods

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
}
