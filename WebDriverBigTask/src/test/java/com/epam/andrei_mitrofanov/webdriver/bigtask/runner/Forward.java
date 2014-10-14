package com.epam.andrei_mitrofanov.webdriver.bigtask.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.andrei_mitrofanov.webdriver.bigtask.steps.StepsForForward;
import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.User;

public class Forward
{
	private StepsForForward steps;
	private WebDriver driver;
	
	private User user1 = User.USER_1;
	private User user2 = User.USER_2;
	private User user3 = User.USER_3;

	@BeforeClass
	public void startBrowser()
	{
		steps = new StepsForForward(driver);
		steps.openBrowser();
	}
	@Test
	public void OneCanUseFilterToOperateWithIncomingMails() throws InterruptedException, IOException
	{
		steps.logInGmail(user2);
		steps.addToCurrentUserForwardPageFromForwardUser(user3);
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user3);
		steps.confirmForwardMail();
		Thread.sleep(3000);
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user2);
		steps.acceptForwardAdress();
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user2);
		steps.createNewFilterForSomeUser(user1);
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user1);
		steps.sendMessageWithAttachment(user2);
		steps.sendMessage(user2);
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user2);
		Assert.assertFalse(steps.checkImportantMailWithAttachment(user1));
		Assert.assertTrue(steps.checkMailWithoutAttachment(user1));
	}
	@Test
	public void UserCanCheckInboxAndFindForwardMail()
	{
		steps.closeBrowser();
		steps.openBrowser();
		steps.logInGmail(user3);
		Assert.assertTrue(steps.checkMailWithoutAttachment(user1));
	}
	@AfterClass
	public void stopBrowser()
	{
		steps.disableForwardAdressAndDeleteFilter();
		steps.closeBrowser();
	}
}
