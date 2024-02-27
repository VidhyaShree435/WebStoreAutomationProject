package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodPage {
     
	private WebDriver driver; 
	private WebDriverWait wait;
	
	public PaymentMethodPage(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   }
	
	public void selectPaymentMethod(String paymentMethodName) {
        String xpath = "//label[normalize-space()='" + paymentMethodName + "']";
        WebElement paymentMethod = driver.findElement(By.xpath(xpath));
        paymentMethod.click();
    }
	
	public void continueButton() {
		driver.findElement(By.id("//input[@class='button-1 payment-method-next-step-button']")).click();
	}
	
	public void confirmOrder() {
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
	}
}
