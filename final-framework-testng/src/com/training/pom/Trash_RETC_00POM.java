package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Trash_RETC_00POM {
private WebDriver driver; 

public Trash_RETC_00POM(WebDriver driver) {
this.driver = driver; 
PageFactory.initElements(driver, this);
}

@FindBy(id="user_login")
private WebElement userName; 

@FindBy(id="user_pass")
private WebElement password;

@FindBy(name="login")
private WebElement loginBtn; 

@FindBy(xpath="//a[contains(text(),'All Posts')]")
private WebElement allpostsBtn; 

@FindBy(xpath="//tr[@id='post-5561']//a[@class='submitdelete'][contains(text(),'Trash')]")
private WebElement submitTrashBtn;




public void sendUserName(String userName) {
this.userName.clear();
this.userName.sendKeys(userName);
}

public void sendPassword(String password) {
this.password.clear(); 
this.password.sendKeys(password); 
}

public void clickLoginBtn() {
this.loginBtn.click(); 
}

public void clickAllpostsBtn() {
this.allpostsBtn.click();
}

public void clickSubmitTrashBtn() {
this.submitTrashBtn.click();
}
}