package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCartPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserWishlistInHeaderPageUI;

public class UserWishListInHeaderPO extends AbstractPage {
	WebDriver driver;

	public UserWishListInHeaderPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextProductNameInWishlistPage() {
		return getElementText(driver, UserWishlistInHeaderPageUI.NAME_PRODUCT_IN_WISHLIST_PAGE);
	}

	public void clickToLinkWishlistSharing() {
		waitForElementClickable(driver, UserWishlistInHeaderPageUI.WISHLIST_SHARING_LINK);
		clickToElement(driver, UserWishlistInHeaderPageUI.WISHLIST_SHARING_LINK);

	}

	public void clickToCheckboxAddToCart() {
		waitForElementClickable(driver, UserWishlistInHeaderPageUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, UserWishlistInHeaderPageUI.ADD_TO_CART_CHECKBOX);

	}

	public UserCartPO clickToAddToCartButton() {
		waitForElementClickable(driver, UserWishlistInHeaderPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserWishlistInHeaderPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getUserCartPage(driver);
	}

	public void clickToRemove() {
		waitForElementClickable(driver, UserWishlistInHeaderPageUI.REMOVE_CHECKBOX);
		clickToElement(driver, UserWishlistInHeaderPageUI.REMOVE_CHECKBOX);

	}

	public void clickToUpdateWishlist() {
		waitForElementClickable(driver, UserWishlistInHeaderPageUI.UPDATE_WISHLIST_BUTTON);
		clickToElement(driver, UserWishlistInHeaderPageUI.UPDATE_WISHLIST_BUTTON);

	}

	public String getTextWishlistEmptyMessage() {
		return getElementText(driver, UserWishlistInHeaderPageUI.WISHLIST_EMPTY_MESSAGE);
	}

	public String getQualityProductsInWishlistIcon() {
		return getElementText(driver, UserCartPageUI.QUALITY_IN_WISHLIST_ICON);
	}

}
