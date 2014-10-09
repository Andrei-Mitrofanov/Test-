package com.epam.andrei_mitrofanov.webdriver.bigtask.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

	@BeforeTest
	public void startBrowser()
	{
		steps = new StepsForForward(driver);
		steps.openBrowser();
	}
	@Test()
	public void test() throws InterruptedException
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
		steps.accetpForwardAdress();
		//steps.createNewFilterForSomeUser(user1);
	}
	@AfterTest
	public void stopBrowser()
	{
		steps.closeBrowser();
	}
}
