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
import com.training.pom.RETC_021_DeleteTagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class RETC_021_DeleteTag {

	private WebDriver driver1;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_021_DeleteTagPOM RETC_021_DeleteTagPOM;
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
		RETC_021_DeleteTagPOM = new RETC_021_DeleteTagPOM(driver1);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver1); 
		// open the browser 
		driver1.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver1.quit();
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		
		driver1.manage().window().maximize();
		
		// code for mouse over in posts

		Actions actions=new Actions(driver1);
		WebElement menuOption=driver1.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		
		WebDriver driver = null;
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// code for Tag selection
		
		Actions actions1=new Actions(driver1);
		driver1.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a]"));
		actions1.click();
		System.out.println("Tag is selected from Posts menu");
		
		// code for Tag selection check box for selected name cb-select-447
		
		WebElement Tagchk=driver1.findElement(By.id("cb-select-447"));
		for (int i=0;i<2;i++)
		Tagchk.click();
		System.out.println(Tagchk.isSelected());
		
		// code for Bulk action on selected name cb-select-447 and click on delete is selected
		
		Select Bulkact = new Select(driver1.findElement(By.id("bulk-action-selector-top")));
		Bulkact.selectByVisibleText("delete");
		
		// code for Apply to delete the selected name
		
		Actions Apply=new Actions(driver1);
		driver1.findElement(By.id("doaction"));
		Apply.click().perform();
		Assert.assertEquals("Tag", "selected tag should be removed from the tags list");
				
		screenShot.captureScreenShot("First");
	}

		
	}

