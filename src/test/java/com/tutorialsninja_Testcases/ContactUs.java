package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.ContactPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja_Base.Base;

public class ContactUs extends Base {

	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	ContactPage cp;

	public ContactUs() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
		hp = PageFactory.initElements(driver, HomePage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyNavigatetotheContactPage() {
		hp = PageFactory.initElements(driver, HomePage.class);
		cp = PageFactory.initElements(driver, ContactPage.class);
		hp.getContactUsLink().click();
		Assert.assertTrue(cp.getContactPageVerify().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyNavigatetotheContactPageFooterlink() {
		hp = PageFactory.initElements(driver, HomePage.class);
		cp = PageFactory.initElements(driver, ContactPage.class);
		hp.getContactUsFooterLink().click();
		Assert.assertTrue(cp.getContactPageVerify().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyFillalltheMandatoryFieldinContactUsPage() {
		hp = PageFactory.initElements(driver, HomePage.class);
		cp = PageFactory.initElements(driver, ContactPage.class);
		hp.getContactUsLink().click();
		cp.getNameField().sendKeys(prop.getProperty("userName"));
		cp.getMailAddressField().sendKeys(prop.getProperty("validUserName"));
		cp.getEnqiuryTextField().sendKeys(dataProp.getProperty("enauiryMessage"));
		cp.getSubmitButton().click();
		cp.getContinueButton().click();
		driver.getCurrentUrl().contains(dataProp.getProperty("homepageVerify"));
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void verifyEnterInvalidEmailID() {
		hp = PageFactory.initElements(driver, HomePage.class);
		cp = PageFactory.initElements(driver, ContactPage.class);
		hp.getContactUsLink().click();
		cp.getMailAddressField().clear();
		cp.getMailAddressField().sendKeys(dataProp.getProperty("invalidEmailID"));
		cp.getEnqiuryTextField().sendKeys(dataProp.getProperty("enauiryMessage"));
		cp.getSubmitButton().click();
		Assert.assertTrue(cp.getEmailErrorMessage().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void verifyclickSubmitWithoutEntertheDetails() {
		hp = PageFactory.initElements(driver, HomePage.class);
		cp = PageFactory.initElements(driver, ContactPage.class);
		hp.getContactUsLink().click();
		cp.getMailAddressField().clear();
		cp.getNameField().clear();
		cp.getSubmitButton().click();
		Assert.assertTrue(cp.getNameErrorMessage().isDisplayed());
		Assert.assertTrue(cp.getEmailErrorMessage().isDisplayed());
		Assert.assertTrue(cp.getEnquiryErrorMessage().isDisplayed());
		softAssert.assertAll();
	}
	
}
