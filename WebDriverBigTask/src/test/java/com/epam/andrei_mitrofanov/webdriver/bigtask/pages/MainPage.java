package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://mail.google.com/mail/u/0/#inbox";
	private final String xpathForCheckingSpam = "//span[@email = 'mitrofanovuser1@gmail.com']";
	//private WebDriverWait wait = new WebDriverWait(this.driver, 30);
	
	@FindBy(id = "gb_71")
	private WebElement buttonSignOut;
	
	@FindBy(id = "ms")
	private WebElement settingsField;
	
	@FindBy(xpath = "//span[@class = 'zF']")
	private WebElement checkMail;
	
	@FindBy(css = "div.oZ-jc.T-Jo.J-J5-Ji")
	private WebElement selectMail;

	@FindBy(css = "div.asl.T-I-J3.J-J5-Ji")
	private WebElement reportSpamButton;
	
	@FindBy(css = "span.CJ")
	private WebElement buttonNamedMore;
	
	@FindBy(css = "div.T-I.J-J5-Ji.ash.T-I-ax7.L3")
	private WebElement settingsButton;
	
	@FindBy(css = "div.ar9.T-I-J3.J-J5-Ji")
	private WebElement deleteAllMails;
	
	@FindBy(xpath = "//div[@gh = 'tm']//div[@aria-label = 'Select']//div[@role = 'presentation']")
	private WebElement selectAll;
	
	@FindBy(xpath = "//div[text() = 'Not spam']")
	private WebElement notSpamButton;

	@FindBy(xpath = "//a[contains(.,'Spam')]")
	private WebElement spamFolderWithLetter;

	@FindBy(xpath = "//a[@class = 'gb_A gb_8 gb_f gb_2']")
	private WebElement openingSignOut;
	
	@FindBy(xpath = "//tr[@class = 'zA zE'][1]")
	private WebElement firstMailInbox;
	
	@FindBy(xpath = "//a[contains(@href,'https://isolated.mail.google.com/mail/')][1]")
	private WebElement confirmationLink;
	
	@FindBy(xpath = "//a[@class='J-Ke n0'][text()='Bin']")
	private WebElement trashFolder;
	
	@FindBy(xpath = "//tr[@class = 'zA zE'][1]/td[@class = 'WA xY']/div")
	private WebElement importantMail;
	
	@FindBy(xpath = "//tr[@class = 'zA zE'][1]/td[@class = 'yf xY ']/img")
	private WebElement mailWithAttachment;
	
	public MainPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	public void goToSettings()
	{
		settingsButton.click();
		settingsField.click();
	}
	public void confirmForwardSettings()
	{
		firstMailInbox.click();
		confirmationLink.click();
	}
	public void selectAllMailsAsNotSpam()
	{
		selectAll.click();
		notSpamButton.click();
	}
	public void reportSpam()
	{
		if(checkMail.getAttribute("email").equals("mitrofanovuser1@gmail.com"))
		{
			selectMail.click();
		}	
		reportSpamButton.click();		
	}
	public void logout()
	{
		openingSignOut.click();
		buttonSignOut.click();
	}
	public void goToFolderSpam()
	{
		buttonNamedMore.click();
		spamFolderWithLetter.click();
	}
	public void goToTrash()
	{
		buttonNamedMore.click();
		trashFolder.click();
	}
	public void waitForMail()
	{
		try
		{
			if(checkMail.isDisplayed()){}
		}
		catch(Exception e)
		{
			if(e instanceof ElementNotVisibleException || e instanceof NoSuchElementException)
			{
				this.driver.navigate().refresh();
				this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				waitForMail();
			}
		}
	}
	public boolean tryToFindSpam()
	{
		if(driver.findElements(By.xpath(xpathForCheckingSpam)).size() > 1)
			return true;
		return false;
	}
	public boolean tryToFindImportantMailFromCurrentUser(String userName)
	{
		if(checkMail.getAttribute("email").equals(userName))
		{
			if(importantMail.getAttribute("aria-label").equals("Important because it matched one of your importance filters."))
			{
				return true;
			}
		}	
		return false;
	}
	public boolean tryToFindMailWithAttachmentFromCurrentUser(String userName)
	{
		if(checkMail.getAttribute("email").equals(userName))
		{
			if(mailWithAttachment.getAttribute("alt").equals("Attachment"))
			{
				return true;
			}
		}	
		return false;
	}
	@Override
	public void openPage() 
	{
		driver.navigate().to(BASE_URL);
	}
	
}
