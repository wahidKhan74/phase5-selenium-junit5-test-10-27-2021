package com.webapp.test.external.webelement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	
	String siteUrl = "file:///home/wahidkhan74gmai/Comviva-Workspace/phase5-selenium-junit5-test-10-27-2021/static/alert-webelement.html";
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
	@DisplayName("Alert Test :  Simple  alert window ")
	void testAlertDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please confirm the email address ?", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirmation Test :  With OK click")
	void testConfirmDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		
		// switch to confirm window
		Alert confirm = driver.switchTo().alert();
		assertEquals("Do you really want to contineue ?", confirm.getText());
		Thread.sleep(3000);
		confirm.accept();
	}
	
	
	@Test
	@DisplayName("Confirmation Test :  With Cancel click")
	void testConfirmDailogWindow2() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		
		// switch to confirm window
		Alert confirm = driver.switchTo().alert();
		assertEquals("Do you really want to contineue ?", confirm.getText());
		Thread.sleep(3000);
		confirm.dismiss();
	}
	
	@Test
	@DisplayName("Prompt Test :  With Ok click")
	void testPromptDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(6) > button")).click();
		
		// switch to confirm window
		Alert prompt = driver.switchTo().alert();
		assertEquals("Please enter your name", prompt.getText());
		Thread.sleep(3000);
		prompt.accept();
	}
}
