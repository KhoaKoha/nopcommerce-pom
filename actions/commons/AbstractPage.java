package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressesPO;
import pageObjects.UserCartPO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserMyAccountInFooterPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrdersPO;
import pageObjects.UserProductPO;
import pageObjects.UserRecentlyViewedPO;
import pageObjects.UserSearchPO;
import pageObjects.UserShippingAndReturnPO;
import pageObjects.UserSiteMapPO;
import pageObjects.UserWishListInHeaderPO;
import pageUIs.AbstractPageUI;
import pageUIs.UserHomePageUI;
import pageUIs.UserProductDetailPageUI;

public class AbstractPage {
	WebDriverWait explicitWait;
	WebElement element;
	JavascriptExecutor jsExecutor;
	Actions action;
	Select select;

	// Browser
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAler(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAler(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAler(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// Windows
	public String getWindowID(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public Set<String> getListWindowsID(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public void switchWindowByID(WebDriver driver, String ID) {
		Set<String> IdWinDow = driver.getWindowHandles();
		for (String a : IdWinDow) {
			if (!a.equals(ID)) {
				driver.switchTo().window(a);
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> windows = driver.getWindowHandles();

		for (String a : windows) {
			driver.switchTo().window(a);

			if (driver.getTitle().equals(expectedTitle)) {

				break;
			}
		}
		sleepInSecond(4);
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String ID) {
		Set<String> IdWinDow = driver.getWindowHandles();
		for (String a : IdWinDow) {
			if (!a.equals(ID)) {
				driver.switchTo().window(a);
				sleepInSecond(2);
				driver.close();
			}
		}
	}

	// Element
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpth(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpth(locator));
	}
	
	
	public int getSizeElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpth(locator)).size();
	}
	
	public int getSizeElements(WebDriver driver, String locator, String...values) {
		return driver.findElements(getByXpth(castToParameter(locator, values))).size();
	}

	public By getByXpth(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver,String value, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		element.clear();
		element.sendKeys(value);

		// return getElement(driver, String.format(locator, (Object[]) value)).isSelected();
	}

	public void selectItemByVisible(WebDriver driver,String textValue, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(textValue);
	}
	public void selectItemByVisible(WebDriver driver, String textValue, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		select = new Select(element);
		select.selectByVisibleText(textValue);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		element = getElement(driver, castToParameter(locator, values));
		return element.getText();
	}

	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public void checkToCheckBox(WebDriver driver, String locator, String...values) {
		element  = getElement(driver, castToParameter(locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckBox(WebDriver driver, String locator) {
		element  =  getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, castToParameter(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getElement(driver, castToParameter(locator, values)).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator, String... value) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, String.format(locator, (Object[]) value))).perform();
	}

	public void clickAndHoleToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}

	public void dragAnđropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	// Custom dropdown

	public void selectElementInDropdown(WebDriver driver, String locatorParent, String locatorAllItem, String valueExpected, String locatorExpected) {
		sleepInSecond(2);
		// 1. Click vào thẻ bất kỳ để xổ hết tất cả các item trong dropdown ra
		clickToElement(driver, locatorParent);

		// 2. Chờ cho tất cả item được xuất hiện / có trong HTML DOM
		waitAllElementsPresence(driver, locatorAllItem);

		// 3. Lấy tất cả item này đưa vào 1 list WebElement
		List<WebElement> listAllElement = getElements(driver, locatorAllItem);

		// 4. Duyệt qua từng cái Item
		for (WebElement itemElement : listAllElement) {
			// 5. Mỗi lần duyệt kiểm tra xem text của item đó có bằng với items mình cần
			// click hay hông
			if (itemElement.getText().equals(valueExpected)) {
				// Trước khi Click thì scroll xuống chính nó
				scrollToElementByJS(driver, locatorExpected);

				waitForElementClickable(driver, locatorExpected);
				// 6. Nếu như = thì click vào và thoát khỏi vòng lặp
				// 7.Nếu như hông = thì lại duyệt tiếp cho đến hết tất cả item
				sleepInSecond(2);

				itemElement.click();
				sleepInSecond(2);
				break;
			}
		}

	}

	public void multipleSelect(WebDriver driver, String locatorParent, String locatorAllItem, String[] expectedValue) {

		// 1. Click vào dropdown cho nó xổ hết tất cả các item ra
		clickToElement(driver, locatorParent);

		// 2. Chờ cho tất cả các item được load thành công
		waitAllElementsPresence(driver, locatorAllItem);

		// 3. Đưa các item vào 1 list
		List<WebElement> allItems = getElements(driver, locatorAllItem);

		// 4. Duyêt tất cả phần từ trong list cho đến khi thỏa mản điều kiện (Tức là tìm
		// được cái đã chọn)
		for (WebElement items : allItems) {
			for (String item : expectedValue) {
				if (items.getText().equals(item)) {
					// 5. Scroll đến item cần chọn
					jsExecutor.executeScript("arguments[0].scrollIntoView(true)", items);
					sleepInSecond(1);
					// 6. Click vào item cần chọn
					items.click();
					break;
				}
			}
		}

	}

	public void checkSelectedItem(WebDriver driver, String locatorListItems, String locatorSelectedItem, String locatorResult, String[] expectedValue) {
		List<WebElement> AllItems = getElements(driver, locatorListItems);
		List<WebElement> itemsSelected = getElements(driver, locatorSelectedItem);

		int numberSelected = itemsSelected.size();
		int numberItems = AllItems.size() - 1;

		Assert.assertEquals(numberSelected, expectedValue.length);

		String selectedText = getElementText(driver, locatorResult);
		if (numberSelected <= 3 && numberSelected >= 0) {
			// 8.Nếu số lượng đã chọn nhỏ hơn hoặc = 3 thì hiển thị text của từng cái đã
			// chọn
			for (String items : expectedValue) {
				if (selectedText.contains(items)) {
					break;
				}
			}
		} else {
			// 9. Nếu không thì hiển thị số cái đã chọn / tổng số
			Assert.assertEquals(getElementText(driver, locatorResult), numberSelected + " of " + numberItems + " selected");
		}

	}

	// Javascript Executor
	public void sendKeyToElementByJS(WebDriver driver, String locator, String text) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", getElement(driver, locator));
	}
	
	public void sendKeyToElementByJS(WebDriver driver, String text, String locator,  String...values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", getElement(driver, String.format(locator, (Object[]) values)));
	}

	public void clickElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", getElement(driver, locator));
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location='" + url + "'");
	}

	public Object getDomainByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.domain");
	}

	public Object getTitleByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.title");
	}

