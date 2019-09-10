package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_024_AddNewUserPOM {
	private WebDriver driver; 
	
	public RETC_024_AddNewUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[18]/a/div[3]")
	private WebElement adduser; 
	
	@FindBy(xpath="\"//*[@id=\\\"menu-users\\\"]/ul/li[3]/a\"")
	private WebElement addnew; 
	
	
	public void createuserBtn() {
		this.adduser.click(); 
	}
}
