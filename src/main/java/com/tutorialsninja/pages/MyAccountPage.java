package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

	@FindBy(linkText = "Logout")
	private WebElement logoutButton;

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	@FindBy(linkText = "Logout")
	private WebElement logoutRightColounm;

	public WebElement getLogoutRightColounm() {
		return logoutRightColounm;
	}

	public void setLogoutRightColounm(WebElement logoutRightColounm) {
		this.logoutRightColounm = logoutRightColounm;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(WebElement logoutButton) {
		this.logoutButton = logoutButton;
	}

}
