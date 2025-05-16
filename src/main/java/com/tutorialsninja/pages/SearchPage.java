package com.tutorialsninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-default btn-lg']")
	private WebElement searchIcon;

	@FindBy(linkText = "iMac")
	private WebElement productDetails;

	@FindBy(xpath = "//p[contains(text(), 'no product')]")
	private WebElement noMatchesProduct;

	public WebElement getNoMatchesProduct() {
		return noMatchesProduct;
	}

	public void setNoMatchesProduct(WebElement noMatchesProduct) {
		this.noMatchesProduct = noMatchesProduct;
	}

	public WebElement getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(WebElement productDetails) {
		this.productDetails = productDetails;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(WebElement searchBox) {
		this.searchBox = searchBox;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public void setSearchIcon(WebElement searchIcon) {
		this.searchIcon = searchIcon;
	}

}
