package tests;


import base_test.BaseTest;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.Blogger_HP;
import utils.BrowserUtility;
import utils.WaitUtility;
import utils.driver.DriverManager;


public class BloggerHPTest extends BaseTest {


   @BeforeMethod
   public void setUpBrowser() {
       super.setUpBrowser();
   }


   @AfterMethod(alwaysRun = true)
   public void tearDownBrowser() {
       super.tearDownBrowser();
   }


   @Test(priority = 1, enabled = true)
   public void verifyLoginFunctionalityOfPatrol() {
       Blogger_HP bloggerHp = new Blogger_HP(DriverManager.getDriver());
       bloggerHp.goToBlogger();
       String url1 = "http://blog.dasient.com/2010/09/continued-growth-in-web-based-malware_9357.html?sc=1756463390193#c9073503663723300703";
       BrowserUtility.goToUrl(DriverManager.getDriver(), url1);
       bloggerHp.switchToCommentIframe();
       bloggerHp.clickOnEnterComment();
       bloggerHp.clickOnEnterCommentFiled();
       bloggerHp.enterComment("Auto Comment 131 <a href='https://youtube.com'>dummy</a>");
       bloggerHp.clickOnPublishButton();
       WaitUtility.waitForSeconds(30);
   }
}

package pages;


import base_page.BasePage;
import org.openqa.selenium.By;
import utils.BrowserUtility;


import org.openqa.selenium.WebDriver;
import utils.driver.DriverManager;


public class Blogger_HP extends BasePage {
   public Blogger_HP(WebDriver driver) {
       super(driver);
   }
   // xPaths
   By signInBtn = By.xpath("//a[normalize-space(.)='Sign in']");
   By emailInputField = By.xpath("//input[@type='email']");
   By passwordInputField = By.xpath("//input[@type='password']");
   By nextBtn = By.xpath("//span[normalize-space(.)='Next']");
   // Comments xPaths ------------------------------------------------------------
   By commentIframe = By.xpath("//iframe[@id='comment-editor']");
   By enterComment = By.xpath("//div[normalize-space(text())='Enter Comment']");
   By enterCommentFiled = By.xpath("//textarea[@aria-label='Enter Comment']");
   By publishBtn = By.xpath("//span[normalize-space(text())='Publish']");
   // --------------------------------------------------
   public void goToBlogger(){
       driver.get("https://www.blogger.com/");
   }
   // Methods
   public void clickOnSignInButton(){
       BrowserUtility.click(driver,signInBtn,"sign-in button");
   }
   public void enterEmailId(String emailId){
       BrowserUtility.sendKeys(driver,emailInputField,emailId,"email field");
   }
   public void enterPassword(String password){
       BrowserUtility.sendKeys(driver,passwordInputField,password,"password field");
   }
   public void clickOnNextButton(){
       BrowserUtility.click(driver,nextBtn,"next button");
   }
   // Comments Method --------------------------------------------------------------------------
   public void switchToCommentIframe(){
       BrowserUtility.scrollToBottomOfPage(DriverManager.getDriver());
       BrowserUtility.switchToIframe(driver,commentIframe,"comment iframe");
   }


   public void clickOnEnterComment(){
       BrowserUtility.click(driver,enterComment,"enter comment");
   }


   public void clickOnEnterCommentFiled(){
       BrowserUtility.click(driver,enterCommentFiled,"comment field");
   }


   public void enterComment(String comment){
       BrowserUtility.sendKeys(driver,enterCommentFiled,comment,"comment field");
   }


   public void clickOnPublishButton(){
       BrowserUtility.click(driver,publishBtn,"publish button");
   }
}




package pages;


import base_page.BasePage;
import org.openqa.selenium.By;
import utils.BrowserUtility;


import org.openqa.selenium.WebDriver;
import utils.driver.DriverManager;


