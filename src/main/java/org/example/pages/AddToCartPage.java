package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends BaseClass {
     
	 private WebDriver driver; 
	 private WebDriverWait wait;
	
	public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
	
	 public void hddRadioButton(String hdd) {
	        
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		    String hddLocator = "//label[contains(text(),'" + hdd + " GB')]";
	        WebElement radioEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hddLocator)));
	        boolean isSelected = radioEle.isSelected();
	        
	        if (isSelected == false) {
				radioEle.click();
			}
      }
	 
	 public void cartButton() {
		 WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button-16']")));
	     cartButton.click();
	 }
	 
	 public void enterQuantity(String quantity) {
		    // Assuming 'driver' is your WebDriver instance
		    WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='addtocart_16_EnteredQuantity']")));
	        quantityInput.clear();
	        quantityInput.sendKeys(quantity);
		}
}
