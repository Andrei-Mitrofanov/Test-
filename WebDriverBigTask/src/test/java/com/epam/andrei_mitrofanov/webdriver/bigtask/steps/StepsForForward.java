package com.epam.andrei_mitrofanov.webdriver.bigtask.steps;

import org.openqa.selenium.WebDriver;

import com.epam.andrei_mitrofanov.webdriver.bigtask.pages.FilterPage;
import com.epam.andrei_mitrofanov.webdriver.bigtask.pages.ForwardPage;
import com.epam.andrei_mitrofanov.webdriver.bigtask.pages.MainPage;
import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.User;

public class StepsForForward extends BasicSteps
{
	public StepsForForward(WebDriver driver)
	{
		super(driver);
	}
	public void addToCurrentUserForwardPageFromForwardUser(User forwardUser)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.goToSettings();
		ForwardPage forwardPage = new ForwardPage(driver);
		forwardPage.addForwardAddress(forwardUser.getUserName());
	}
	public void createNewFilterForSomeUser(User someUser)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.goToSettings();
		FilterPage filterPage = new FilterPage(driver);
		filterPage.createFilter(someUser.getUserName());
	}
	public void accetpForwardAdress()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.goToSettings();
		ForwardPage forwardPage = new ForwardPage(driver);
		forwardPage.acceptForwardAdress();
	}
	public void confirmForwardMail()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.confirmForwardSettings();
	}

}
