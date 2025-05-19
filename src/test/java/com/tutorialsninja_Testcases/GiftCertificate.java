package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.GiftCertificatePage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja_Base.Base;

public class GiftCertificate extends Base {

	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	GiftCertificatePage gp;

	public GiftCertificate() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	private void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
		hp = PageFactory.initElements(driver, HomePage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton();
		hp.getGiftCertificateLink().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyNavigatetotheGiftCertificatePage() {
		gp = PageFactory.initElements(driver, GiftCertificatePage.class);
		Assert.assertTrue(gp.getGiftPageCheckup().isDisplayed());
		softAssert.assertAll();
	}
}
