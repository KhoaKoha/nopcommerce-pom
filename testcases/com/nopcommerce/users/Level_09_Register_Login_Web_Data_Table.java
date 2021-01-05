package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.DemoTablePO;

public class Level_09_Register_Login_Web_Data_Table extends AbstractTest {
	WebDriver driver;

	DemoTablePO demoPage; 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", GlobalConstants.ROOT_FOLDER + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		demoPage = new DemoTablePO(driver); 
//		demoPage.inputDataAtRow("1", "FPT", "Test Auto", "United States", "true", "1", "04012021");
//		demoPage.inputDataAtRow("3", "APPLE", "Test Manual", "Japan", "false", "100", "04012021");
		
		demoPage.inputToDynamicTextboxByRowNumber("Company", "1", "Automation Testing");
		demoPage.inputToDynamicTextboxByRowNumber("Order Placed", "3", "Taiwan");
		demoPage.inputToDynamicTextboxByRowNumber("Contact Person", "1", "Ngoc Anh");
		demoPage.selectInDrodownByRowNumber("Country", "3", "United States");
		demoPage.checkToCheckboxByRowNumber("NPO?", "1", "true");
		
		demoPage.inputToDynamicTextboxByRowNumber("Company", "2", "Automation Testing 1");
		demoPage.inputToDynamicTextboxByRowNumber("Contact Person", "3", "Ngoc Anh 2");
		demoPage.inputToDynamicTextboxByRowNumber("Order Placed", "1", "123");
		demoPage.selectInDrodownByRowNumber("Country", "2", "Japan");
		demoPage.checkToCheckboxByRowNumber("NPO?", "2", "false");
		
		demoPage.inputToDynamicTextboxByRowNumber("Company", "3", "Automation Testing 3");
		demoPage.inputToDynamicTextboxByRowNumber("Contact Person", "2", "Ngoc Anh 3");
		demoPage.inputToDynamicTextboxByRowNumber("Order Placed", "2", "678");
		demoPage.selectInDrodownByRowNumber("Country", "1", "Hong Kong");
		demoPage.checkToCheckboxByRowNumber("NPO?", "3", "true");

	}

	
	public void TC_02() {
		driver.get("https://admin-demo.nopcommerce.com/Admin/Order/List");

	}

	
	public void TC_03() {
		driver.get("http://live.demoguru99.com/index.php/backendlogin/customer/");

	}

	@AfterClass
	public void afterClass() {

	}

}
