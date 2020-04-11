package com.toptal.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewFreelancerPage {

	private WebDriver driver;

	private final static String titlePageText = "Apply to Join our Network of\nTop Freelancers";

	@FindBy(css = ".modal-content-header.is-centered.is-medium")
	WebElement title_page;

	@FindBy(css = ".input.has-default_value[data-role=\"custom_field\"]")
	WebElement freelancerType_combo;

	@FindBy(id = "talent_create_applicant_email")
	WebElement developer_email;

	@FindBy(id = "talent_create_applicant_password")
	WebElement developer_password;

	@FindBy(id = "talent_create_applicant_password_confirmation")
	WebElement developer_password_confirmation;

	@FindBy(id = "talent_create_applicant_full_name")
	WebElement developer_full_name;

	@FindBy(className = "label_wrap")
	WebElement acknowledge_checkbox;

	@FindBy(id = "save_new_talent_create_applicant")
	WebElement join_toptal_button;

	@FindBy(css = ".cookie_banner-container a.cookie_banner-btn_allow")
	WebElement gotItCookie_button;

	public NewFreelancerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCorrectFreelancerTitle() {
		return title_page.getText().contentEquals(titlePageText);
	}

	public void select_freelancer_type(String type) {
		String selectorItemType = ".custom_select-options_item[data-value=\"" + type + "\"]";
		WebElement itemType_combo = driver.findElement(By.cssSelector(selectorItemType));
		freelancerType_combo.click();
		itemType_combo.click();
	}

	public void setDeveloper_email(String email) {
		developer_email.clear();
		developer_email.sendKeys(email);
	}

	public void setDeveloper_password(String password) {
		developer_password.clear();
		developer_password.sendKeys(password);
	}

	public void setDeveloper_password_confirmation(String password_confirmation) {
		developer_password_confirmation.clear();
		developer_password_confirmation.sendKeys(password_confirmation);
	}

	public void setDeveloper_full_name(String fullname) {
		developer_full_name.clear();
		developer_full_name.sendKeys(fullname);
	}

	public void check_acknowledge() {
		if (!acknowledge_checkbox.isSelected()) {
			acknowledge_checkbox.click();
		}
	}

	public void clickOnJoinButton() {
		join_toptal_button.click();
	}

	public void clickOnGotItCookieButtonIfPresent() {
		if (gotItCookie_button.isDisplayed()) {
			gotItCookie_button.click();
		}
	}

}
