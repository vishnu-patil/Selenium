package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClass.HomePage;
import pomClass.InvestClass;
import pomClass.LogInClass;
import pomClass.LogOutClass;

public class TestClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://login-v2.upstox.com/?client_id=PW3-6Agd37PB52Q6B6DDpYWLuT7b&platform_id=PW3&redirect_path=%2F&redirect_uri=https%3A%2F%2Fpro.upstox.com");
	
		LogInClass login = new LogInClass(driver);
		login.sendUid();
		login.sendPass();
		login.clickOnSignin();
		login.sendPin();
		login.clickOnNo();
		
		HomePage home = new HomePage(driver);
		home.clickOnFund();
		home.clickOnHistory();
		
		InvestClass invest = new InvestClass(driver);
		invest.clickOnInvest();
		
		LogOutClass logout = new LogOutClass(driver);
		logout.clickOnbtn();
		logout.clickOnLogout();
	}

}
