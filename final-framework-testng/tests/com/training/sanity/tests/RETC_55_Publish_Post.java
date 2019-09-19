package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class RETC_55_Publish_Post {
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
	driver.manage().window().maximize();
	// code for mouse over in posts
	Actions actions=new Actions(driver);
	WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
	actions.moveToElement(menuOption).perform();
	System.out.println("Done Mouse over on posts from menu");
	//code to click on Add New posts
loginPOM.clickAllBtn();
	//Code for Click on Add new Feature link in Feature section
	loginPOM.clickAddnewLnk();
			//Code for Refresh button from keyboard
		driver.findElement(By.xpath("//input[@id='region-add-submit']")).sendKeys(Keys.F5);
			// Code for enter valid details in Textbox
		loginPOM.sendTextvalue("Plots");
			// Code for Select valid details in Parent Region list box
			 Select regionDropDown=new Select(driver.findElement(By.xpath("//select[@id='newregion_parent']")));
		     regionDropDown.selectByVisibleText("Commercial");
		  // Code for Select valid details in Parent Region list box
		     ((LoginPOM) loginPOM).clickaAdnewRegion1();
		   //Enter valid credentials in Enter Title Here textbox
		     loginPOM.sendName("Vihar");
			//Enter valid credentials in textbox
				loginPOM.sendContent(" New Launch in Plots");
			// Click on checkbox beside created Region
				WebElement checkBox1 = driver.findElement(By.xpath("//li[@id='region-524']//label[@class='selectit'][contains(text(),'Electronic city')]"));
				checkBox1.click();
				System.out.println("Input value selected");
			// code for scroll bar up
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-300)");
				//Click on Publish button
				Thread.sleep(5000);
				//WebDriverWait wait=new WebDriverWait(driver,20);

				//WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='publish']")));

				loginPOM.clickPublishBtn();

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				String message = driver.findElement(By.xpath("//p[contains(text(),'Post published.')]")).getText();

				Assert.assertTrue(message.contains("Post published"));

				System.out.println("The test case is passed");
	screenShot.captureScreenShot("Third");

}
}
