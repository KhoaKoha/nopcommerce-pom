package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserLoginPageUI;

public class UserLoginPO extends AbstractPage  {
	WebDriver driver;
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public UserHomePO clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getEmptyInvalidDataLoginMessage() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_INVALID_EMPTY_MESSAGE);
		return getElementText(driver, UserLoginPageUI.ERROR_INVALID_EMPTY_MESSAGE);
	}

	public String getAccountLoginMessage() {
		waitForElementVisible(driver, UserLoginPageUI.ACCOUNT_MESSAGE);
		return getElementText(driver, UserLoginPageUI.ACCOUNT_MESSAGE);
	}


}
