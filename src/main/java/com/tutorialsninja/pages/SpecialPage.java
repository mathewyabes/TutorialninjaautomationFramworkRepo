package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialPage {

	@FindBy(xpath = "//h2[text()='Special Offers']")
	private WebElement specialOfferPageCheckup;

	@FindBy(linkText = "Site Map")
	private WebElement sitemaplink;

	@FindBy(xpath = "//h1[text()='Site Map']")
	private WebElement sitemapPageverify;

	@FindBy(linkText = "Product Compare (0)")
	private WebElement productCompareverify;

	@FindBy(id = "input-limit")
	private WebElement showDropdown;

	@FindBy(linkText = "Apple Cinema 30\"")
	private WebElement productDetailsinShow;

	@FindBy(linkText = "Specials")
	private WebElement specialPagelink;

	@FindBy(xpath = "(//button[@data-original-title='Compare this Product'])[1]")
	private WebElement compareProductButton;
	
	@FindBy(linkText = "Apple Cinema 30\"")
	private WebElement product1stName;
	
	@FindBy(xpath = "(//a[@class='thumbnail' and @title='Apple Cinema 30\"'])[1]")
	private WebElement firstProductName;

	public WebElement getFirstProductName() {
		return firstProductName;
	}

	public void setFirstProductName(WebElement firstProductName) {
		this.firstProductName = firstProductName;
	}

	public WebElement getProduct1stName() {
		return product1stName;
	}

	public void setProduct1stName(WebElement product1stName) {
		this.product1stName = product1stName;
	}

	public WebElement getCompareProductButton() {
		return compareProductButton;
	}

	public void setCompareProductButton(WebElement compareProductButton) {
		this.compareProductButton = compareProductButton;
	}

	public WebElement getSpecialPagelink() {
		return specialPagelink;
	}

	public void setSpecialPagelink(WebElement specialPagelink) {
		this.specialPagelink = specialPagelink;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(WebElement successMessage) {
		this.successMessage = successMessage;
	}

	@FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
	private WebElement wishListButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(text(), 'Success')]")
	private WebElement successMessage;

	public WebElement getWishListButton() {
		return wishListButton;
	}

	public void setWishListButton(WebElement wishListButton) {
		this.wishListButton = wishListButton;
	}

	public WebElement getProductDetailsinShow() {
		return productDetailsinShow;
	}

	public void setProductDetailsinShow(WebElement productDetailsinShow) {
		this.productDetailsinShow = productDetailsinShow;
	}

	public WebElement getShowDropdown() {
		return showDropdown;
	}

	public void setShowDropdown(WebElement showDropdown) {
		this.showDropdown = showDropdown;
	}

	public WebElement getProductCompareverify() {
		return productCompareverify;
	}

	public void setProductCompareverify(WebElement productCompareverify) {
		this.productCompareverify = productCompareverify;
	}

	public WebElement getSitemapPageverify() {
		return sitemapPageverify;
	}

	public void setSitemapPageverify(WebElement sitemapPageverify) {
		this.sitemapPageverify = sitemapPageverify;
	}

	public WebElement getSitemaplink() {
		return sitemaplink;
	}

	public void setSitemaplink(WebElement sitemaplink) {
		this.sitemaplink = sitemaplink;
	}

	public WebElement getSpecialOfferPageCheckup() {
		return specialOfferPageCheckup;
	}

	public void setSpecialOfferPageCheckup(WebElement specialOfferPageCheckup) {
		this.specialOfferPageCheckup = specialOfferPageCheckup;
	}

}
