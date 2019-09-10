package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_021_DeleteTagPOM {
private static final String DeleteTagBtn = null;

private WebDriver driver; 

public RETC_021_DeleteTagPOM(WebDriver driver) {
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

@FindBy(id="doaction")
private WebElement submitDeleteBtn;
private Object submitDeleteTagBtn;




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

public void clickSubmitDeleteBtn() {
this.clickSubmitDeleteBtn();
}
}