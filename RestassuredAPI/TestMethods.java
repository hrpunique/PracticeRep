package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
	}
@Test
public void searchFacebook() throws InterruptedException {
	
	SearchGoogle page = new SearchGoogle(driver);
	page.searchElement("facebook");
}

@AfterTest
public void afterTest() {
	
	driver.quit();
}
}
