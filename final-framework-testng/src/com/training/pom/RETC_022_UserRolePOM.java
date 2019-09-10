package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_022_UserRolePOM {
	private WebDriver driver; 
	
	public RETC_022_UserRolePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[1]/div[3]/form/table/tbody/tr[6]/td[1]/div/span[1]")
	private WebElement edit;
	
	@FindBy(id="role")
	private WebElement editrole;
	

	
	public void clickedit() {
		this.editrole.click(); 
	}
}
