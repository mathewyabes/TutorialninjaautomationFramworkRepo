package com.tutorialsninja.listener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.utils.ExtentReporter;
import com.tutorialsninja.utils.Utilities;

public class Listeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + "Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + "got Successfully excecuted");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Screenshot Taken");

		WebDriver driver = null;
		try {
			Object testClassInstance = result.getInstance();
			Field field = testClassInstance.getClass().getDeclaredField("driver");
			field.setAccessible(true);
			driver = (WebDriver) field.get(testClassInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (driver != null) {
			String destinationScreenshotPath = Utilities.captureScreenshot(driver, result.getName());

			try {
				extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Driver is null; Screenshot is not taken");
		}
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + "got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + "got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathofExtentReports = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathofExtentReports);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
