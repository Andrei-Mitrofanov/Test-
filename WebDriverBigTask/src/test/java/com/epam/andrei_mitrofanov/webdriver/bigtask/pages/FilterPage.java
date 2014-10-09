package com.epam.andrei_mitrofanov.webdriver.bigtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPage extends AbstractPage
{
	@FindBy(css = "input.ZH.nr.aQa")
	private WebElement filterFieldFrom;
	
	@FindBy(xpath = "//a[contains(@href,'/filters')]")
	private WebElement filtersTab;
	
	@FindBy(xpath = "//span[contains(text(),'Create a new filter')]")
	private WebElement createNewFilter;
	
	@FindBy(xpath = "//span[contains(@class,'w-Pv ZG')]/input[@type='checkbox']")
	private WebElement filterFieldHasAttachment;
	
	@FindBy(xpath = "//div[contains(text(),'Create filter with this search »')]")
	private WebElement createNewFilterWithThisSearch;
	
	@FindBy(xpath = "//div[contains(label/text(),'Delete it')]/input[@type='checkbox']")
	private WebElement filterFieldDeleteIt;
	
	@FindBy(xpath = "//div[contains(label/text(),'Always mark it as important')]/input[@type='checkbox']")
	private WebElement filterFieldAlwaysMarkAsImportant;
	
	@FindBy(css = "div.T-I.J-J5-Ji.Zx.acL.T-I-atl.L3")
	private WebElement createNewFilterButton;
	
	public FilterPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	/*Creating filter with next options:
	 * 1. From user named 'userName'
	 * 2. Has attachment - yes
	 * 3. Delete it - yes
	 * 4. Always mark as important - yes
	 */
	public void createFilter(String userName)
	{
		filtersTab.click();
		createNewFilter.click();
		filterFieldFrom.sendKeys(userName);
		filterFieldHasAttachment.click();
		createNewFilterWithThisSearch.click();
		filterFieldDeleteIt.click();
		filterFieldAlwaysMarkAsImportant.click();
		createNewFilterButton.click();
	}
	
	@Override
	public void openPage() 
	{
		throw new UnsupportedOperationException();	
	}
}
