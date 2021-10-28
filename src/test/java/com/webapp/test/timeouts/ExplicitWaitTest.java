package com.webapp.test.timeouts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {

	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception"
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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
	}
	
	
	@Test
	@DisplayName("Facebook Test : Login Test !")
	void testFacebookloginTest() throws InterruptedException {
		//normal way to find web elements
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		emailInput.sendKeys("abc1@gmail.com");
		passwordInput.sendKeys("abc2@123");
		submitButton.submit();
		
		//conditional way with timeout
		WebElement errorMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", errorMessage1.getText());
		
		WebElement errorMessage2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div:nth-child(2)")));
		assertEquals("Invalid username or password", errorMessage2.getText());
	}

}
