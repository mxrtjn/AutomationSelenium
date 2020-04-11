package com.toptal.tests;

import com.toptal.webpages.NewFreelancerPage;
import com.github.javafaker.Faker;
import com.toptal.webpages.CheckConfirmationPage;
import com.toptal.webpages.HomePage;

import common.Page_BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplyAsDeveloperTest extends Page_BasePage {

	private HomePage homePage;
	private NewFreelancerPage newFreelancerPage;
	private CheckConfirmationPage checkConfirmationPage;
	private Faker faker = new Faker();
	private String emailFaker = faker.internet().emailAddress();
	private String passwordFaker = faker.internet().password();
	private String fullnameFaker = faker.name().fullName();

	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
		newFreelancerPage = new NewFreelancerPage(driver);
		checkConfirmationPage = new CheckConfirmationPage(driver);
	}

	@Given("^I am navigating in Home Page$")
	public void i_am_navigating_in_Home_Page() {
		GoToHomePage();
	}

	@Given("^I click on ApplyAsAFreelancer button$")
	public void i_click_on_ApplyAsAFreelancer_button() {
		homePage.clickOnApplyAsFreelancerBtn();
	}

	@Then("^I am redirected to ApplyAsAFreelancer page$")
	public void i_am_redirected_to_ApplyAsAFreelancer_page() {
		Assert.assertTrue("It seems is not the Apply As Freelancer Page", newFreelancerPage.isCorrectFreelancerTitle());
	}

	@Then("^I fill all mandatory inputs$")
	public void i_fill_all_mandatory_inputs() throws InterruptedException {
		newFreelancerPage.clickOnGotItCookieButtonIfPresent();
		newFreelancerPage.select_freelancer_type("developers");
		newFreelancerPage.setDeveloper_email(emailFaker);
		newFreelancerPage.setDeveloper_password(passwordFaker);
		newFreelancerPage.setDeveloper_password_confirmation(passwordFaker);
		newFreelancerPage.setDeveloper_full_name(fullnameFaker);
		newFreelancerPage.check_acknowledge();
	}

	@Then("^I click on JoinToptal button$")
	public void i_click_on_JoinToptal_button() throws InterruptedException {
		newFreelancerPage.clickOnJoinButton();
		Thread.sleep(30000);//adding 30 seconds to pass captcha manually
	}

	@Then("^I should see a successful message$")
	public void i_should_see_a_successful_message() {
		Assert.assertTrue("Title Check Page is not correct.", checkConfirmationPage.checkTitlePage());
		Assert.assertTrue("Email link text is incorrect.", checkConfirmationPage.checkEmailValue(emailFaker));
		Assert.assertTrue("Resend link text is incorrect.", checkConfirmationPage.checkResendText());
	}

	@After
	public void close() {
		driver.close();
	}

}
