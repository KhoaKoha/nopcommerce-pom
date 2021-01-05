package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressPageUI;

public class UserAddressesPO extends AbstractPage {
	WebDriver driver;

	public UserAddressesPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		clickToElement(driver, UserAddressPageUI.ADD_NEW_BUTTON);
		
	}

	public void inputToFirstName(String addressFirstName) {
		sendKeyToElement(driver, UserAddressPageUI.FIRST_NAME_TEXTBOX, addressFirstName);
	}

	public void inputToLastName(String addressLastName) {
		sendKeyToElement(driver, UserAddressPageUI.LAST_NAME_TEXTBOX, addressLastName);
		
	}

	public void inputToEmail(String addressEmail) {
		sendKeyToElement(driver, UserAddressPageUI.EMAIL_TEXTBOX, addressEmail);
		
	}

	public void inputToCompany(String addressCompany) {
		sendKeyToElement(driver, UserAddressPageUI.COMPANY_TEXTBOX, addressCompany);
		
	}

	public void selectCountryDropdown(String addressCountry) {
		selectItemByVisible(driver, UserAddressPageUI.COUNTRY_DROPDOWN, addressCountry);
		
	}

	public void selectStateDropdown(String addressState) {
		selectItemByVisible(driver, UserAddressPageUI.STATE_DROPDOWN, addressState);
		
	}

	public void inputToCity(String addressCity) {
		sendKeyToElement(driver, UserAddressPageUI.CITY_TEXTBOX, addressCity);
		
	}

	public void inputToAddress1(String address1) {
		sendKeyToElement(driver, UserAddressPageUI.ADDRESS1_TEXTBOX, address1);
		
	}

	public void inputToAddress2(String address2) {
		sendKeyToElement(driver, UserAddressPageUI.ADDRESS2_TEXTBOX, address2);
		
	}

	public void inputToZip(String addressZip) {
		sendKeyToElement(driver, UserAddressPageUI.ZIP_TEXTBOX, addressZip);
		
	}

	public void inputToPhoneNumber(String addressPhoneNumber) {
		sendKeyToElement(driver, UserAddressPageUI.NUMBER_PHONE_TEXTBOX, addressPhoneNumber);
		
	}

	public void inputFaxNumber(String addressFaxNumber) {
		sendKeyToElement(driver, UserAddressPageUI.FAX_TEXTBOX, addressFaxNumber);
		
	}

	public void clickToSaveNewButton() {
		clickToElement(driver, UserAddressPageUI.SAVE_NEW_BUTTON);
		
	}

	public String getTitleAddress() {
		return getElementText(driver, UserAddressPageUI.TITLE_ADDRESS_LABEL);
	}
	
	
}
