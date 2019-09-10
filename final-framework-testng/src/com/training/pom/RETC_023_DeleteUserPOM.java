package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_023_DeleteUserPOM {
	private static final String deleteBtn = null;
	private WebDriver driver; 
	
	public RETC_023_DeleteUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="submit")
	private WebElement deletebtn;
	private Object DeleteUser; 
	
		public void clickdeleteBtn() {
				((WebElement) this.DeleteUser).click();
	}
}
