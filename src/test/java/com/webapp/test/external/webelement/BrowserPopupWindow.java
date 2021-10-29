package com.webapp.test.external.webelement;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopupWindow {

	String siteUrl = "https://www.amazon.in/";
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
	@DisplayName("Browser popup window test")
	void testBrowserPopup() throws InterruptedException {
		// find and click location popup
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		
		// collect main window
		String mainWindow = driver.getWindowHandle();
		// list of external windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// switch to child window
			driver.switchTo().window(childWindow);
			// find pin location input
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500018");
			Thread.sleep(2000);
			//click on apply
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(5000);
	}
}
