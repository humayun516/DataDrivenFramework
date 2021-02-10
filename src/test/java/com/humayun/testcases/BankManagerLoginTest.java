package com.humayun.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.humayun.base.BaseTest;

public class BankManagerLoginTest extends BaseTest {

	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {

		verifyEquals("abc", "xyz");
		Thread.sleep(1000);

		log.debug("Inside Login Test");
		click("BankManagerLoginButton_CSS");
		// driver.findElement(By.cssSelector(OR.getProperty("BankManagerLoginButton"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("AddCustomerButton_CSS"))),
				"Login Not Successfully");

		log.debug("Login Test successfully Executed");

		Reporter.log("Login Test successfully Executed");

//		Assert.fail("Login test not successful");
	}

}
