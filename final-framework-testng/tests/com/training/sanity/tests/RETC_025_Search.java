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
import com.training.pom.RETC_025_SearchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class RETC_025_Search {

	private WebDriver driver1;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_025_SearchPOM RETC_025_SearchPOM;
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
		setRETC_025_SearchPOM(new RETC_025_SearchPOM(driver1));
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver1); 
		// open the browser 
		driver1.get(baseUrl);
	}
	
	private void setRETC_025_SearchPOM(com.training.pom.RETC_025_SearchPOM retc_025_SearchPOM2) {
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
		
		// code for mouse over on Properties

		Actions actions=new Actions(driver1);
		WebElement menuOption=driver1.findElement(By.xpath("//*[@id=\"menu-posts-property\"]/a/div[3]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on Properties from menu");
		
		// code for All Properties selections
		
		Actions actions1=new Actions(driver1);
		driver1.findElement(By.xpath("//*[@id=\"menu-posts-property\"]/ul/li[2]/a"));
		actions1.click();
		System.out.println("All Propertyon the Properties from menu");
				
		// code for Date selections
		
				Actions dts1=new Actions(driver1);
				Select datess = new Select (driver1.findElement(By.id("filter-by-date")));
				datess.selectByVisibleText("201803");
				datess.selectByIndex(5);
				
				// code for Filter Button
				
				Actions Filterbtn=new Actions(driver1);
				driver1.findElement(By.id("post-query-submit"));
				Filterbtn.click().perform();
				Assert.assertEquals("Properties", "Matching successfully");

				screenShot.captureScreenShot("First");
	
	}
	}

	
