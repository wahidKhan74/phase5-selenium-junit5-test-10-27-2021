package com.webapp.test.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectDropdownTest {
	
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
	@DisplayName("Select dropdown exist test")
	public void testToVerifycheckBoxExist() {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
		assertEquals(false, dropdown.isSelected());
	}
	
	@Test
	@DisplayName("Test first selected option from dropdown")
	public void testToVerifyFirstSelectFromDropDown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		//map web element to select
		Select select = new Select(dropdown);
		// select bike as selected option
		select.selectByVisibleText("Bike");
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Bike ", selectedValue.getText());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Test 3rd index selected option from dropdown")
	public void testToVerify3rdIndexSelectFromDropDown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		//map web element to select
		Select select = new Select(dropdown);
		// select 3rd index as selected option
		select.selectByIndex(3);
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Airplane ", selectedValue.getText());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Test selected option by value from dropdown")
	public void testToVerifySelectByValueFromDropDown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		//map web element to select
		Select select = new Select(dropdown);
		// select by value 'car' as selected option
		select.selectByValue("car");;
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Car ", selectedValue.getText());
		Thread.sleep(3000);
	}
}
