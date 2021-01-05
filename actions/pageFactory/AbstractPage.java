package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	WebDriverWait explicitWait;
	WebElement element;
	JavascriptExecutor jsExecutor;
	Actions action;
	Select select;
	
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectItemByVisible(WebDriver driver, WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}
	
	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, WebElement element) {
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
}
