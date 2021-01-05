package com.nopcommerce.users;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.GlobalConstants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_Login extends AbstractPage {
	WebDriver driver;
	String sourceFolder = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, birthDay, birthMonth, birthYear, email, company, password, confirmPassword;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", sourceFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(GlobalConstants.DEV_SERVER);

		firstName = "Auto Test";
		lastName = "Hybrid Pom";
		email = "hybridpom" + java.time.LocalTime.now().toString().replace(".", ":").replace(":", "") + "@outlook.com";
		company = "FPT University";
		password = "123456";
		confirmPassword = "123456";
		birthDay = "18";
		birthMonth = "April";
		birthYear = "1999";

	}

	@Test(priority = 1)
	public void Register() {
		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-female']");
		sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendKeyToElement(driver, "//input[@id='LastName']", lastName);

		selectItemByVisible(driver, "//select[@name='DateOfBirthDay']", birthDay);
		selectItemByVisible(driver, "//select[@name='DateOfBirthMonth']", birthMonth);
		selectItemByVisible(driver, "//select[@name='DateOfBirthYear']", birthYear);

		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Company']", company);
		sendKeyToElement(driver, "//input[@id='Password']", password);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);

		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test(priority = 2)
	public void Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", password);

		clickToElement(driver, "//input[@class='button-1 login-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
	}

	@Test(priority = 3)
	public void View_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");
		isElementSelected(driver, "//input[@id='gender-female']");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), company);

		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), birthDay);
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), birthMonth);
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), birthYear);
	}

	@AfterClass
	public void afterClass() {
	}

}
