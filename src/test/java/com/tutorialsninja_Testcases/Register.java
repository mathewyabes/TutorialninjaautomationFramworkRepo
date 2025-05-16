package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.utils.Utilities;
import com.tutorialsninja_Base.Base;

public class Register extends Base {

	public WebDriver driver;
	HomePage hp;
	RegisterPage rp;

	public Register() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.getMyAccount().click();
		hp.getRegisterOption().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Test(priority = 1)
	public void verifyRegisteraccountwithMandatoryFields() {
		rp = PageFactory.initElements(driver, RegisterPage.class);
		rp.getFirstNameField().sendKeys(dataProp.getProperty("firstName"));
		rp.getLastNameField().sendKeys(dataProp.getProperty("lastName"));
		rp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		rp.getTelephoneField().sendKeys(dataProp.getProperty("telePhone"));
		rp.getPasswordField().sendKeys(dataProp.getProperty("password"));
		rp.getConfimPasswordField().sendKeys(dataProp.getProperty("confirmPassword"));
		rp.getAgreeCheckbox().click();
		rp.getContinueButton().click();
		Assert.assertTrue(rp.getSuccessMessage().getText().contains(dataProp.getProperty("Accountcreated")),
				"Success Message is not Displayed");
	}

	@Test(priority = 2)
	private void verifyRegisteringanAccountbyprovidingallthefields() {
		rp = PageFactory.initElements(driver, RegisterPage.class);
		rp.getFirstNameField().sendKeys(dataProp.getProperty("firstName"));
		rp.getLastNameField().sendKeys(dataProp.getProperty("lastName"));
		rp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		rp.getTelephoneField().sendKeys(dataProp.getProperty("telePhone"));
		rp.getPasswordField().sendKeys(dataProp.getProperty("password"));
		rp.getConfimPasswordField().sendKeys(dataProp.getProperty("confirmPassword"));
		rp.getSubscribeButton().click();
		rp.getAgreeCheckbox().click();
		rp.getContinueButton().click();
		Assert.assertTrue(rp.getSuccessMessage().getText().contains(dataProp.getProperty("Accountcreated")),
				"Success Message is not Displayed");
	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		rp = PageFactory.initElements(driver, RegisterPage.class);
		rp.getContinueButton().click();
		Assert.assertTrue(rp.getPrivacyWarning().getText().contains(dataProp.getProperty("privacyPolicymessage")),
				"Privacy policy message is not displayed");
		Assert.assertTrue(rp.getFirstNameWarning().getText().contains(dataProp.getProperty("firstNameWarningMessage")),
				"First name Warinig messsage not displayed");
		Assert.assertTrue(rp.getLastnameWarning().getText().contains(dataProp.getProperty("lastNameWarningMessage")),
				"Last name warning message is not displayed");
		Assert.assertTrue(rp.getEmailWarnig().getText().contains(dataProp.getProperty("emailAddressWarningMessage")),
				"Email warning message is not displayed");
		Assert.assertTrue(rp.getTelephoneWarning().getText().contains(dataProp.getProperty("telephoneWarningMessage")),
				"Telephone warning message is not displayed");
		Assert.assertTrue(rp.getPasswordWarning().getText().contains(dataProp.getProperty("passwordWarningMessage")),
				"Password warning message is not displayed");
	}

	@Test(priority = 4)
	public void verifyRegisterAccountEnteringDifferentPassword() {
		rp = PageFactory.initElements(driver, RegisterPage.class);
		rp.getContinueButton().click();
		rp.getFirstNameField().sendKeys(dataProp.getProperty("firstName"));
		rp.getLastNameField().sendKeys(dataProp.getProperty("lastName"));
		rp.getEmailField().sendKeys(Utilities.generateTimeStamp());
		rp.getTelephoneField().sendKeys(dataProp.getProperty("telePhone"));
		rp.getPasswordField().sendKeys(dataProp.getProperty("password"));
		rp.getConfimPasswordField().sendKeys(prop.getProperty("validPassword"));
		rp.getAgreeCheckbox().click();
		rp.getContinueButton().click();
		Assert.assertTrue(rp.getPasswordMismatch().getText().contains(dataProp.getProperty("passwordMismatchMessage")),
				"Password Mismatch Message is not displayed");
	}

	@Test(priority = 5)
	public void verifyRegisteringanAccountExistingAccount() {
		rp = PageFactory.initElements(driver, RegisterPage.class);
		rp.getFirstNameField().sendKeys(dataProp.getProperty("firstName"));
		rp.getLastNameField().sendKeys(dataProp.getProperty("lastName"));
		rp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		rp.getTelephoneField().sendKeys(dataProp.getProperty("telePhone"));
		rp.getPasswordField().sendKeys(dataProp.getProperty("password"));
		rp.getConfimPasswordField().sendKeys(dataProp.getProperty("confirmPassword"));
		rp.getSubscribeButton().click();
		rp.getAgreeCheckbox().click();
		rp.getContinueButton().click();
		Assert.assertTrue(rp.getEmailAlreadyExist().getText().contains(dataProp.getProperty("emailAlreadyExist")),
				"Email ID already exists Message is not Displayed");
	}

	@Test(priority = 6)
	public void verifyRegisterAccountbyusinginvalidEmail() {
		rp = PageFactory.initElements(driver, RegisterPage.class);
		rp.getFirstNameField().sendKeys(dataProp.getProperty("firstName"));
		rp.getLastNameField().sendKeys(dataProp.getProperty("lastName"));
		rp.getEmailField().sendKeys(dataProp.getProperty("invalidEmailID"));
		rp.getTelephoneField().sendKeys(dataProp.getProperty("telePhone"));
		rp.getPasswordField().sendKeys(dataProp.getProperty("password"));
		rp.getConfimPasswordField().sendKeys(dataProp.getProperty("confirmPassword"));
		rp.getAgreeCheckbox().click();
		rp.getContinueButton().click();
		Assert.assertTrue(rp.getInvalidEmailmessage().getText().contains(dataProp.getProperty("invalidEmailMessage")));
	}

}