public class Blogger_HP extends BasePage {
   public Blogger_HP(WebDriver driver) {
       super(driver);
   }
   // xPaths
   By signInBtn = By.xpath("//a[normalize-space(.)='Sign in']");
   By emailInputField = By.xpath("//input[@type='email']");
   By passwordInputField = By.xpath("//input[@type='password']");
   By nextBtn = By.xpath("//span[normalize-space(.)='Next']");
   // Comments xPaths ------------------------------------------------------------
   By commentIframe = By.xpath("//iframe[@id='comment-editor']");
   By enterComment = By.xpath("//div[normalize-space(text())='Enter Comment']");
   By enterCommentFiled = By.xpath("//textarea[@aria-label='Enter Comment']");
   By publishBtn = By.xpath("//span[normalize-space(text())='Publish']");
   // --------------------------------------------------
   By postComment = By.xpath("//*[normalize-space(text())='Post a Comment']");
   // --------------------------------------------------
   public void goToBlogger(){
       driver.get("https://www.blogger.com/");
   }
   // Methods
   public void clickOnSignInButton(){
       BrowserUtility.click(driver,signInBtn,"sign-in button");
   }
   public void enterEmailId(String emailId){
       BrowserUtility.sendKeys(driver,emailInputField,emailId,"email field");
   }
   public void enterPassword(String password){
       BrowserUtility.sendKeys(driver,passwordInputField,password,"password field");
   }
   public void clickOnNextButton(){
       BrowserUtility.click(driver,nextBtn,"next button");
   }
   // Comments Method --------------------------------------------------------------------------
   public boolean isCommentIframeAvailable(){
       return BrowserUtility.isIframeAvailable(driver,commentIframe,"comment iframe");
   }


   public void switchToCommentIframe(){
       BrowserUtility.scrollToBottomOfPage(DriverManager.getDriver());
       BrowserUtility.switchToIframe(driver,commentIframe,"comment iframe");
   }


   public void clickOnEnterComment(){
       BrowserUtility.scrollToBottomOfPage(DriverManager.getDriver());
       BrowserUtility.click(driver,enterComment,"enter comment");
   }


   public void clickOnPostComment(){
       BrowserUtility.scrollToBottomOfPage(DriverManager.getDriver());
       BrowserUtility.click(driver,postComment,"post comment");
   }


   public boolean isEnterCommentDisplayed(){
       return BrowserUtility.isDisplayed(driver,enterComment);
   }


   public boolean isPostCommentDisplayed(){
       return BrowserUtility.isDisplayed(driver,enterComment);
   }


   public boolean isCurrentUrlContains(String partialURL){
       return BrowserUtility.getCurrentUrl(driver).contains(partialURL);
   }


   public void clickOnEnterCommentFiled(){
       BrowserUtility.click(driver,enterCommentFiled,"comment field");
   }


   public void enterComment(String comment){
       BrowserUtility.sendKeys(driver,enterCommentFiled,comment,"comment field");
   }


   public void clickOnPublishButton(){
       BrowserUtility.click(driver,publishBtn,"publish button");
   }


   // -----------------------------------
   public void iframeComment(String url,String comment){
       BrowserUtility.openNewTab(DriverManager.getDriver(),url);
       switchToCommentIframe();
       clickOnEnterComment();
       clickOnEnterCommentFiled();
       enterComment(comment);
   }
   public void postAComment(String url,String comment){
       BrowserUtility.openNewTab(DriverManager.getDriver(),url);
       clickOnPostComment();
       clickOnEnterComment();
       clickOnEnterCommentFiled();
       enterComment(comment);
   }
   public void fullPageComment(String url,String comment){
       BrowserUtility.openNewTab(DriverManager.getDriver(),url);
       clickOnEnterComment();
       clickOnEnterCommentFiled();
       enterComment(comment);
   }
}

package tests;


import base_test.BaseTest;


import data_providers.BackLinkDP;
import org.testng.annotations.*;


import pages.Blogger_HP;
import utils.driver.DriverManager;


import java.util.List;


public class BloggerHPTest extends BaseTest {


   @BeforeClass
   public void setUpBrowser() {
       super.setUpBrowser();
   }


   @AfterClass(alwaysRun = true)
   public void tearDownBrowser() {
       super.tearDownBrowser();
   }


   @Test(priority = 1, enabled = true)
   public void verifyLoginFunctionalityOfPatrol() {
       Blogger_HP bloggerHp = new Blogger_HP(DriverManager.getDriver());
       bloggerHp.goToBlogger();
   }


   @Test(priority = 2,enabled = true,dataProvider = "backlink_database_sheet1",dataProviderClass = BackLinkDP.class)
   public void printBacklinkRow(List<String> row) {
       Blogger_HP bloggerHp = new Blogger_HP(DriverManager.getDriver());
       String url = row.get(0).trim();
       String method = row.get(1).trim();
       String comment = row.get(2).trim();
       switch (method) {
           case "Iframe":
               bloggerHp.iframeComment(url,comment);
               break;
           case "Post a comment":
               bloggerHp.postAComment(url,comment);
               break;
           case "Full page comment":
               bloggerHp.fullPageComment(url,comment);
               break;
       }
   }
}

