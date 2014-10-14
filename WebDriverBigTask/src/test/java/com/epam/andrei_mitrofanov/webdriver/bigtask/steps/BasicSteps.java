package com.epam.andrei_mitrofanov.webdriver.bigtask.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.andrei_mitrofanov.webdriver.bigtask.pages.EmailPage;
import com.epam.andrei_mitrofanov.webdriver.bigtask.pages.LoginPage;
import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.User;

public class BasicSteps 
{
	protected WebDriver driver;
	
	public BasicSteps(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void openBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void logInGmail(User user)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(user.getUserName(), user.getPassword());
	}
	
	public void sendMessage(User user)
	{
		EmailPage emailPage = new EmailPage(driver);
		emailPage.sendMail(user.getUserName());
	}
	
	public void sendMessageWithAttachment(User user) throws IOException, InterruptedException
	{
		EmailPage emailPage = new EmailPage(driver);
		emailPage.sendMailWithAttachment(user.getUserName());
	}
	
	
	
}
