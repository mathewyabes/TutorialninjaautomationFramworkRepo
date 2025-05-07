package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		ExtentReports extentreport = new ExtentReports();
		File extenReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extenReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorialsninja automation Results Report");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		extentreport.attachReporter(sparkReporter);

		Properties prop = new Properties();
		File propfile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\config\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		extentreport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentreport.setSystemInfo("BrowserName", prop.getProperty("browserName"));
		extentreport.setSystemInfo("Email", prop.getProperty("validUserName"));
		extentreport.setSystemInfo("Password", prop.getProperty("validPassword"));
		extentreport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreport.setSystemInfo("Username", System.getProperty("user.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentreport;
	}

}
