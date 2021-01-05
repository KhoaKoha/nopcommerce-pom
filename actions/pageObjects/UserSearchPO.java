package pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserSearchPageUI;

public class UserSearchPO extends AbstractPage {
	WebDriver driver;

	public UserSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToClickSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);

	}

	public String getTextEmptyDataMessage() {
		return getElementText(driver, UserSearchPageUI.DATA_EMPTY_ERROR_MESSAGE);
	}

	public String getTextDataNoExistMessage() {
		return getElementText(driver, UserSearchPageUI.DATA_NO_EXIST_ERROR_MESSAGE);
	}

	public void inputToSearchTextBox(String data) {
		sendKeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, data);
	}

	
	public boolean isProductContainsKeyword(String keyword) {
		return isResultContainsKeyword(driver, keyword, UserSearchPageUI.RESULT_SEARCH_PRODUCTS);
	}

	public void checkAdvancedSearch() {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEACH_CHECKBOX);
		clickToElement(driver, UserSearchPageUI.ADVANCED_SEACH_CHECKBOX);
		
	}

	public void clickToCategoryDropdown() {
		waitForElementClickable(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		clickToElement(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		
	}

	public void clickToComputerInSubCategories() {
		waitForElementClickable(driver, UserSearchPageUI.SUB_CATEGORY_COMPUTER_DROPDOWN);
		clickToElement(driver, UserSearchPageUI.SUB_CATEGORY_COMPUTER_DROPDOWN);
		
	}

	public void clickToAutomaticallySearch() {
		waitForElementClickable(driver, UserSearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		clickToElement(driver, UserSearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
	}

	public void clickToManufacturer() {
		waitForElementClickable(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		clickToElement(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
	}

	public void clickToAppleInManufacturer() {
		waitForElementClickable(driver, UserSearchPageUI.SUB_MANUFACTURER_APPLE_DROPDOWN);
		clickToElement(driver, UserSearchPageUI.SUB_MANUFACTURER_APPLE_DROPDOWN);
	}

	public void clickToHPInManufacturer() {
		waitForElementClickable(driver, UserSearchPageUI.SUB_MANUFACTURER_HP_DROPDOWN);
		clickToElement(driver, UserSearchPageUI.SUB_MANUFACTURER_HP_DROPDOWN);
	}

	public void inputToPriceFrom(String value) {
		sendKeyToElement(driver, UserSearchPageUI.PRICE_FROM_TEXTBOX, value);
	}

	public void inputToPriceTo(String value) {
		sendKeyToElement(driver, UserSearchPageUI.PRICE_TO_TEXTBOX, value);
	}

	public boolean isProductInPrice(String priceFrom, String priceTo) {
		boolean check = false;
		List<String> listItems = getElementsText(driver, UserSearchPageUI.RESULT_PRICE_PRODUCTS);
		for (String a : listItems) {
			System.out.println("++======> " + getFormatPrice(a));
			if (Integer.parseInt(getFormatPrice(a)) >= Integer.parseInt(priceFrom) && Integer.parseInt(getFormatPrice(a)) <= Integer.parseInt(priceTo) ) {
				check = true;
				System.out.println(check);
				System.out.println("helloooooooooooooooooooooooooooo");
			}
		}
		if (check) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public String getFormatPrice(String value) {
		value = value.substring(1);
		value = value.replace(",","");
		value = value.substring(0,value.lastIndexOf("."));
		return value;
	}
	
//	public boolean isResultContainsKeyword(String keyword) {
//		int check = 0;
//		List<String> listProducts = getElementsText(driver, SearchPageUI.RESULT_SEARCH_PRODUCTS);
//		for (String p : listProducts) {
//			if (p.contains(keyword)) {
//				check++;
//			}
//		}
//		if (listProducts.size() == check) {
//			return true;
//		} else {
//			return false;
//		}
//	}


}
