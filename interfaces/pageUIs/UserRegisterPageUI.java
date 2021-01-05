package pageUIs;

public class UserRegisterPageUI {
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
	public static final String REGISTERED_SUCCESS_MESSAGE = "//div[@class='result']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String FIRSTNAME_VALIDATION_ERROR = "//span[@id='FirstName-error']";
	public static final String LASTNAME_VALIDATION_ERROR = "//span[@id='LastName-error']";
	public static final String EMAIL_VALIDATION_ERROR = "//span[@id='Email-error']";
	public static final String PASSWORD_VALIDATION_ERROR = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_VALIDATION_ERROR = "//span[@id='ConfirmPassword-error']";
	public static final String ACCOUNT_EXISTS_ERROR = "//div[@class='message-error validation-summary-errors']//li";
	public static final String INVALID_PASSWORD_ERROR = "//span[@class='field-validation-error']//span";
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	
}
