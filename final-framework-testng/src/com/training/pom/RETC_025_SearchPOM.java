package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_025_SearchPOM {
	private WebDriver driver; 
	
	public RETC_025_SearchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="property_type")
	private WebElement Propert; 
	
	@FindBy(id="date")
	private WebElement Date;
	
	@FindBy(id="post-query-submit")
	private WebElement FilterBtn;

	private Object userName;

		
	public void sendUserName(String userName) {
		((WebElement) this.userName).clear();
		((WebElement) this.userName).sendKeys(userName);
	}
	
	public void clickFilterBtn() {
		this.FilterBtn.click(); 
	}
}
