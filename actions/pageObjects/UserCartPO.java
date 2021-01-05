package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCartPageUI;
import pageUIs.UserProductPageUI;

public class UserCartPO extends AbstractPage{
	WebDriver driver;

	public UserCartPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDirectPageToCartPage() {
		return isElementDisplayed(driver, UserCartPageUI.SHOPPING_CART_TITLE_PAGE);
	}

	public String getProductNameInCart() {
		return getElementText(driver, UserCartPageUI.NAME_PRODUC_IN_CART);
	}

	public String getQualityProductsInWishlistIcon() {
		return getElementText(driver, UserCartPageUI.QUALITY_IN_WISHLIST_ICON);
	}

	public UserProductDetailPO clickToEdit() {
		waitForElementClickable(driver, UserCartPageUI.EDIT_LINK);
		clickToElement(driver, UserCartPageUI.EDIT_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void clickToRemoveCheckbox() {
		waitForElementClickable(driver, UserCartPageUI.REMOVE_CHECKBOX);
		clickToElement(driver, UserCartPageUI.REMOVE_CHECKBOX);
	}

	public void clickToUpdateCart() {
		waitForElementClickable(driver, UserCartPageUI.UPDATE_CART_BUTTON);
		clickToElement(driver, UserCartPageUI.UPDATE_CART_BUTTON);
		
	}

	public String getEmptyCatMessage() {
		return getElementText(driver, UserCartPageUI.EMPTY_CART_MESSAGE);
	}

	public boolean isNoItemsInCart() {
		try {
			return isElementDisplayed(driver, UserCartPageUI.NAME_PRODUC_IN_CART);
		} catch (NoSuchElementException e) {
			return true;
		}
		
	}

	public static String getFormatPrice(String value) {
		value = value.substring(1);
		value = value.replace(",","");
		value = value.substring(0,value.lastIndexOf("."));
		return value;
	}

	public void inputToQuality(String value) {
		sendKeyToElement(driver, UserCartPageUI.QUALITY_TEXBOX, value);
		
	}

	public String getTotalPriceInPerItem() {
		return getElementText(driver, UserCartPageUI.TOTLA_PRICE_PER_ITEMS);
	}

	public void selectGiftWrapping(String value) {
		selectItemByVisible(driver, UserCartPageUI.GIFT_WRAPPING_DROPDOWN, value);
		
	}

	public void clickToTerm() {
		waitForElementClickable(driver, UserCartPageUI.TERMS_CHECKBOX);
		clickToElement(driver, UserCartPageUI.TERMS_CHECKBOX);
		
	}

	public UserCheckoutPO clickToCheckOut() {
		waitForElementClickable(driver, UserCartPageUI.CHECK_OUT_BUTTON);
		clickToElement(driver, UserCartPageUI.CHECK_OUT_BUTTON);
		return PageGeneratorManager.getUserCheckouttPage(driver);
	}

	

}
