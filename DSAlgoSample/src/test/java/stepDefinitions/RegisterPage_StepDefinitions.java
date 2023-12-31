package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgoproject.apphooks.Hooks;
import com.dsalgoproject.pageobjects.RegisterPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPage_StepDefinitions {
	private WebDriver driver;
	RegisterPage_PageObject registerPageObj;
	private final static Logger LOG= LogManager.getLogger(RegisterPage_StepDefinitions.class);
	
	public RegisterPage_StepDefinitions()
	{
		 driver = Hooks.getDriver();
		 registerPageObj =  new RegisterPage_PageObject(driver);
	}
	@Given("The user opens Register page")
	public void the_user_opens_register_page() {
		registerPageObj.registerLogin();
	}

	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		registerPageObj.clickWithoutGivingUserNameAndPassword();
	}
    
	@Then("It should display an error {string}")
	public void it_should_display(String string) {
	 		
		String actualErrorMessage = registerPageObj.unameGetAttribute();
		System.out.println("the actualerror is"  +actualErrorMessage);
		Assert.assertEquals(actualErrorMessage, string);
	}

	@When("The user clicks {string} button after giving username with other fields empty")
	public void the_user_clicks_button_after_giving_username_with_other_fields_empty(String string) {
		
		registerPageObj.clickWithoutGivingPasswords();
	}

	@Then("It should throws an error {string}")
	public void it_should_throws_an_error(String string) {
		String actualErrorMessage = registerPageObj.pwd1GetAttribute();
		Assert.assertEquals(actualErrorMessage, string);
	}

	@When("The user clicks {string} button after giving the username and password with password confirmation field empty")
	public void the_user_clicks_button_after_giving_the_username_and_password_with_password_confirmation_field_empty(String string) {
		registerPageObj.clickWithoutGivingConfirmPassword();
	}

	@Then("The user can see the error message {string}")
	public void the_user_can_see_the_error_message(String string) {
		
		String actualErrorMessage = registerPageObj.pwd2GetAttribute();
		Assert.assertEquals(actualErrorMessage, string);
		LOG.info("Error is printed");
	}

	@When("The user enters {string}, {string}, and {string}")
	public void the_user_enters_and(String string, String string2, String string3) {
		registerPageObj.clickafterGivingInvalidCredentials(string, string2, string3);
	}

	@When("the user clicks the register button")
	public void the_user_clicks_the_register_button() {
		registerPageObj.clickRegisterButton();
	}

	@Then("the user should see the error message indicating {string}")
	public void the_user_should_see_the_error_message_indicating(String string) {
		
		String actualErrorMessage = registerPageObj.geterrorMessage();
		Assert.assertEquals(actualErrorMessage,string );
		
	}
	@When("The user clicks {string} button after giving correct {string},{string} and {string}")
	public void the_user_clicks_button_after_giving_correct_and(String string, String string2, String string3, String string4) {
		registerPageObj.clickafterGivingInvalidCredentials(string2, string3, string4);
	}

	@Then("It should display the success message {string}")
	public void it_should_display_the_success_message(String string) {
		String actualErrorMessage = registerPageObj.getSuccessMessage();
		Assert.assertEquals(actualErrorMessage,string );
	}

}
