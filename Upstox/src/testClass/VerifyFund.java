package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClass.HomePage;
import pomClass.LogInClass;
import pomClass.LogOutClass;

public class VerifyFund {

	private WebDriver driver;
	LogInClass login;
	HomePage home;
	LogOutClass logout;
	
	@BeforeClass
	public void lunchBrowser()
	{
		//System.out.println("Before Class");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://login-v2.upstox.com/?client_id=PW3-6Agd37PB52Q6B6DDpYWLuT7b&platform_id=PW3&redirect_path=%2F&redirect_uri=https%3A%2F%2Fpro.upstox.com");
	
		login = new LogInClass(driver);
		home = new HomePage(driver);
		logout = new LogOutClass(driver);
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
		home.clickOnFund();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://pro.upstox.com/funds/commodities");
		
		
		
		/*
		 * if(url.equals("https://pro.upstox.com/funds/commodities")) {
		 * System.out.println("Pass"); } else { System.out.println("Fail"); }
		 */
		
	}
	
	@Test 
	public void verifyHistory()
	{
		//System.out.println("Test 1");
		
		home.clickOnHistory();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://pro.upstox.com/price-alerts/history");
		/*
		 * if(url.equals("https://pro.upstox.com/price-alerts/history")) {
		 * System.out.println("Pass"); } else { System.out.println("Fail"); }
		 */
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
