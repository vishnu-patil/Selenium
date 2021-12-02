package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutClass {

	@FindBy (xpath="//main[@id='root']//div[@data-id='accountDropDown']")
	private WebElement button;
	
	@FindBy (xpath="//div[@class='_3lR99YHaGZeUmBmnU1RxVq _1xqx3CjCL4UXo8nsKNIVG_ _2LrieZttkTs1roJ9x76Cu2 lnucrNTwqIYUtuuV2KYHt']")
	private WebElement logout;
	
	public LogOutClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnbtn()
	{
		button.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
}
