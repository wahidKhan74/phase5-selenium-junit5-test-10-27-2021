package com.webapp.test.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleHomePageTest {

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
	@DisplayName("Google Test : Home page title")
	void testHompageTitle() {
		// step 5 : Evaluate a test
		String expected = "Google";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Google Test : Home page source")
	void testHompageSource() {
		// step 5 : Evaluate a test
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
}
