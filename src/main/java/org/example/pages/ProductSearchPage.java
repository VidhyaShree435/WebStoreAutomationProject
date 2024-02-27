package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchPage {

	private WebDriver driver; 
	private WebDriverWait wait;
	
	public ProductSearchPage(WebDriver driver) {
		
	       this.driver = driver;
	       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	   }
	
	public void searchProduct(String productName) {
		
		    WebElement searchInput = driver.findElement(By.id("small-searchterms")); // Assuming the ID of the search input field is "searchInput"
	        searchInput.sendKeys(productName);
	        searchInput.sendKeys(Keys.ENTER);
	}
	
}
