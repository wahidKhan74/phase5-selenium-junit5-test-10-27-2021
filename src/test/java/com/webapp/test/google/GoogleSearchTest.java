package com.webapp.test.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchTest {
	// step 1 : formulate a test url
	String siteUrl = "https://www.google.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {

		// step 2 : set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step 3 : instantiate selenium webdriver
		driver = new ChromeDriver();

		// step 4 : launch browser
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() {
		// step 6 : close browser
		driver.close();
	}

	@Test
	@DisplayName("Google Test : Search 'selenium documentation'")
	void testGoogleSearch() throws InterruptedException {
		// step 5 : Evaluate a test
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium documentation");
		searchBox.submit();
		String expected = "selenium documentation - Google Search";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
		Thread.sleep(5000);
	}
	
	@Test
	@DisplayName("Google Test : Search 'selenium webdriver'")
	void testGoogleSearch2() throws InterruptedException {
		// step 5 : Evaluate a test
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium webdriver");
		searchBox.submit();
		String expected = "selenium webdriver - Google Search";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
		Thread.sleep(5000);
	}
}
