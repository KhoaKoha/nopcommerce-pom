package pageObjects;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.UserComparePageUI;

public class UserComparePO extends AbstractPage{
	WebDriver driver;

	public UserComparePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDirectToComparePage() {
		return isElementDisplayed(driver, UserComparePageUI.TITLE_PAGE);
	}

	public boolean isClearListButtonDisplay() {
		return isElementDisplayed(driver, UserComparePageUI.CLEAR_LIST_BUTTON);
	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, UserComparePageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserComparePageUI.CLEAR_LIST_BUTTON);
	}

	public String getTextNoItemsComparePage() {
		return getElementText(driver, UserComparePageUI.NO_DATA_MESSAGE);
	}

	public boolean isNoProductInComparePage() {
		try {
			if (isListItemsDislays(driver, UserComparePageUI.PRODUCTS_NAME_OF_PER_PRODUCTS)) {
				return false;
			}
			else {
				return true;
			}
			
		} catch (NoSuchElementException e) {
			return true;
		}
		
	}

	public boolean isListItemsDislays(WebDriver driver, String parentLocator) {
		boolean check = false;
		List<WebElement> listItems = getElements(driver, parentLocator);
		for(WebElement e : listItems) {
			if (e.isDisplayed()) {
				check = true;
			}
		}
		return check;
	}
	
	public boolean isRemoveButtonDisplay() {
		return isListItemsDislays(driver, UserComparePageUI.REMOVE_LINK_OF_PER_PRODUCTS);
	}

	public boolean isComparePageContainsNameProducts() {
		return isListItemsDislays(driver, UserComparePageUI.PRODUCTS_NAME_OF_PER_PRODUCTS);
	}

	public boolean isComparePageContainsPriceProducts() {
		return isListItemsDislays(driver, UserComparePageUI.PRODUCTS_PRICE_OF_PER_PRODUCTS);
	}

	

}
