package com.webapp.test.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBoxTest {
	
	String siteUrl = "file:///home/wahidkhan74gmai/Comviva-Workspace/phase5-selenium-junit5-test-10-27-2021/static/web-elements.html";
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
	@DisplayName("Check box One exist test")
	public void testToVerifycheckBoxExist() {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Check box Two exist test")
	public void testToVerifycheckBox2Exist() {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		// default select
		assertEquals(true, checkBox.isSelected());
	}
	
	
	@Test
	@DisplayName("Seleted Check box One exist test")
	public void testToSelectcheckBox1() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
		//select checkbox :: click on checkbox
		checkBox.click();
		assertEquals(true, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("De Seleted Check box Two exist test")
	public void testToSelectcheckBox2() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(true, checkBox.isSelected());
		//deselect radio :: click on radio
		checkBox.click();
		assertEquals(false, checkBox.isSelected());
		Thread.sleep(3000);
	}
}
