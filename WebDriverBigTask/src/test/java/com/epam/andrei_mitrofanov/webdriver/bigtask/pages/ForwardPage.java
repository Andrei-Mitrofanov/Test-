package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForwardPage extends AbstractPage
{
	private WebDriverWait wait = new WebDriverWait(this.driver, 30);
	
	@FindBy(css = "iframe.ds")
	private WebElement iframe;
	
	@FindBy(css = "button.J-at1-auR")
	private WebElement confirmationButton;
	
	@FindBy(xpath = "//a[contains(@href,'/fwdandpop')]")
	private WebElement forwardingTab;
	
	@FindBy(xpath = "//input[contains(@value,'Add')]")
	private WebElement addForwardingAddress;
	
	@FindBy(xpath = "//input[@type='text'][@size='48']")
	private WebElement fieldForForwardAdress;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Proceed']")
	private WebElement buttonNamedAsProceed;
	
	@FindBy(xpath = "//button[@name='ok']")
	private WebElement confirmationButtonOk;
	
	@FindBy(xpath = "//span[contains(text(),'Forward a')]/../..//input[@type='radio']")
	private WebElement radioButtonForwardACopyOfIncomingMail;
	
	@FindBy(xpath = "//span[contains(text(),'Disable forwarding')]/../..//input[@type='radio']")
	private WebElement radioButtonDisableForwarding;
	
	@FindBy(xpath = "//div[@class='nH Tv1JD']//button[@guidedhelpid='save_changes_button']")
	private WebElement saveChangesButton;
	
	@FindBy(xpath = "//div[contains(text(),'You are forwarding your email to')]")
	private WebElement confirmationText;
	
	public ForwardPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void addForwardAddress(String userName)
	{
		forwardingTab.click();
		addForwardingAddress.click();
		fieldForForwardAdress.sendKeys(userName);
		confirmationButton.click();
		this.driver.switchTo().frame(iframe);
		buttonNamedAsProceed.click();
		this.driver.switchTo().parentFrame();
		confirmationButtonOk.click();
	}
	public void acceptForwardAdress() 
	{
		forwardingTab.click();
		radioButtonForwardACopyOfIncomingMail.click();
		saveChangesButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You are')]")));
	}
	public void disableForwardAdress()
	{
		forwardingTab.click();
		radioButtonDisableForwarding.click();
		saveChangesButton.click();
		this.driver.navigate().refresh();
	}
	@Override
	public void openPage() 
	{
		throw new UnsupportedOperationException();	
	}
}
