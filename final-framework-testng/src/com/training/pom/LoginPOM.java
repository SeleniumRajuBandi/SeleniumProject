package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(css="input.button.border.margin-top-10")
	private WebElement loginBtn; 
	
	@FindBy(xpath ="//div[text()=\"Properties\"]")
	private WebElement propertiesBtn; 
	
	@FindBy(css="li.wp-first-item.current")
	protected WebElement allPropertiesBtn;
	
	@FindBy(xpath ="//*[@id=\"menu-posts-property\"]/ul/li[4]/a")
	private WebElement featuresBtn; 
	
	@FindBy(css="div.wrap")
	protected WebElement allPropertiesPage;
	
	@FindBy(css="span.trash")
	protected WebElement trashBtn;
	
	@FindBy(css="ul.subsubsub li.trash")
	private WebElement trashLink; 
	
	@FindBy(css="span.untrash")
	private WebElement restoreBtn;
	
	@FindBy(css="span.delete")
	private WebElement deleteBtn;
	
	@FindBy(css="ul.subsubsub li.all")
	private WebElement allBtn;
	
	@FindBy(id="post-search-input")
	private WebElement searchProperty;
	
	@FindBy(id ="menu-item-617")
	private WebElement blogTab;
	
	@FindBy(css ="a.read-more")
	private WebElement readMoreLink;
	
	@FindBy(id ="comment")
	private WebElement commentBox;
	
	@FindBy(id ="author")
	private WebElement nameField;
	
	@FindBy(id ="email")
	private WebElement emailField;
	
	@FindBy(id ="submit")
	private WebElement postCommentBtn;
	
	@FindBy(css ="a.sign-in")
	private WebElement signInBtn;
	
	@FindBy(css ="a.vim-r.hide-if-no-js")
	private WebElement replyCommentBtn;
	
	@FindBy(css ="textarea.wp-editor-area")
	private WebElement replyCommentBox;

	private Object clickAddnewLnk;
	
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

	public void clickPropertiesBtn() {
		this.propertiesBtn.click();
	}
	public WebElement clickAllPropertiesBtn() {		
		return allPropertiesBtn;
	}
	
	public WebElement clickFeaturesBtn() {		
		return featuresBtn;
	}
	public boolean allPropertiesPageIsDisplayed() {
		return allPropertiesPage.isDisplayed();
	}
	
	public void clickTrashBtn() {
		this.trashBtn.click();
	}
	
	public void clickTrashLink() {
		this.trashLink.click();
	}
	
	public void clickRestore() {
		this.restoreBtn.click();
	}
	
	public void clickAllBtn() {
		this.allBtn.click();
	}
	public void clickDeleteBtn() {
		this.deleteBtn.click();
	}
	
	public void sendPropertyName(String propertyName) {
		this.searchProperty.clear();
		this.searchProperty.sendKeys(propertyName);
	}
	
	public void clickBlogTab() {
		this.blogTab.click();
	}
	
	public void clickReadMoreLink() {
		this.readMoreLink.click();
	}
	public void sendComments(String comments) {
		this.commentBox.clear();
		this.commentBox.sendKeys(comments);
	}
	public void sendName(String comments) {
		this.nameField.clear();
		this.nameField.sendKeys(comments);
	}
	
	public void sendEmail(String comments) {
		this.emailField.clear();
		this.emailField.sendKeys(comments);
	}
	
	public void clickPostComment() {
		this.postCommentBtn.click();
	}
	
	public void clickSignIn() {
		this.signInBtn.click();
	}
	public void clickReplyComment() {
		this.replyCommentBtn.click();
	}
	
	public void fillReplyComment(String replycomments) {
		this.replyCommentBox.clear();
		this.replyCommentBox.sendKeys(replycomments);
		
	}

	public void clickAddnewLnk1() {
		((WebElement) this.clickAddnewLnk).click();
		// TODO Auto-generated method stub
		
	}

	public void clickAddnewLnk() {
		this.clickAddnewLnk();// TODO Auto-generated method stub
		
	}

	public void sendTextvalue(String string) {
		this.sendTextvalue(string);// TODO Auto-generated method stub
		
	}

	public void clickaAdnewRegion11() {
		this.clickaAdnewRegion11();// TODO Auto-generated method stub
		
	}

	public void sendContent1(String string) {
		this.sendContent1(null);// TODO Auto-generated method stub
		
	}

	public void clickPublishBtn() {
		this.clickPublishBtn();// TODO Auto-generated method stub
		
	}

	public void clickaAdnewRegion1() {
		// TODO Auto-generated method stub
		
	}

	public void sendContent(String string) {
		// TODO Auto-generated method stub
		
	}


	
		
}
