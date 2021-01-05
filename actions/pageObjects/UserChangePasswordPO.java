package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserChangePasswordPageUI;

public class UserChangePasswordPO extends AbstractPage{
	WebDriver driver;

	public UserChangePasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPassword(String password) {
		sendKeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
		
	}

	public void inputToNewPassword(String newPasswordChange) {
		sendKeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPasswordChange);
		
	}

	public void inputToConfirmPassword(String newPasswordChange) {
		sendKeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPasswordChange);
		
	}

	public void clickToSaveChange() {
		clickToElement(driver, UserChangePasswordPageUI.SAVE_CHANGE_BUTTTON);
	}

	public String getResultMessage() {
		return getElementText(driver, UserChangePasswordPageUI.RESULT_MESSAGE);
	}


	
	
	

}
