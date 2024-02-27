package org.example.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
    private Properties properties;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.properties = new Properties();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Load properties from the config.properties file
            FileInputStream configFile = new FileInputStream("config.properties");
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        // Retrieve email and password from properties
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        
   //     WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("Email")));
        
        // Implement login functionality
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        
   }
}