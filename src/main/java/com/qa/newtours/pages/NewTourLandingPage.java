package com.qa.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newtours.basepage.BasePage;
import com.qa.newtours.utility.ElementUtility;

public class NewTourLandingPage extends BasePage {

	WebDriver driver;
	ElementUtility elementUtility;
	
	By register = By.linkText("REGISTER");
	By username = By.name("userName");
	By password = By.name("password");
	By signIn = By.name("login");
	
	public NewTourLandingPage(WebDriver driver) {
		this.driver = driver ;
		elementUtility = new ElementUtility(driver);
		elementUtility.waitForTitlePresent("Welcome: Mercury Tours", 20);
	}
	
	public void clickRegistration() {
		elementUtility.waitForElementPresent(register, 20);
		elementUtility.doClick(register);
	}
	
	public RegistrationPage goToRegistrationPage() {
		clickRegistration();
		return new RegistrationPage(driver);
	}
}
