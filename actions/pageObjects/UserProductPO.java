package pageObjects;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserHomePageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserProductPageUI;

public class UserProductPO extends AbstractPage{
	WebDriver driver;

	public UserProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductDetailPO clickToAppleProduct() {
		waitForElementClickable(driver, UserProductPageUI.APPLE_MACBOOK_LINK);
		clickToElement(driver, UserProductPageUI.APPLE_MACBOOK_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public UserProductDetailPO clickToAsusProduct() {
		waitForElementClickable(driver, UserProductPageUI.ASUS_LINK);
		clickToElement(driver, UserProductPageUI.ASUS_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public UserProductDetailPO clickToHPProduct() {
		waitForElementClickable(driver, UserProductPageUI.HP_LINK);
		clickToElement(driver, UserProductPageUI.HP_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);	}

	public UserProductDetailPO clickToLenovoProduct() {
		waitForElementClickable(driver, UserProductPageUI.LENOVO_LINK);
		clickToElement(driver, UserProductPageUI.LENOVO_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);	}

	public UserProductDetailPO clickToSamsungProduct() {
		waitForElementClickable(driver, UserProductPageUI.SAMSUNG_LINK);
		clickToElement(driver, UserProductPageUI.SAMSUNG_LINK);
		return PageGeneratorManager.getUserProductDetailPage(driver);	}

	


	public void clickToSortByNameAZ() {
		waitForElementClickable(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.NAME_A_TO_Z);
		waitAllElementsPresence(driver, UserProductPageUI.NAME_A_TO_Z);
	}

	public void clickToSortByNameZA() {
		waitForElementClickable(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.NAME_Z_TO_A);
		waitAllElementsPresence(driver, UserProductPageUI.NAME_Z_TO_A);
	}

	public void clickToSortByPriceLowToHigh() {
		waitForElementClickable(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.PRICE_LOW_TO_HIGH);
		waitAllElementsPresence(driver, UserProductPageUI.PRICE_LOW_TO_HIGH);
	}

	public void clickToSortByPriceHighToLow() {
		waitForElementClickable(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.SORT_BY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.PRICE_HIGH_TO_LOW);
		waitAllElementsPresence(driver, UserProductPageUI.PRICE_HIGH_TO_LOW);
	}
	
	/* String elementText;
	 * WebElement element = driver. findElementByXpath("#abc");
	 * elementText = element.getText();
	 * */
	public List<String> getActualSortByName() {
		List<String> list  = getElementsText(driver,  UserProductPageUI.LIST_PRODUCTS_NAME_AFTER_SORT);
		System.out.println("========> TEXT: " + list);
		return list;
	}
	
	
	public List<String> getSortByNameAZ() {
		List<String> list  = getElementsText(driver,  UserProductPageUI.LIST_PRODUCTS_NAME_AFTER_SORT);
		Collections.sort(list);
		System.out.println("========> SORT: " + list);
		return list;
	}
	
	public List<String> getSortByNameZA() {
		List<String> list  = getElementsText(driver,  UserProductPageUI.LIST_PRODUCTS_NAME_AFTER_SORT);
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("========> SORT: " + list);
		return list;
	}

	public List<String> getActualSortByPrice() {
		List<String> list  = getElementsText(driver,  UserProductPageUI.LIST_PRODUCTS_PRICE_AFTER_SORT);
		System.out.println("========> TEXT: " + list);
		return list;
	}
	
	public List<String> getSortByPriceLowHigh() {
		List<String> list  = getElementsText(driver,  UserProductPageUI.LIST_PRODUCTS_PRICE_AFTER_SORT);
		Collections.sort(list);
		System.out.println("========> SORT: " + list);
		return list;
	}
	
	public List<String> getSortByPriceHighLow() {
		List<String> list  = getElementsText(driver,  UserProductPageUI.LIST_PRODUCTS_PRICE_AFTER_SORT);
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("========> SORT: " + list);
		return list;
	}

	public void clickToDisplay3Items() {
		waitForElementClickable(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.DISPLAY_3_ITEMS_DROPDOWN);
		waitAllElementsPresence(driver, UserProductPageUI.DISPLAY_3_ITEMS_DROPDOWN);
	}
	
	public void clickToDisplay6Items() {
		waitForElementClickable(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.DISPLAY_6_ITEMS_DROPDOWN);
		waitAllElementsPresence(driver, UserProductPageUI.DISPLAY_6_ITEMS_DROPDOWN);
	}
	
	public void clickToDisplay9Items() {
		waitForElementClickable(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserProductPageUI.DISPLAY_9_ITEMS_DROPDOWN);
		waitAllElementsPresence(driver, UserProductPageUI.DISPLAY_9_ITEMS_DROPDOWN);
	}
	
	public int getNumberOfProducts() {
		System.out.println("SIZE ===> " + getElements(driver, UserProductPageUI.LIST_PRODUCTS_DISPLAY).size());
		return getElements(driver, UserProductPageUI.LIST_PRODUCTS_DISPLAY).size();
	}
	
	public boolean isItemsPerPageDisplay(String numberProductDisplay) {
		if (getNumberOfProducts() < Integer.parseInt(numberProductDisplay) || getNumberOfProducts() == Integer.parseInt(numberProductDisplay) ) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDisplay3Items() {
		return isItemsPerPageDisplay(getElementText(driver, UserProductPageUI.DISPLAY_3_ITEMS_DROPDOWN));
	}

	public boolean isDisplay6Items() {
		return isItemsPerPageDisplay(getElementText(driver, UserProductPageUI.DISPLAY_6_ITEMS_DROPDOWN));
	}

	public boolean isDisplay9Items() {
		return isItemsPerPageDisplay(getElementText(driver, UserProductPageUI.DISPLAY_9_ITEMS_DROPDOWN));
	}

	public boolean isNextIconDisplay() {
		return isElementDisplayed(driver, UserProductPageUI.NEXT_PAGE);
	}

	public void clickMoveToPage2() {
		waitForElementClickable(driver, UserProductPageUI.PAGE_2);
		clickToElement(driver, UserProductPageUI.PAGE_2);
		
	}

	public boolean isPreviousIconDisplay() {
	    return isElementDisplayed(driver, UserProductPageUI.PREVIOUS_PAGE);
	}
	
	public boolean isPagingDisplay() {
		try {
			return isElementDisplayed(driver, UserProductPageUI.PAGING);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

		public UserProductPO backToProductsPage() {
		backToPage(driver);
		return PageGeneratorManager.getUserProductPage(driver);
	}

	public UserProductDetailPO clickToDynamicProduct(String nameLink) {
		waitForElementClickable(driver, UserProductPageUI.NAME_PRODUCT_DYNAMIC, nameLink);
		clickToElement(driver, UserProductPageUI.NAME_PRODUCT_DYNAMIC, nameLink);
		return PageGeneratorManager.getUserProductDetailPage(driver);
		
	}

}
