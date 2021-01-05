package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserRegisterPageUI;

public class UserCustomerInforPO extends AbstractPage{
	WebDriver driver;
	public UserCustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
	}
	
	public boolean isGenderFemaleRadioButtonSelected() {
		waitForElementVisible(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getFLastNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}
	public void clickToGenderMaleRadioButton() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);

	}
	
	public void clickToGenderFemaleRadioButton() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstName) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void selectDayDropdown(String birthDay) {
		waitForElementClickable(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		selectItemByVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN, birthDay);
	}

	public void selectMonthDropdown(String birthMonth) {
		waitForElementClickable(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		selectItemByVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN, birthMonth);

	}

	public void selectYearDropdown(String birthYear) {
		waitForElementClickable(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		selectItemByVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN, birthYear);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, company);

	}

	public void clickToSaveButton() {
		clickToElement(driver, UserCustomerInforPageUI.SAVE_BUTTON);
	}


}
