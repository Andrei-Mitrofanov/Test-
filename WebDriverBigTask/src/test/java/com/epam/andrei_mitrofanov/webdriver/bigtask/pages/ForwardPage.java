package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForwardPage extends AbstractPage
{
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
	
	@FindBy(xpath = "")
	private WebElement radioButtonForward;
	
	@FindBy(xpath = "//button[@guidedhelpid='save_changes_button']")
	private WebElement saveChangesButton;
	
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
		radioButtonForward.click();
		saveChangesButton.click();
	}
	@Override
	public void openPage() 
	{
		throw new UnsupportedOperationException();	
	}
}
