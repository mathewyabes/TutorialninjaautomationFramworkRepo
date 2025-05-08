package com.tutorialsninja.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;

	public static String generateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		String email = "mathew" + timeStamp + "@gmail.com";
		return email;
	}

	public static String captureScreenshot(WebDriver driver, String testName) {
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots" + testName + ".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(screenShot, new File(destinationScreenshotPath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destinationScreenshotPath;

	}

}
