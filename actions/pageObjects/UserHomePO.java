package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserHomePageUI;

public class UserHomePO extends AbstractPage {
	WebDriver driver;
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
		
	}

	public UserCustomerInforPO clickToMyAccountLink() {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	
	public UserProductDetailPO clickBuyBuildYourOwnComputer() {
		waitForElementClickable(driver, UserHomePageUI.BUILD_YOUR_OWN_COMPUTER_PRODUCT);
		clickToElement(driver, UserHomePageUI.BUILD_YOUR_OWN_COMPUTER_PRODUCT);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}
	
	public UserProductDetailPO clickBuyAppleMacbookPro() {
		waitForElementClickable(driver, UserHomePageUI.APPLE_MACBOOK_PRO_PRODUCT);
		clickToElement(driver, UserHomePageUI.APPLE_MACBOOK_PRO_PRODUCT);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void clickToAppleAddCompare(String product1) {
		waitForElementClickable(driver, UserHomePageUI.APPLE_MACBOOK_PRO_PRODUCT_ADD_COMPARE);
		clickToElement(driver, UserHomePageUI.APPLE_MACBOOK_PRO_PRODUCT_ADD_COMPARE);
		
	}
	
	public void clickToHTCAddCompare(String product1) {
		waitForElementClickable(driver, UserHomePageUI.HTC_ONE_M8_PRODUCT_ADD_COMPARE);
		clickToElement(driver, UserHomePageUI.HTC_ONE_M8_PRODUCT_ADD_COMPARE);
		
	}

	public String getCompareSuccessMessage() {
		return getElementText(driver, UserHomePageUI.ADD_COMPARE_SUCCESS_MESSAGE);
	}

	public void closeMessageAddCompareSuccess() {
		waitForElementClickable(driver, UserHomePageUI.CLOSE_ADD_COMPARE_SUCCESS_BUTTON);
		clickToElement(driver, UserHomePageUI.CLOSE_ADD_COMPARE_SUCCESS_BUTTON);
		sleepInSecond(2);
	}

	public UserComparePO clickToCompareProductListLink() {
		waitForElementClickable(driver, UserHomePageUI.COMPARE_PRODUCTS_LIST_LINK);
		clickToElement(driver, UserHomePageUI.COMPARE_PRODUCTS_LIST_LINK);
		return PageGeneratorManager.getUserComparePage(driver);
	}

	
}
