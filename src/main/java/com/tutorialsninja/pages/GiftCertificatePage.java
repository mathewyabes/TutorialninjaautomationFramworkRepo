package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCertificatePage {

	@FindBy(xpath = "//h1[text()='Purchase a Gift Certificate']")
	private WebElement giftPageCheckup;

	public WebElement getGiftPageCheckup() {
		return giftPageCheckup;
	}

	public void setGiftPageCheckup(WebElement giftPageCheckup) {
		this.giftPageCheckup = giftPageCheckup;
	}
}
