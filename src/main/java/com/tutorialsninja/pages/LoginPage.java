package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgotPasswordButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorMessage;

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	public WebElement getVerifyLoginSuccess() {
		return verifyLoginSuccess;
	}

	public void setVerifyLoginSuccess(WebElement verifyLoginSuccess) {
		this.verifyLoginSuccess = verifyLoginSuccess;
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement verifyLoginSuccess;

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(WebElement errorMessage) {
		this.errorMessage = errorMessage;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(WebElement passwordField) {
		this.passwordField = passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getForgotPasswordButton() {
		return forgotPasswordButton;
	}

	public void setForgotPasswordButton(WebElement forgotPasswordButton) {
		this.forgotPasswordButton = forgotPasswordButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

}
