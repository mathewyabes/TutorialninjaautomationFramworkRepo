package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.utils.Utilities;
import com.tutorialsninja_Base.Base;

public class Login extends Base {

	public WebDriver driver;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserandLaunchApplicaionusingURL(prop.getProperty("browserName"));
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLoginwithValidCredential() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getVerifyLoginSuccess().isDisplayed());
	}

	@Test(priority = 2)
	public void verifyLoginwithInvalidEmailaddressandInvalidPassword() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		lp.getPasswordField().sendKeys(dataProp.getProperty("invalidPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
	}

	@Test(priority = 3)
	public void verifyLoginwithInvalidEmailaddressandvalidPassword() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
	}

	@Test(priority = 4)
	public void verifyLoginwithvalidEmailaddressandInvalidPassword() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(dataProp.getProperty("invalidPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
	}

	@Test(priority = 5)
	public void verifyLoginwithoutenteringtheCredentials() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
	}
}
