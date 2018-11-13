package com.selenium.AutomationTesting;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import testData.PageObjects;

public class MavenTest {
	public WebDriver driver=null;
	
	@Test
	public void loginAndTransact() throws IOException{
		
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Workspace\\AutomationTesting\\src\\test\\java\\testData\\variables.properties");
		property.load(fis);
		if(property.getProperty("browser").equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C://Users//z003srvt.AD001//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(property.get("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C://Users//z003srvt.AD001//Downloads//geckodriver-v0.23.0-win64//geckodriver.exe");
			driver = new FirefoxDriver();
		}
//		else if(property.get("browser").equals("ie")){
//			System.setProperty("webdriver.ie.driver","C://Users//z003srvt.AD001//Downloads//MicrosoftWebDriver.exe");
//			driver = new InternetExplorerDriver();
//		}
		PageObjects po = new PageObjects(driver);
		driver.get(property.getProperty("siteURL"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		po.signIn().click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		po.emailId().sendKeys(property.getProperty("emailId"));
		po.password().sendKeys(property.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		po.loginButton().click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		po.searchBox().sendKeys(property.getProperty("searchText"));
		po.searchButton().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		po.signOut().click();
	}

	@Test
	public void loginFailure() throws IOException{
		
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Workspace\\AutomationTesting\\src\\test\\java\\testData\\variables.properties");
		property.load(fis);
		System.setProperty("webdriver.chrome.driver", "C://Users//z003srvt.AD001//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		PageObjects po = new PageObjects(driver);
		driver.get(property.getProperty("siteURL"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		po.signIn().click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		po.emailId().sendKeys(property.getProperty("emailId"));
		po.password().sendKeys(property.getProperty("invalidPassword"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		po.loginButton().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertFalse(po.signOut().isDisplayed());
		}
	
	@AfterMethod
	public void browserQuit(){
		driver.quit();
	}
	}

