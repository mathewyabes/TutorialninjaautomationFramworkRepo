package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {

	@FindBy(xpath = "//h1[text()='Contact Us']")
	private WebElement contactPageVerify;

	@FindBy(id = "input-enquiry")
	private WebElement enqiuryTextField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	@FindBy(id = "input-name")
	private WebElement nameField;

	@FindBy(id = "input-email")
	private WebElement mailAddressField;

	@FindBy(xpath = "//div[text()='Name must be between 3 and 32 characters!']")
	private WebElement nameErrorMessage;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//div[text()='Enquiry must be between 10 and 3000 characters!']")
	private WebElement enquiryErrorMessage;

	public WebElement getNameErrorMessage() {
		return nameErrorMessage;
	}

	public void setNameErrorMessage(WebElement nameErrorMessage) {
		this.nameErrorMessage = nameErrorMessage;
	}

	public WebElement getEnquiryErrorMessage() {
		return enquiryErrorMessage;
	}

	public void setEnquiryErrorMessage(WebElement enquiryErrorMessage) {
		this.enquiryErrorMessage = enquiryErrorMessage;
	}

	public WebElement getEmailErrorMessage() {
		return emailErrorMessage;
	}

	public void setEmailErrorMessage(WebElement emailErrorMessage) {
		this.emailErrorMessage = emailErrorMessage;
	}

	public WebElement getNameField() {
		return nameField;
	}

	public void setNameField(WebElement nameField) {
		this.nameField = nameField;
	}

	public WebElement getMailAddressField() {
		return mailAddressField;
	}

	public void setMailAddressField(WebElement mailAddressField) {
		this.mailAddressField = mailAddressField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

	public WebElement getEnqiuryTextField() {
		return enqiuryTextField;
	}

	public void setEnqiuryTextField(WebElement enqiuryTextField) {
		this.enqiuryTextField = enqiuryTextField;
	}

	public WebElement getContactPageVerify() {
		return contactPageVerify;
	}

	public void setContactPageVerify(WebElement contactPageVerify) {
		this.contactPageVerify = contactPageVerify;
	}
}
