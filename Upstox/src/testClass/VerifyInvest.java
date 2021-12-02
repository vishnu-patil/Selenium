package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClass.HomePage;
import pomClass.InvestClass;
import pomClass.LogInClass;
import pomClass.LogOutClass;

public class VerifyInvest {

	private WebDriver driver;
	SoftAssert soft;
	LogInClass login;
	HomePage home;
	LogOutClass logout;
	InvestClass invest;
	String main;
	
	@BeforeClass
	public void lunchBrowser()
	{
		//System.out.println("Before Class");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://login-v2.upstox.com/?client_id=PW3-6Agd37PB52Q6B6DDpYWLuT7b&platform_id=PW3&redirect_path=%2F&redirect_uri=https%3A%2F%2Fpro.upstox.com");
	
	    main = driver.getWindowHandle();
		
	    soft = new SoftAssert();
		login = new LogInClass(driver);
		home = new HomePage(driver);
		logout = new LogOutClass(driver);
	    invest = new InvestClass(driver);
	}
	
	@BeforeMethod
	public void loginToupstox()
	{
		//System.out.println("Before Method");
		
		login.sendUid();
		login.sendPass();
		login.clickOnSignin();
		login.sendPin();
	}
	
	@Test
	public void verifyFund()
	{
		//System.out.println("Test");
		
		login.clickOnNo();
		invest.clickOnInvest();
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://invest.upstox.com/");
		/*
		 * if(url.equals("https://invest.upstox.com/")) { System.out.println("Pass"); }
		 * else { System.out.println("Fail"); }
		 */
		soft.assertAll();
		driver.close();
		driver.switchTo().window(main);
	}
	
	
	@AfterMethod
	public void logoutToupstox()
	{
		//System.out.println("After Method");
		
		logout.clickOnbtn();
		logout.clickOnLogout();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//System.out.println("After Class");
		
		driver.close();
	}
	
}
