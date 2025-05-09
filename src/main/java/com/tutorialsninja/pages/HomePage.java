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
