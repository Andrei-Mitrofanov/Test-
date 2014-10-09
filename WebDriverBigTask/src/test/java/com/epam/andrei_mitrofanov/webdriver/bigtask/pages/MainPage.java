package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://mail.google.com/mail/u/0/#inbox";
	private final String xpathForCheckingSpam = "//span[@email = 'mitrofanovuser1@gmail.com']";
	private WebDriverWait wait = new WebDriverWait(this.driver, 60);
	
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
	
	@FindBy(xpath = "//a[contains(.,'Spam')]")
	private WebElement spamFolderWithLetter;

	@FindBy(xpath = "//a[@class='gb_A gb_8 gb_f gb_2']")
	private WebElement openingSignOut;
	
	@FindBy(xpath = "//tr[contains(@class,'zA zE')][1]")
	private WebElement confirmationForwardMail;
	
	@FindBy(xpath = "//a[contains(@href,'https://isolated.mail.google.com/mail/')][1]")
	private WebElement confirmationLink;
	
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
		confirmationForwardMail.click();
		confirmationLink.click();
	}
	public void reportSpam()
	{
		wait.until(ExpectedConditions.visibilityOf(checkMail));
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
	public boolean tryToFindSpam()
	{
		if(driver.findElements(By.xpath(xpathForCheckingSpam)).size() > 1)
			return true;
		return false;
	}
	@Override
	public void openPage() 
	{
		driver.navigate().to(BASE_URL);
	}
	
}
