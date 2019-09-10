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
import com.training.pom.RETC_023_DeleteUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class RETC_023_DeleteUser {

	private WebDriver driver1;
	private String baseUrl;
	private LoginPOM loginPOM;
	@SuppressWarnings("unused")
	private RETC_023_DeleteUserPOM RETC_023_DeleteUserPOM;
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
		RETC_023_DeleteUserPOM= new RETC_023_DeleteUserPOM(driver1);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver1); 
		// open the browser 
		driver1.get(baseUrl);
	
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
		
		// code for All users selections
		
		Actions actions1=new Actions(driver1);
		driver1.findElement(By.xpath("//*[@id=\"menu-users\"]/ul/li[2]/a]"));
		actions1.click();
		System.out.println("All Users is selected from Users menu");
		
		// code for selected check box for selected name user_204
		
		WebElement Usrchk=driver1.findElement(By.id("user_204"));
		for (int i=0;i<2;i++)
		Usrchk.click();
		System.out.println(Usrchk.isSelected());
		
		// code for Bulk action on selected name cb-select-447 and click on delete is selected
		
				Select Bulkact = new Select(driver1.findElement(By.id("bulk-action-selector-top")));
				Bulkact.selectByVisibleText("delete");
				
				// code for Apply to delete the selected name
				
				Actions Apply=new Actions(driver1);
				driver1.findElement(By.id("doaction"));
				Apply.click().perform();
				System.out.println("User");
		
				// code for Apply on clicking the Confirm Delete button
		
		Actions Submit=new Actions(driver1);
		driver1.findElement(By.id("submit"));
		Submit.click().perform();
		Assert.assertEquals("User", "User Deleted successfully");
				
		screenShot.captureScreenShot("First");
	
	}
	}

	
