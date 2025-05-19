package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(linkText = "Specials")
	private WebElement specialLink;

	@FindBy(linkText = "Gift Certificates")
	private WebElement giftCertificateLink;

	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement contactUsLink;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsFooterLink;

	public WebElement getContactUsFooterLink() {
		return contactUsFooterLink;
	}

	public void setContactUsFooterLink(WebElement contactUsFooterLink) {
		this.contactUsFooterLink = contactUsFooterLink;
	}

	public void setContactUsLink(WebElement contactUsLink) {
		this.contactUsLink = contactUsLink;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}

	public void setContacyUsLink(WebElement contactUsLink) {
		this.contactUsLink = contactUsLink;
	}

	public WebElement getSpecialLink() {
		return specialLink;
	}

	public WebElement getGiftCertificateLink() {
		return giftCertificateLink;
	}

	public void setGiftCertificateLink(WebElement giftCertificateLink) {
		this.giftCertificateLink = giftCertificateLink;
	}

	public void setSpecialLink(WebElement specialLink) {
		this.specialLink = specialLink;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public void setMyAccount(WebElement myAccount) {
		this.myAccount = myAccount;
	}

	public WebElement getLoginOption() {
		return loginOption;
	}

	public void setLoginOption(WebElement loginOption) {
		this.loginOption = loginOption;
	}

	public WebElement getRegisterOption() {
		return registerOption;
	}

	public void setRegisterOption(WebElement registerOption) {
		this.registerOption = registerOption;
	}

}
