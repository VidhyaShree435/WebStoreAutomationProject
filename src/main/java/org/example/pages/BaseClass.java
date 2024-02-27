package org.example.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
   
	 protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected Properties properties;

	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:\\browserDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
