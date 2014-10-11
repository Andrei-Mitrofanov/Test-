package com.epam.andrei_mitrofanov.webdriver.bigtask.steps;

import org.openqa.selenium.WebDriver;

import com.epam.andrei_mitrofanov.webdriver.bigtask.pages.MainPage;

public class StepsForSpam extends BasicSteps
{

	public StepsForSpam(WebDriver driver) 
	{
		super(driver);
	}
	
	public boolean checkSpamMail()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.goToFolderSpam();
		if(mainPage.tryToFindSpam())
			return true;
		return false;
	}
	public void selectSpamMail()
	{
		MainPage mainPage = new MainPage(this.driver);
		mainPage.waitForMail();
		mainPage.reportSpam();
	}
	public void deleteSpamMails() 
	{
		MainPage mainPage = new MainPage(this.driver);
		mainPage.selectAllMailsAsNotSpam();

	}

}
