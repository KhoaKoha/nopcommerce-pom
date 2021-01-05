package commons;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class AbstractTest {
	private WebDriver driver;
	//private String sourceFolder = System.getProperty("user.dir");

	protected WebDriver getBrowser(String browserName, String urlValue) {
		BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
		
	//	Object browser = browserName.toUpperCase();
		
		if (browser == BrowserName.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browser == BrowserName.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.setExperimentalOption("useAutomationExtension", false);
			chromeOpt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(chromeOpt);
			
		} else if (browser == BrowserName.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefixOpt = new FirefoxOptions();
			firefixOpt.setHeadless(true);
			driver = new FirefoxDriver(firefixOpt);
			
		} else if (browser == BrowserName.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
			
		} else if (browser == BrowserName.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			throw new RuntimeException("Please input valid browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlValue);
		return driver;
	}
}
