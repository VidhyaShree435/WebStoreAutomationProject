package org.example.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void viewProductCategories(String linkText) {
    	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        for (WebElement link : allLinks) {
            String text = link.getText();
            
            if (text.equals(linkText)) {
                link.click();
                break; // Assuming you only want to click the first link with the given text
            }
        }
    }
    
   // Method to check if product name is displayed
    public boolean isProductNameDisplayed() {
        WebElement productNameElement = driver.findElement(By.cssSelector("css_selector_for_product_name"));
        return productNameElement.isDisplayed();
    }

    // Method to check if product price is displayed
    public boolean isProductPriceDisplayed() {
        WebElement productPriceElement = driver.findElement(By.cssSelector("css_selector_for_product_price"));
        return productPriceElement.isDisplayed();
    }

    // Method to check if product description is displayed
    public boolean isProductDescriptionDisplayed() {
        WebElement productDescriptionElement = driver.findElement(By.cssSelector("css_selector_for_product_description"));
        return productDescriptionElement.isDisplayed();
    }

}
