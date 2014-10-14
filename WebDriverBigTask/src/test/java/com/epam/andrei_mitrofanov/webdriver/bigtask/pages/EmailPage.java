package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.Email;
import com.epam.andrei_mitrofanov.webdriver.bigtask.utils.Utils;

public class EmailPage extends AbstractPage
{
	private Email mail;
	private WebDriverWait wait = new WebDriverWait(this.driver, 15);
	private String scriptPath = "c:\\Users\\Andrei_Mitrofanov\\Documents\\Fiddler2\\Scripts\\MyScript.exe";
	
	@FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
	private WebElement composeButton;
	
	@FindBy(css = "input.aoT")
	private WebElement textFieldSubject;
	
	@FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
	private WebElement sendButton;
	
	@FindBy(xpath = "//textarea[@class='vO'][@aria-label='To']")
	private WebElement textFieldUserPath;
	
	@FindBy(xpath = "//body[@class = 'editable LW-avf']")
	private WebElement textFieldMessage;
	
	@FindBy(xpath = "//div[@class = 'a1 aaA aMZ']")
	private WebElement attachFile;
	
	public EmailPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void sendMail(String userName)
	{
		mail = new Email(userName, Utils.getRandomString(5), Utils.getRandomString(15), null);
		composeButton.click();
		textFieldUserPath.sendKeys(mail.getUserTo());
		textFieldSubject.sendKeys(mail.getSubject());
		//this.driver.switchTo().frame(10);
		//textFieldMessage.sendKeys(mail.getBody());
		//this.driver.switchTo().parentFrame();
		sendButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your message')]")));
	}
	public void sendMailWithAttachment(String userName) throws IOException, InterruptedException
	{
		mail = new Email(userName, Utils.getRandomString(5), Utils.getRandomString(15), null);
		composeButton.click();
		textFieldUserPath.sendKeys(mail.getUserTo());
		textFieldSubject.sendKeys(mail.getSubject());
		//this.driver.switchTo().frame(10);
	    //textFieldMessage.sendKeys(mail.getBody());
		//this.driver.switchTo().parentFrame();
		Runtime.getRuntime().exec(scriptPath);
		Thread.sleep(3000);
		attachFile.click();
		Thread.sleep(5000);
		sendButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your message')]")));
	}
	@Override
	public void openPage()
	{
		throw new UnsupportedOperationException();
	}
}
