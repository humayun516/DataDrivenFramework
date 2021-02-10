package com.humayun.listeners;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.humayun.base.BaseTest;
import com.humayun.utilities.MonitoringMail;
import com.humayun.utilities.TestConfig;
import com.humayun.utilities.TestUtils;

public class CustomListeners extends BaseTest implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {

		test = rep.createTest(result.getName().toUpperCase());

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getName().toUpperCase() + "PASS");

		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + TestUtils.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtils.screenshotName + "><img src=" + TestUtils.screenshotName
				+ " height=200 width=200></img></a>");

		test.log(Status.FAIL, result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
		test.addScreenCaptureFromPath(TestUtils.screenshotName);
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getName().toUpperCase() + " skipped the test as the Run mode is NO");
		rep.flush();
//	
//		if (!TestUtils.isTestRunnable(result.getName(), excel));
//		throw new SkipException("Skipping the test" + result.getName().toUpperCase() + " as the Runmode is NO");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	@Override
	public void onStart(ISuite suite) {

	}

	@Override
	public void onFinish(ISuite suite) {
		MonitoringMail mail = new MonitoringMail();
		String messageBody = "https://drive.google.com/file/d/1ixJol2cp2PXTVG4xcaOHqnWX-v1cB-nM/view?usp=sharing";

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
