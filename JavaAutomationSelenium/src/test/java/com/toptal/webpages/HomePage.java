package com.toptal.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//private static String PAGE_URL = "https://www.toptal.com";

	@FindBy(how = How.LINK_TEXT, using = "Apply as a Freelancer")
	private WebElement applyAsFreelancerBtn;

	public HomePage(WebDriver driver) {
		//driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}

	public void clickOnApplyAsFreelancerBtn() {
		applyAsFreelancerBtn.click();
	}
}
