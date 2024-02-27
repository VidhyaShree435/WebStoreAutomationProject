package org.example.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.example.pages.AddToCartPage;
import org.example.pages.CheckOutPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SanityTest {

    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private AddToCartPage cartPage;
    private CheckOutPage checkoutPage;
    private Properties properties;

    @BeforeClass
    public void setUp() {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new AddToCartPage(driver);
        checkoutPage = new CheckOutPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        properties = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("config.properties");
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void verifyLaunchOfUserInterfaceWithValidUrl() {
        
        // Add more assertions to verify the presence of essential elements on the home page
        homePage.open();
       
        // Add assertions for application launch
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
        System.out.println("Page title is: " + actualTitle);

        // Verify that the page title is not empty
        Assert.assertFalse(actualTitle.isEmpty(), "Page title is empty");
        System.out.println("Page title is not empty");

        // Verify that the page URL is as expected
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demowebshop.tricentis.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch");
        System.out.println("Page URL is: " + actualUrl);
    }

    @Test(priority = 2)
    public void verifyRequiredElementAvailabilityInHomePage() {
        // Add code to navigate to home page and verify required elements
    	
    	homePage.open();

        // Verify the presence of required elements on the home page
        WebElement element1 = driver.findElement(By.xpath("//p[normalize-space()='Welcome to the new Tricentis store!']"));
        Assert.assertTrue(element1.isDisplayed(), "Element 1 is not displayed on the home page");
        String element1Text = element1.getText();
        String expectedElement1Text = "Welcome to the new Tricentis store!";
        Assert.assertEquals(element1Text, expectedElement1Text, "Element 1 text does not match expected");
        System.out.println("required element matched with expected :" + element1Text);

        WebElement element2 = driver.findElement(By.xpath("//div[@class='topic-html-content-title']"));
        Assert.assertTrue(element2.isDisplayed(), "Element 2 is not displayed on the home page");
        String element2Text = element2.getText();
        String expectedElement2Text = "Welcome to our store"; // Provide your expected text here
        Assert.assertEquals(element2Text, expectedElement2Text, "Element 2 text does not match expected");
        System.out.println("required element matched with expected : " + element2Text);
    }

    @Test(priority = 3)
    public void verifyCustomerRegistration() {
        // Add code to navigate to registration page and perform registration
    	
    }

    @Test(priority = 4)
    public void verifyCustomerLogin() {
            // Add code to navigate to login page and perform login
    	    homePage.open();
            // Click on login link
            homePage.clickLoginLink();
            // Login with valid credentials
        
            loginPage.login();
    	
            String email = properties.getProperty("email");
            String password = properties.getProperty("password");
            
            // Implement login functionality
            driver.findElement(By.id("Email")).sendKeys(email);
            driver.findElement(By.id("Password")).sendKeys(password);
            driver.findElement(By.cssSelector("input[value='Log in']")).click();
            
            // Retrieve actual password from the login page
            WebElement actualPasswordElement = driver.findElement(By.id("Password"));
            String actualPassword = actualPasswordElement.getAttribute("value");

            // Compare actual password with expected password
            String expectedPassword = "Welcome@123";
            if (actualPassword.equals(expectedPassword)) {
                System.out.println("User able to login");
            } else {
                System.out.println("Check your password");
            }
   }

    @Test(priority = 5)
    public void shoppingCartAndCheckout() {
        // Add code to add products to the shopping cart, proceed to checkout, and complete the checkout process
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
