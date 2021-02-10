package com.humayun.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.humayun.utilities.MonitoringMail;
import com.humayun.utilities.TestConfig;

public class TestHostAdd {

	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {

//		String messageBody = "https://" + InetAddress.getLocalHost().getHostAddress()+ ":8080/job/DataDrivenFramework/HTML_20Report/";

		String messageBody = "https://" + InetAddress.getLocalHost().getHostAddress()+ ":8080/job/PageObjectModelBasics/HTML_20Report/";

		MonitoringMail mail = new MonitoringMail();
//		String messageBody = "https://drive.google.com/file/d/1ixJol2cp2PXTVG4xcaOHqnWX-v1cB-nM/view?usp=sharing";

		System.out.println(messageBody);

		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);

	}

}
