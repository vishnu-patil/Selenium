package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInClass {

	@FindBy (xpath="//input[@id='userCode']")
	private WebElement UID;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement PASS;
	
	@FindBy (xpath="//button[@id='submit-btn']")
	private WebElement signin;
	
	@FindBy (xpath="//input[@id='yob']")
	private WebElement pin;
	
	@FindBy (xpath="//button[@data-id='declineTour']")
	private WebElement no;
	
	@FindBy (xpath="//a[@data-id='alertsHistoryLink']")
	private WebElement history;
	
	public LogInClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUid()
	{
		UID.sendKeys("BY8655");
	}
	
	public void sendPass()
	{
		PASS.sendKeys("Patil@123");
	}
	
	public void clickOnSignin()
	{
		signin.click();
	}
	
	public void sendPin()
	{
		pin.sendKeys("1965");
	}
	
	public void clickOnNo()
	{
		boolean tap = no.isDisplayed();
		if(tap == true)
		{
			no.click();
		}
		else
		{
			history.click();
		}
	}
}
