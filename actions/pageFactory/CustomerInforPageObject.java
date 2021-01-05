package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerInforPageObject extends AbstractPage{
	WebDriver driver;
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement dayDropdown;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement monthDropdown;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement yearDropdown;
	
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Company")
	WebElement companyTextbox;
	
	@FindBy(id = "Newsletter")
	WebElement newsletterTextbox;
	
	

	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}

	public String getFLastNameTextboxValue() {
		waitForElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitForElementVisible(driver,dayDropdown);
		return getFirstSelectedTextInDropdown(driver, dayDropdown);
	}

	public String getSelectedTextInMonthDropdown() {
		waitForElementVisible(driver,monthDropdown);
		return getFirstSelectedTextInDropdown(driver,monthDropdown);
	}

	public String getSelectedTextInYearDropdown() {
		waitForElementVisible(driver, yearDropdown);
		return getFirstSelectedTextInDropdown(driver,yearDropdown);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, companyTextbox);
		return getElementAttribute(driver,companyTextbox, "value");
	}
	

}
