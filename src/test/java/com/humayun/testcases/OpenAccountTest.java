package com.humayun.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.humayun.base.BaseTest;
import com.humayun.utilities.TestUtils;

public class OpenAccountTest extends BaseTest {

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {

		if (!TestUtils.isTestRunnable("openAccountTest", excel)) {

			throw new SkipException("Skipping the test " + "openAccountTest".toUpperCase() + "as the Run mode is NO");
		}

		click("OpenAccount_CSS");
		select("Customer_CSS", data.get("Customer"));
		select("Currency_CSS", data.get("Currency"));
		click("Process_CSS");

		Thread.sleep(1000);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));

		alert.accept();

	}

}
