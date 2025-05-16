package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja_Base.Base;

public class Logout extends Base {

	public WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;

	public Logout() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	private void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		;
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLogoutUsingDropdown() {
		hp = PageFactory.initElements(driver, HomePage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		mp = PageFactory.initElements(driver, MyAccountPage.class);
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getVerifyLoginSuccess().isDisplayed());
		hp.getMyAccount().click();
		mp.getLogoutButton().click();
		mp.getLogoutButton().click();
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyLogoutUsingRightColoumnOptions() {
		hp = PageFactory.initElements(driver, HomePage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		mp = PageFactory.initElements(driver, MyAccountPage.class);
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		Assert.assertTrue(lp.getVerifyLoginSuccess().isDisplayed());
		mp.getLogoutRightColounm();
		mp.getContinueButton();
		softAssert.assertAll();
	}

}
