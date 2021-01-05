package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;

	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstName) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void selectDayDropdown(String birthDay) {
		waitForElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemByVisible(driver, UserRegisterPageUI.DAY_DROPDOWN, birthDay);
	}

	public void selectMonthDropdown(String birthMonth) {
		waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemByVisible(driver, UserRegisterPageUI.MONTH_DROPDOWN, birthMonth);

	}

	public void selectYearDropdown(String birthYear) {
		waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemByVisible(driver, UserRegisterPageUI.YEAR_DROPDOWN, birthYear);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}

	public UserHomePO clickToLogoutLink() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserRegisterPO clickToRegisterLink(WebDriver driver) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_LINK);
		clickToElement(driver, UserRegisterPageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

}
