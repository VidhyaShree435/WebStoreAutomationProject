package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public class CheckOutPage {
    
	private WebDriver driver; 
	private WebDriverWait wait;
	
	public CheckOutPage(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   }
	
	public void selectCheckBox() {
		
        WebElement checkbox = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]"));
        
        checkbox.click();
        
        boolean select = checkbox.isSelected();
        System.out.println("Select value :"+ select);
        
		// performing click operation if element is not selected 
        if(select==false) {
        	checkbox.click();
            System.out.println("Checkbox clicked");
	     }
        else {
        	System.out.println("Checkbox clicked -- 29");
        }
	}
	
	public static void selectDropdownByVisibleText(WebDriver driver, By locator, String visibleText) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
	
	public void cityField(String city) {
		driver.findElement(By.xpath("BillingNewAddress_City")).sendKeys(city);
	}
	
	/*
	 * public void addressField(String address) {
	 * driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address); }
	 */
	
	public void zipCodeAddress(String zip) {
		driver.findElement(By.id("ZipPostalCode")).sendKeys(zip);
	}
	
	/*
	 * public void phoneAddress(String phone) {
	 * driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone); }
	 */
	
     public void checkBoxTerms() {
		
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        
        checkbox.click();
        
        boolean select = checkbox.isSelected();
        System.out.println("Select value :"+ select);
        
		// performing click operation if element is not selected 
        if(select==true) {
        	checkbox.click();
            System.out.println("Checkbox clicked");
	     }
        else {
        	System.out.println("Checkbox clicked -- 29");
        }
	}
	
	public void continueButton() {
		
		driver.findElement(By.id("//input[@onclick='Billing.save()']")).click();
	}
	
	public void checkOutButton() {
		
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
	}
}
