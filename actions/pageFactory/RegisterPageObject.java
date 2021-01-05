package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageFactory.AbstractPage;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement dayDropdown;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement monthDropdown;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement yearDropdown;
	
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Company")
	WebElement companyTextbox;
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement registeredSuccessMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	

	public void clickToGenderMaleRadioButton() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);

	}

	public void inputToFirstNameTextbox(String firstName) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastName);

	}

	public void selectDayDropdown(String birthDay) {
		waitForElementClickable(driver, dayDropdown);
		selectItemByVisible(driver,dayDropdown, birthDay);
	}

	public void selectMonthDropdown(String birthMonth) {
		waitForElementClickable(driver, monthDropdown);
		selectItemByVisible(driver,monthDropdown, birthMonth);

	}

	public void selectYearDropdown(String birthYear) {
		waitForElementClickable(driver, yearDropdown);
		selectItemByVisible(driver, yearDropdown, birthYear);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver,emailTextbox, email);

	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver,companyTextbox);
		sendKeyToElement(driver, companyTextbox, company);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver,confirmPasswordTextbox, confirmPassword);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver,  registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registeredSuccessMessage);
		return getElementText(driver, registeredSuccessMessage);
	}

	public void clickToLogoutLink() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver,logoutLink);
		clickToElement(driver,logoutLink);

	}

}
