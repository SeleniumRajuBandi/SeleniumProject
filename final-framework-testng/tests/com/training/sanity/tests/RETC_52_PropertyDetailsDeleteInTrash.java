package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_52_PropertyDetailsDeleteInTrash {
	private WebDriver driver; 
	private String baseUrl;
	private LoginPOM loginPOM;
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
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		loginPOM.clickPropertiesBtn();
		boolean displayed = loginPOM.clickAllPropertiesBtn().isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(displayed, true);
		boolean displayed2 = loginPOM.clickFeaturesBtn().isDisplayed();
		softAssert.assertEquals(displayed2, true);
		loginPOM.clickAllPropertiesBtn();
		boolean allPropertiesPageIsDisplayed = loginPOM.allPropertiesPageIsDisplayed();
		softAssert.assertEquals(allPropertiesPageIsDisplayed, true);
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.cssSelector("a.row-title"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		loginPOM.clickTrashBtn();
		loginPOM.clickTrashLink();	
		Actions actions1=new Actions(driver);
		WebElement menuOption1=driver.findElement(By.cssSelector("td.title.column-title.has-row-actions.column-primary.page-title"));
		actions1.moveToElement(menuOption1).perform();
		loginPOM.clickDeleteBtn();
		WebElement findElement = driver.findElement(By.cssSelector("div[id=\"message\"]"));
		boolean displayed3 = findElement.isDisplayed();
		softAssert.assertEquals(displayed, true);
	}
}