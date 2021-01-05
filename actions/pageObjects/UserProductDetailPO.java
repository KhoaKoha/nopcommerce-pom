package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserProductDetailPageUI;

public class UserProductDetailPO extends AbstractPage {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	public UserProductDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewPO clickToAddYourReview() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}


	public void clickToAddToWishlist() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);

	}

	public String getWishlistSuccessMessage() {
		return getElementText(driver, UserProductDetailPageUI.ADD_WISHLIST_SUCCESS_MESSAGE);
	}

	public void clickToCloseWishListNotiButton() {
		waitForElementClickable(driver, UserProductDetailPageUI.CLOSE_SUCCESS_IN_BAR);
		clickToElement(driver, UserProductDetailPageUI.CLOSE_SUCCESS_IN_BAR);
		sleepInSecond(3);
	}

	public UserProductPO backToProductsPage() {
		backToPage(driver);
		return PageGeneratorManager.getUserProductPage(driver);
	}

	public void selectProcessor(String value) {
		selectItemByVisible(driver, UserProductDetailPageUI.PROCESSOR_DROPDOWN, value);
		sleepInSecond(1);
	}

	public void selectRam(String value) {
		selectItemByVisible(driver, UserProductDetailPageUI.RAM_DROPDOWN, value);
		sleepInSecond(1);
	}

	public void clickToHDD(String value) {
		waitForElementClickable(driver, UserProductDetailPageUI.HDD_RADIO_BUTTON_DYNAMIC, value);
		clickToElement(driver, UserProductDetailPageUI.HDD_RADIO_BUTTON_DYNAMIC, value);
		sleepInSecond(1);
	}

	public void clickToOS(String value) {
		waitForElementClickable(driver, UserProductDetailPageUI.OS_RADIO_BUTTON_DYNAMIC, value);
		clickToElement(driver, UserProductDetailPageUI.OS_RADIO_BUTTON_DYNAMIC, value);
		sleepInSecond(2);
	}

	public void clickToSoftware(String... value) {
		selectInListCheckBox(driver, UserProductDetailPageUI.SOFTWARE_CHECKBOX_LIST,UserProductDetailPageUI.SOFTWARE_LABEL_LIST, value);
		sleepInSecond(3);
	}

	public void clickToAddToCart() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);

	}

	public String getAddToCartSuccessMessage() {
		waitForElementVisible(driver, UserProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
		return getElementText(driver, UserProductDetailPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
	}

	public void clickToCloseMessageInBar() {
		waitForElementClickable(driver, UserProductDetailPageUI.CLOSE_SUCCESS_IN_BAR);
		clickToElement(driver, UserProductDetailPageUI.CLOSE_SUCCESS_IN_BAR);
		sleepInSecond(2);
		
	}

	public String getNumberOfProductAtCartPopup() {
		return getElementText(driver, UserProductDetailPageUI.NUMBER_OF_PRODUCT_AT_CART_POPUP);
	}

	public String getNameProductAtCartPopup() {
		return getElementText(driver, UserProductDetailPageUI.NAME_PRODUCTL_AT_CART_POPUP);
	}

	public String getTotalAtCartPopup() {
		return getElementText(driver, UserProductDetailPageUI.TOTAL_AT_CART_POPUP);
	}

	public void inputQualityProducts(String value) {
		sendKeyToElement(driver, UserProductDetailPageUI.QUALITY_TEXTBOX, value);

	}

	public void clickToUpdateCart() {
		waitForElementClickable(driver, UserProductDetailPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.UPDATE_BUTTON);
		sleepInSecond(3);
	}

	public String getPrice() {
		waitForElementVisible(driver, UserProductDetailPageUI.PRICE_PRODUCT);
		return getElementText(driver, UserProductDetailPageUI.PRICE_PRODUCT);
	}


	

	




	

}
