package pomClass;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvestClass {

	private WebDriver driver;
	Actions act;
	
	@FindBy (xpath="//a[@id='invest']")
	private WebElement invest;
	
	@FindBy (xpath="//a[contains(text(),'Investing options')]")
	private WebElement option;
	
	@FindBy (xpath="(//div[contains(text(),'Mutual Funds')])[1]")
	private WebElement MF;
	
	public InvestClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void clickOnInvest()
	{
		invest.click();
		ArrayList<String> adder = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(adder.get(1));
	}
	
	public void clickOnOption()
	{
		act.moveToElement(option).build().perform();
	}
	
	public void clickOnMF()
	{
		act.moveToElement(MF).click().build().perform();
	}
	
}
