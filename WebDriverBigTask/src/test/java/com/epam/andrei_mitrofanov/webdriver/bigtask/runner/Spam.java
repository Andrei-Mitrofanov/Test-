package com.epam.andrei_mitrofanov.webdriver.bigtask.runner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.andrei_mitrofanov.webdriver.bigtask.steps.StepsForSpam;
import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.User;

public class Spam 
{
	private StepsForSpam steps;
	private WebDriver driver;
	
	private User user1 = User.USER_1;
	private User user2 = User.USER_2;

	@BeforeTest
	public void startBrowser()
	{
		steps = new StepsForSpam(driver);
		steps.openBrowser();
	}
	@Test
	public void oneCanSendMailAndCheckItAsSpam() 
	{
		steps.logInGmail(user1);
		steps.sendMessage(user2);
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user2);
		steps.selectSpamMail();
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user1);
		steps.sendMessage(user2);
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user2);
		Assert.assertTrue(steps.checkSpamMail());	
	}
	@AfterTest
	public void stopBrowser()
	{
		steps.deleteSpamMails();
		steps.closeBrowser();
	}
}
