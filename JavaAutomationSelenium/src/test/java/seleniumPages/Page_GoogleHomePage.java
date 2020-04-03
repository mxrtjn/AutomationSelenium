package seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import common.Page_BasePage;

public class Page_GoogleHomePage extends Page_BasePage {

	public void launchBrowser() {
		/*
		 * String os = System.getProperty("os.name").toLowerCase(); String chromePath =
		 * null; if (os.contains("mac")) { chromePath = System.getProperty("user.dir") +
		 * "/src/test/resources/chromedriver"; } else { chromePath =
		 * System.getProperty("user.dir") + "/chromedriver.exe"; }
		 * System.out.println(":chromePath: " + chromePath);
		 */
		driver = new ChromeDriver();
	}

	public void openGoogleURL() {
		driver.get("http://www.google.com");
	}

	public void checkSearchBoxIsDisplayed() {
		if (driver.findElement(By.name("q")).isDisplayed()) {
			System.out.println("Search text box is displayed");
		} else {
			System.out.println("Search text box is NOT displayed");
		}
	}

	public void checkGoogleSearchButtonIsDisplayed() {
		if (driver.findElement(By.name("btnK")).isDisplayed()) {
			System.out.println("Google Search button is displayed");
		} else {
			System.out.println("Google Search button is NOT displayed");
		}
	}

	public void checkImFeelingLuckyButtonIsDisplayed() {
		if (driver.findElement(By.name("btnI")).isDisplayed()) {
			System.out.println("I'm Feeling Lucky button is displayed");
		} else {
			System.out.println("I'm Feeling Lucky button is NOT displayed");
		}
	}
}
