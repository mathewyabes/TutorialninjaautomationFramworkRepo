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
import com.tutorialsninja.pages.SearchPage;
import com.tutorialsninja_Base.Base;

public class Search extends Base {

	WebDriver driver;
	LoginPage lp;
	SearchPage sp;

	public Search() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchExistingProductName() {
		sp = PageFactory.initElements(driver, SearchPage.class);
		sp.getSearchBox().sendKeys(dataProp.getProperty("existingProductName"));
		sp.getSearchIcon().click();
		Assert.assertTrue(sp.getProductDetails().getText().contains(dataProp.getProperty("productSearchDetails")),
				"Correct Product is not Displayed");
		softAssert.assertAll();

	}

	@Test(priority = 2)
	public void verifySearchNonExistingProductName() {
		sp = PageFactory.initElements(driver, SearchPage.class);
		sp.getSearchBox().sendKeys(dataProp.getProperty("nonExistingProductName"));
		sp.getSearchIcon().click();
		Assert.assertTrue(sp.getNoMatchesProduct().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifySearchWithoutEnteringName() {
		sp = PageFactory.initElements(driver, SearchPage.class);
		sp.getSearchIcon().click();
		Assert.assertTrue(sp.getNoMatchesProduct().isDisplayed());
		softAssert.assertAll();
	}
}
