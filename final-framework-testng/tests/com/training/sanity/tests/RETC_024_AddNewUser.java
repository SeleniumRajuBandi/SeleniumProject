package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_024_AddNewUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class RETC_024_AddNewUser {

	private WebDriver driver1;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_024_AddNewUserPOM RETC_024_AddNewUserPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver1 = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver1);
		setRETC_024_AddNewUserPOM(new RETC_024_AddNewUserPOM(driver1));
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver1); 
		// open the browser 
		driver1.get(baseUrl);
	}
	
	private void setRETC_024_AddNewUserPOM(com.training.pom.RETC_024_AddNewUserPOM retc_024_AddNewUserPOM2) {
		// TODO Auto-generated method stub
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver1.quit();
		
		WebDriver driver = null;
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		
		driver1.manage().window().maximize();
		
		// code for mouse over on Users

		Actions actions=new Actions(driver1);
		WebElement menuOption=driver1.findElement(By.xpath("//*[@id=\"menu-users\"]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on Users from menu");
		
		// code for Add new user selections
		
		Actions actions1=new Actions(driver1);
		driver1.findElement(By.xpath("//*[@id=\"menu-users\"]/ul/li[3]/a"));
		actions1.click().perform();
		System.out.println("Add new User is selected from Users menu");
		Assert.assertEquals("User", "Add new User selected successfully");
					
		screenShot.captureScreenShot("First");
	
	}
	}

	
