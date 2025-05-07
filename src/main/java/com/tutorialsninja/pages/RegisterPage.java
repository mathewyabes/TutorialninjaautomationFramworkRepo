package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confimPasswordField;

	@FindBy(name = "agree")
	private WebElement agreeCheckbox;

	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement subscribeButton;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

	@FindBy(xpath = "//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	public WebElement successMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public WebElement privacyWarning;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div[@class='text-danger']")
	public WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div[@class='text-danger']")
	public WebElement lastnameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div[@class='text-danger']")
	public WebElement emailWarnig;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div[@class='text-danger']")
	public WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div[@class='text-danger']")
	public WebElement passwordWarning;

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(WebElement firstNameField) {
		this.firstNameField = firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(WebElement lastNameField) {
		this.lastNameField = lastNameField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public void setEmailField(WebElement emailField) {
		this.emailField = emailField;
	}

	public WebElement getTelephoneField() {
		return telephoneField;
	}

	public void setTelephoneField(WebElement telephoneField) {
		this.telephoneField = telephoneField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(WebElement passwordField) {
		this.passwordField = passwordField;
	}

	public WebElement getConfimPasswordField() {
		return confimPasswordField;
	}

	public void setConfimPasswordField(WebElement confimPasswordField) {
		this.confimPasswordField = confimPasswordField;
	}

	public WebElement getAgreeCheckbox() {
		return agreeCheckbox;
	}

	public void setAgreeCheckbox(WebElement agreeCheckbox) {
		this.agreeCheckbox = agreeCheckbox;
	}

	public WebElement getSubscribeButton() {
		return subscribeButton;
	}

	public void setSubscribeButton(WebElement subscribeButton) {
		this.subscribeButton = subscribeButton;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(WebElement successMessage) {
		this.successMessage = successMessage;
	}

	public WebElement getPrivacyWarning() {
		return privacyWarning;
	}

	public void setPrivacyWarning(WebElement privacyWarning) {
		this.privacyWarning = privacyWarning;
	}

	public WebElement getFirstNameWarning() {
		return firstNameWarning;
	}

	public void setFirstNameWarning(WebElement firstNameWarning) {
		this.firstNameWarning = firstNameWarning;
	}

	public WebElement getLastnameWarning() {
		return lastnameWarning;
	}

	public void setLastnameWarning(WebElement lastnameWarning) {
		this.lastnameWarning = lastnameWarning;
	}

	public WebElement getEmailWarnig() {
		return emailWarnig;
	}

	public void setEmailWarnig(WebElement emailWarnig) {
		this.emailWarnig = emailWarnig;
	}

	public WebElement getTelephoneWarning() {
		return telephoneWarning;
	}

	public void setTelephoneWarning(WebElement telephoneWarning) {
		this.telephoneWarning = telephoneWarning;
	}

	public WebElement getPasswordWarning() {
		return passwordWarning;
	}

	public void setPasswordWarning(WebElement passwordWarning) {
		this.passwordWarning = passwordWarning;
	}

	

}
