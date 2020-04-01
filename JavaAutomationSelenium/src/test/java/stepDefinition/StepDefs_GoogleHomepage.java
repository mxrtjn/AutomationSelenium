package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumPages.Page_GoogleHomePage;

public class StepDefs_GoogleHomepage {
	
	Page_GoogleHomePage googleHomePage = new Page_GoogleHomePage();
	
	@Given("^I launch Chrome browser$")
	public void i_launch_Chrome_browser() throws Throwable {
	    googleHomePage.launchBrowser();
	}

	@When("^I open Google Homepage$")
	public void i_open_Google_Homepage() throws Throwable {
		googleHomePage.openGoogleURL();
	}

	@Then("^I verify that the page displays search text box$")
	public void i_verify_that_the_page_displays_search_text_box() throws Throwable {
		googleHomePage.checkSearchBoxIsDisplayed();
	}

	@Then("^the page displays Google Search button$")
	public void the_page_displays_Google_Search_button() throws Throwable {
		googleHomePage.checkGoogleSearchButtonIsDisplayed();
	}

	@Then("^the page displays Im Feeling Lucky button$")
	public void the_page_displays_Im_Feeling_Lucky_button() throws Throwable {
		googleHomePage.checkImFeelingLuckyButtonIsDisplayed();
	}
}
