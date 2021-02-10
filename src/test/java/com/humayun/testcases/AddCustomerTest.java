package com.humayun.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.humayun.base.BaseTest;
import com.humayun.utilities.TestUtils;

public class AddCustomerTest extends BaseTest {

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

		if (!(data.get("Runmode").equals("Y"))) {
			throw new SkipException("Skipp the test case as the run mode data set is NO ");
		}

		click("AddCustomerButton_CSS");
		type("firstname_CSS", data.get("firstname"));
		type("lastname_XPATH", data.get("lastname"));
		type("postcode_CSS", data.get("postcode"));
		click("addbutton_CSS");

		Thread.sleep(1000);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));

		alert.accept();
		Thread.sleep(1000);

//		Assert.fail("Customer not added successfully");
	}

}
