package com.webapp.test.faceebook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class FacbookLoginTest {
	
	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() {
		 driver.close();
	}
	
	@Test
	@DisplayName("Facebook Test : Validate inputs exist !")
	void testFacebookHomePage() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		assertEquals(true, emailInput.isDisplayed());
		assertEquals(true, passwordInput.isDisplayed());
		assertEquals(true, submitButton.isDisplayed());
		
		
		assertEquals(true, emailInput.isEnabled());
		assertEquals(true, passwordInput.isEnabled());
		assertEquals(true, submitButton.isEnabled());
		
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Facebook Test : Login Test !")
	void testFacebookloginTest() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		emailInput.sendKeys("abc@gmail.com");
		passwordInput.sendKeys("abc@123");
		submitButton.submit();
		
		Thread.sleep(50000);
	}
	
	
	
	@Test
	@DisplayName("Facebook Test : Login Test With CSS & Xpath !")
	void testFacebookloginTest2() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.cssSelector("#email"));
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		emailInput.sendKeys("abc@gmail.com");
		passwordInput.sendKeys("abc@123");
		submitButton.submit();
		
		Thread.sleep(50000);
	}
	
	
	
	
	
}
