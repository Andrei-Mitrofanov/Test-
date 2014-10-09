package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.Email;
import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.Utils;

public class EmailPage extends AbstractPage
{
	private Email mail;
	
	@FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
	private WebElement composeButton;
	
	@FindBy(css = "input.aoT")
	private WebElement textFieldSubject;
	
	@FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
	private WebElement sendButton;
	
	@FindBy(css = "textarea.vO")
	private WebElement textFieldUserPath;
	
	@FindBy(xpath = "//body[contains(@class,'editable LW-avf')]")
	private WebElement textFieldMessage;
	
	public EmailPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void sendMail(String userName)
	{
		mail = new Email(userName, Utils.getRandomString(5), Utils.getRandomString(15));
		composeButton.click();
		textFieldUserPath.sendKeys(mail.getUserTo());
		textFieldSubject.sendKeys(mail.getSubject());
		this.driver.switchTo().frame(10);
		textFieldMessage.sendKeys(mail.getBody());
		this.driver.switchTo().parentFrame();
		sendButton.click();
	}
	@Override
	public void openPage()
	{
		throw new UnsupportedOperationException();
	}
}
