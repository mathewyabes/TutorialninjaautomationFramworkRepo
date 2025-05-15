package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.ForgotPasswordPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.utils.Utilities;
import com.tutorialsninja_Base.Base;

public class Login extends Base {

	public WebDriver driver;
	LoginPage lp;

	public Login() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
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
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getVerifyLoginSuccess().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyLoginwithInvalidEmailaddressandInvalidPassword() {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		lp.getPasswordField().sendKeys(dataProp.getProperty("invalidPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyLoginwithInvalidEmailaddressandvalidPassword() {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void verifyLoginwithvalidEmailaddressandInvalidPassword() {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(dataProp.getProperty("invalidPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void verifyLoginwithoutenteringtheCredentials() {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getErrorMessage().getText().contains(dataProp.getProperty("emailorPasswordNotMatching")),
				"Warning message is not displayed");
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void verifyForgotpasswordlink() {
		lp = PageFactory.initElements(driver, LoginPage.class);
		ForgotPasswordPage fp = PageFactory.initElements(driver, ForgotPasswordPage.class);
		Assert.assertTrue(lp.getForgotPasswordButton().isDisplayed());
		lp.getForgotPasswordButton().click();
		Assert.assertTrue(fp.getForgotPasswordPage().getText().contains(dataProp.getProperty("forgotpassPage")));
		softAssert.assertAll();
	}

}
