package common;

import org.openqa.selenium.WebDriver;

public class Page_BasePage {
	private static String PAGE_URL = "https://www.toptal.com";
	
	public static WebDriver driver;
	public static void GoToHomePage() {
		driver.get(PAGE_URL);
	}
}
