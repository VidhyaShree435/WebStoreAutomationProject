package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	    private WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void open() {
	        driver.get("https://demowebshop.tricentis.com/");
	    }

	    public void clickLoginLink() {
	        driver.findElement(By.linkText("Log in")).click();
	    }
	    
	    public void clickRegiterLink() {
	    	driver.findElement(By.linkText("Register")).click();
	    }
	    
	    public void clickshoppingCartLink() {
	    	driver.findElement(By.linkText("Shopping cart")).click();
	    }
}
