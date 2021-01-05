package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageFactory.AbstractPage;

public class LoginPageObject  extends AbstractPage  {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Định nghĩa 1 Element 
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginButton;
	
	
	// Actions
	public void inputToEmailTextbox(String email) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver,emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			sleepInSecond(2);
		}
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}
	
	
}
