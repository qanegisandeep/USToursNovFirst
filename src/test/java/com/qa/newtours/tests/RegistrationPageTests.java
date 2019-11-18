package com.qa.newtours.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.newtours.basepage.BasePage;
import com.qa.newtours.pages.RegistrationPage;


public class RegistrationPageTests {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	RegistrationPage registrationPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();	
		registrationPage = new RegistrationPage(driver);
	}
	
	@Test
	public void verifyUserRegistration() {
		Assert.assertEquals(registrationPage.userRegistration(), "http://newtours.demoaut.com/create_account_success.php", "Registration failed");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
}
