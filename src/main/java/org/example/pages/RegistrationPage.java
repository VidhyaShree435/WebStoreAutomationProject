package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	    private WebDriver driver;

	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectGender(String gender) {
	        
	        String genderLocator = "//input[@id='gender-" + gender + "']";
	        WebElement radioEle = driver.findElement(By.xpath(genderLocator));
	        boolean isSelected = radioEle.isSelected();
	        
	        if (isSelected == false) {
				radioEle.click();
			}
         }
	     
	    public void nameFields(String name) {
	    	
	    	driver.findElement(By.id("FirstName")).sendKeys(name);
	    	driver.findElement(By.id("LastName")).sendKeys(name);
	    	driver.findElement(By.id("Email")).sendKeys(name);
	     }
	    
	    public void passwordFields(String pwd) {
	    	
	    	driver.findElement(By.id("Password")).sendKeys(pwd);
	        driver.findElement(By.id("ConfirmPassword")).sendKeys(pwd);
	    }
        
	    public void registerButton(String button) {
	    	
	    	driver.findElement(By.id(button)).click();
	    }
	    
}	    
