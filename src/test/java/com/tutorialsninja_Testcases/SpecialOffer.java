package com.tutorialsninja_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.SpecialPage;
import com.tutorialsninja_Base.Base;

public class SpecialOffer extends Base {
	WebDriver driver;
	SpecialPage sp;
	LoginPage lp;
	HomePage hp;

	public SpecialOffer() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String b) {
		driver = initializeBrowserandLaunchApplicaionusingURL(b);
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.getSpecialLink().click();
	}

	@AfterMethod
	public void teatDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void navigatetotheSpecialOfferPage() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		Assert.assertTrue(sp.getSpecialOfferPageCheckup().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void navigatetotheSiteMapPage() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		sp.getSitemaplink().click();
		Assert.assertTrue(sp.getSitemapPageverify().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyProductComparelink() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		Assert.assertTrue(sp.getProductCompareverify().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void verifyNUmberofProductUsingShowfields() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		WebElement showDropDown = sp.getShowDropdown();
		Select numberofProduct = new Select(showDropDown);
		numberofProduct.selectByVisibleText("100");
		Assert.assertTrue(sp.getProductDetailsinShow().isDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void verifyAddProductintheWishList() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		lp.getLoginButton().click();
		sp.getSpecialPagelink().click();
		sp.getWishListButton().click();
		Assert.assertTrue(sp.getSuccessMessage().isDisplayed(), "Success message is not Displayed");
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void verifyAddProductforComaparison() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		sp.getSpecialPagelink().click();
		sp.getCompareProductButton().click();
		Assert.assertTrue(sp.getSuccessMessage().isDisplayed(), "Success message is not Displayed");
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void verifyProductDisplayPage() {
		sp = PageFactory.initElements(driver, SpecialPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);
		hp.getMyAccount().click();
		hp.getLoginOption().click();
		lp.getEmailField().sendKeys(prop.getProperty("validUserName"));
		lp.getPasswordField().sendKeys(prop.getProperty("validPassword"));
		sp.getSpecialPagelink().click();
		sp.getProduct1stName().click();
		Assert.assertTrue(sp.getFirstProductName().isDisplayed());
		softAssert.assertAll();
	}
}