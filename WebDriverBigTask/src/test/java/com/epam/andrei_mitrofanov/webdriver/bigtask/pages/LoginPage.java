package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage 
{

	private final String BASE_URL = "http://gmail.com";
	//private WebDriverWait wait = new WebDriverWait(this.driver, 10);
	
	@FindBy(id = "Email")
	private WebElement textFieldForEmail;
	
	@FindBy(id = "Passwd")
	private WebElement textFieldForPassword;
	
	@FindBy(id = "signIn")
	private WebElement buttonSignIn;
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	public void login(String userName, String password)
	{
		textFieldForEmail.sendKeys(userName);
		textFieldForPassword.sendKeys(password);
		buttonSignIn.click();
	}
	
	@Override
	public void openPage() 
	{
		driver.navigate().to(BASE_URL);
	}

}
