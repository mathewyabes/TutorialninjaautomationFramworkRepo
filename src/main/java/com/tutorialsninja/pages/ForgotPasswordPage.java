package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {
	
	@FindBy(xpath = "//h1[text()='Forgot Your Password?']")
	private WebElement forgotPasswordPage;

	public WebElement getForgotPasswordPage() {
		return forgotPasswordPage;
	}

	public void setForgotPasswordPage(WebElement forgotPasswordPage) {
		this.forgotPasswordPage = forgotPasswordPage;
	}
	

}
