package com.humayun.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			// directory where output is to be printed

			ExtentSparkReporter avent = new ExtentSparkReporter(
					System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\Extent.html");
			extent = new ExtentReports();
			extent.attachReporter(avent);
			
				try {
					avent.loadXMLConfig(
							System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\ReportsConfig.xml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		}
		return extent;

	}

}
