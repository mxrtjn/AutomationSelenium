package com.toptal.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckConfirmationPage {

	private static final String titlePageText = "Confirm Your Email";

	private static final String resendText = "click here to resend it";

	@FindBy(css = "h1.check_confirmation-header")
	private WebElement checkConfirmationHeader_h1;

	//@FindBy(css = ".check_confirmation-subheader > a:first")//getting error when use ":first" selector
	@FindBy(css = ".check_confirmation-subheader > a:nth-child(1)")
	private WebElement emailVerification_link;

	@FindBy(css = ".check_confirmation-subheader > a.plain")
	private WebElement resend_link;

	public CheckConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean checkTitlePage() {
		return checkConfirmationHeader_h1.getText().equals(titlePageText);
	}

	public boolean checkEmailValue(String email) {
		System.out.println("emailVerification_link");
		System.out.println(emailVerification_link);
		System.out.println("email param: " + email);
		return emailVerification_link.getText().equals(email);
	}

	public boolean checkResendText() {
		return resend_link.getText().equals(resendText);
	}

}