	public Object getUrlByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.URL");
	}

	public Object getInnerTextByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.documentElement.innerText");

	}

	public String getHiddentTextByJS(WebDriver driver,String cssLocator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.querySelector(\"" + cssLocator + "\").textContent");

	}

	public Object scrollToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("arguments[0].scrollIntoView(true)", getElement(driver, locator));
	}

	public Object scrollToBottomPageByJS(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object removeAttributeByJS(WebDriver driver, String locator, String attribute) {
		return jsExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "')", getElement(driver, locator));
	}

	public void highlightElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		getElement(driver, locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth !=\"underfined\"&& arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	// Wait

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpth(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpth(castToParameter(locator, values))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpth(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpth(castToParameter(locator, values))));
	}

	public String castToParameter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpth(locator)));
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpth(locator)));
	}

	public void waitAllElementsPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpth(locator)));
	}

	// 10 => 15 pages
	public AbstractPage openLinkByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		default:
			return PageGeneratorManager.getUserOrdersPage(driver);
		}
	}

	// > 10 pages
	public void openLinkByPage(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
	}

	public UserAddressesPO openAddressesPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.ADDRESSES_LINK);
		clickToElement(driver, AbstractPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}

	public UserOrdersPO openOrdersPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.ORDERS_LINK);
		clickToElement(driver, AbstractPageUI.ORDERS_LINK);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}

	public UserMyProductReviewPO openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, AbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserCustomerInforPO openCustomerInfoPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, AbstractPageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserSearchPO openSearchPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.SEARCH_LINK);
		return PageGeneratorManager.getUserSearchPage(driver);
	}

	public UserShippingAndReturnPO openShippindAndReturnPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.SHIPPING_AND_RETURN_LINK);
		clickToElement(driver, AbstractPageUI.SHIPPING_AND_RETURN_LINK);
		return PageGeneratorManager.getUserShippingAndReturnPage(driver);
	}

	public UserSiteMapPO openSiteMAPPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.SITE_MAP_LINK);
		clickToElement(driver, AbstractPageUI.SITE_MAP_LINK);
		return PageGeneratorManager.getUserSitemapPage(driver);
	}

	public UserMyAccountInFooterPO openMyAccountInFooterPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.MY_ACCOUNT_IN_FOOTER_LINK);
		clickToElement(driver, AbstractPageUI.MY_ACCOUNT_IN_FOOTER_LINK);
		return PageGeneratorManager.getUserMyAccountInFooterPage(driver);
	}

	public UserWishListInHeaderPO openWishListPageInHeader(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.WISHLIST_IN_HEADER_LINK);
		clickToElement(driver, AbstractPageUI.WISHLIST_IN_HEADER_LINK);
		return PageGeneratorManager.getUserWishlistInHeaderPage(driver);
	}

	public UserCartPO opeCartInHeader(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.CART_LINK);
		clickToElement(driver, AbstractPageUI.CART_LINK);
		return PageGeneratorManager.getUserCartPage(driver);
	}

	public UserHomePO openHomePage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserChangePasswordPO openChangePasswrodPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordpPage(driver);
	}

	public UserProductPO clickToNoteBookSubmenu(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.COMPUTER_MENU);
		hoverMouseToElement(driver, AbstractPageUI.COMPUTER_MENU);
		clickToElement(driver, AbstractPageUI.NOTEBOOKS_SUBMENU);
		return PageGeneratorManager.getUserProductPage(driver);
	}

	public UserRecentlyViewedPO openRecentlyViewedProductPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.RECENTLY_VIEWS_LINK);
		clickToElement(driver, AbstractPageUI.RECENTLY_VIEWS_LINK);
		return PageGeneratorManager.getUserRecentlyViewedProductPage(driver);
	}

	public List<String> getElementsText(WebDriver driver, String parentLocator) {
		List<WebElement> items = getElements(driver, parentLocator);
		ArrayList<String> listItems = new ArrayList<String>();
		for (WebElement webElement : items) {
			listItems.add(webElement.getText().trim());
		}
		return listItems;
	}

	public boolean isResultContainsKeyword(WebDriver driver, String keyword, String resultLocator) {
		int check = 0;
		List<String> listItems = getElementsText(driver, resultLocator);
		for (String p : listItems) {
			if (p.trim().contains(keyword)) {
				check++;
			}
		}
		if (listItems.size() == check) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isResultContainsKeyword(WebDriver driver, String resultLocator, String... valueExpected) {
		int check = 0;
		List<String> listItems = getElementsText(driver, resultLocator);
		String[] arrayItems = new String[listItems.size()];
		arrayItems = listItems.toArray(arrayItems);

		for (int i = 0; i < arrayItems.length; i++) {
			for (int j = 0; j < valueExpected.length; j++) {
				if (arrayItems[i].equals(valueExpected[j])) {
					check++;
				}
			}
		}
		if (listItems.size() == check) {
			return true;
		} else {
			return false;
		}
	}

	public String getNumberOfProductAtIconCart(WebDriver driver) {
		return getElementText(driver, AbstractPageUI.QUALITY_ITEMS_AT_CART_ICON);
	}

	public void selectInListCheckBox(WebDriver driver, String listLocatorCheckboxItems, String LocatorLabelItems, String... nameOptions) {
		List<WebElement> checkboxList = getElements(driver, listLocatorCheckboxItems);
		List<WebElement> checkboxLabelList = getElements(driver, LocatorLabelItems);

		for (WebElement w : checkboxList) {
			if (w.isSelected()) {
				w.click();
			}
		}
		WebElement[] arrayCheckbox = new WebElement[checkboxList.size()];
		WebElement[] arrayLabel = new WebElement[checkboxLabelList.size()];

		arrayCheckbox = checkboxList.toArray(arrayCheckbox);
		arrayLabel = checkboxLabelList.toArray(arrayLabel);
		for (int i = 0; i < nameOptions.length; i++) {
			for (int j = 0; j < arrayCheckbox.length; j++) {
				if (nameOptions[i].equals(arrayLabel[j].getText())) {
					if (!arrayCheckbox[j].isSelected()) {
						arrayCheckbox[j].click();
					}
				}
			}
		}
		sleepInSecond(2);
	}

	public void scrollToTopPage(WebDriver driver) {
		scrollToElementByJS(driver, AbstractPageUI.CART_LINK);
	}

	public void hoverMouseToCartInHeader(WebDriver driver) {
		hoverMouseToElement(driver, AbstractPageUI.CART_LINK);
		sleepInSecond(5);

	}

	public void clickToCartInHeader(WebDriver driver) {
		clickToElement(driver, AbstractPageUI.CART_LINK);

	}

	public void hoverMouseToWishlistInHeader(WebDriver driver) {
		hoverMouseToElement(driver, AbstractPageUI.WISHLIST_IN_HEADER_LINK);
		sleepInSecond(2);

	}

	public void hoverToDynamicMenuInNav(WebDriver driver, String nameLink) {
		hoverMouseToElement(driver, AbstractPageUI.MENU_IN_NAV_LINK, nameLink);
	}

	public UserProductPO clickToSubMenuInNav(WebDriver driver, String nameLink) {
		// waitForElementClickable(driver, AbstractPageUI.SUB_MENU_IN_NAV_LINK, nameLink);
		clickToElement(driver, AbstractPageUI.SUB_MENU_IN_NAV_LINK, nameLink);
		return PageGeneratorManager.getUserProductPage(driver);
	}

	public UserCartPO opeCartInFooter(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.CART_LINK_IN_FOOTER);
		clickToElement(driver, AbstractPageUI.CART_LINK_IN_FOOTER);
		return PageGeneratorManager.getUserCartPage(driver);
	}

	public void waitAjaxLoadingInvisible(WebDriver driver) {
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON_AJAX);
	}
}
