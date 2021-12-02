package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath="//a[contains(text(),'Funds')]")
	private WebElement fund;
	
	@FindBy (xpath="//span[contains(text(),'Withdrawals')]")
	private WebElement withdraw;
	
	@FindBy (xpath="//a[@data-id='alertsHistoryLink']")
	private WebElement history;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFund()
	{
		fund.click();
	}
	
	public void clickOnWithdraw()
	{
		withdraw.click();
	}
	
	public void clickOnHistory()
	{
		history.click();
	}
	
}
