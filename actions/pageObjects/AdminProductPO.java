package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;

	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToProductName(String value) {
		sendKeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		sleepInSecond(2);

	}

	public boolean isResultContainsKeyword(String keyword) {
		return isResultContainsKeyword(driver, keyword, AdminProductPageUI.PROUCTS_NAME_LIST_IN_TABLE);
	}

	public String getSizeItemsInTableResult() {
		List<String> listItems = getElementsText(driver, AdminProductPageUI.PROUCTS_NAME_LIST_IN_TABLE);
		return String.valueOf(listItems.size());
	}

	public void selectCategory(String value) {
		selectItemByVisible(driver, AdminProductPageUI.CATEGORY_DROP_DOWN, value);
	}

	public boolean isNoDataMessageDisplay() {
		return isElementDisplayed(driver, AdminProductPageUI.NO_DATA_MESSAGE);
	}

	/*
	 * neu a = true : ma chua check thi check, check roi thi thoi neu a = false : check thi uncheck, khong check thi thoi
	 */
	public void checkToSearchSubCategories(boolean a) {
		if (a == true) {
			if (!isElementSelected(driver, AdminProductPageUI.SUB_CATEGORIES_CHECKBOX)) {
				clickToElement(driver, AdminProductPageUI.SUB_CATEGORIES_CHECKBOX);
			}

		} else {
			if (isElementSelected(driver, AdminProductPageUI.SUB_CATEGORIES_CHECKBOX)) {
				clickToElement(driver, AdminProductPageUI.SUB_CATEGORIES_CHECKBOX);
			}
		}
	}

	public void selectManufacturer(String value) {
		selectItemByVisible(driver, AdminProductPageUI.MANUFACTURER_DROPDOWN, value);
	}

	public void inputToProductSKU(String value) {
		sendKeyToElement(driver, AdminProductPageUI.SKU_TEXTBOX, value);

	}

	public AdminProductDetailPO clickToGoSKU() {
		clickToElement(driver, AdminProductPageUI.GO_SKU_BUTTON);
		return PageGeneratorManager.getAdminProductDetailPage(driver);
	}

	public void goToPageAtTableByIndex(String valueIndex) {
		waitForElementClickable(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, valueIndex);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, valueIndex);
		sleepInSecond(3);
	}

	public boolean isPagingActivateByIndex(String valueIndex) {
		waitForElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, valueIndex);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, valueIndex);
	}

	public void checkToSelectAllCheckBox() {
		waitAjaxLoadingInvisible(driver);
		waitForElementClickable(driver, AdminProductPageUI.CHECKBOX_SELECT_ALL);
		checkToCheckBox(driver, AdminProductPageUI.CHECKBOX_SELECT_ALL);
		sleepInSecond(5);
	}

	public boolean areProductsCheckboxChecked() {
		int sizeItems = getElements(driver, AdminProductPageUI.ALL_CHECKBOX).size();
		int check = 0;
		List<WebElement> listItems = getElements(driver, AdminProductPageUI.ALL_CHECKBOX);
		for (WebElement w : listItems) {
			if (w.isSelected()) {
				check++;
			}
		}
		System.out.println("check ===> " + check);
		if (check == sizeItems) {
			return true;
		} else {
			return false;
		}
	}

	public void unCheckToSelectAllCheckBox() {
		waitForElementClickable(driver, AdminProductPageUI.CHECKBOX_SELECT_ALL);
		unCheckToCheckBox(driver, AdminProductPageUI.CHECKBOX_SELECT_ALL);

	}

	public boolean areProductsCheckboxUnChecked() {
		int sizeItems = getElements(driver, AdminProductPageUI.ALL_CHECKBOX).size();
		int check = 0;
		List<WebElement> listItems = getElements(driver, AdminProductPageUI.ALL_CHECKBOX);
		for (WebElement w : listItems) {
			if (!w.isSelected()) {
				check++;
			}
		}
		System.out.println("check ===> " + check);
		if (check == sizeItems) {
			return true;
		} else {
			return false;
		}
	}

	public void checkToProductCheckboxByName(String nameProduct) {
		waitForElementClickable(driver, AdminProductPageUI.CHECKBOX_AT_PER_PRODUCTS, nameProduct);
		checkToCheckBox(driver, AdminProductPageUI.CHECKBOX_AT_PER_PRODUCTS, nameProduct);
		sleepInSecond(2);
	}

	public boolean areProductDetailDisplayed(String productName, String skuID, String price, String quantity, String productType, String publishStatus) {
		waitForElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity, productType, publishStatus);
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity, productType, publishStatus);
		
	}

}
