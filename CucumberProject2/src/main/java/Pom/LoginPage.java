package Pom;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logOutButton;
	
	@FindBy (xpath="//div[contains(@class,'message-error validation')]")
	private WebElement warningMassage;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
		
		this.driver =driver;
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	public void sendEmail(String emailid) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(email));
		 email.clear();
		 Thread.sleep(2000);
		 email.sendKeys(emailid);
	}

	public void sendPassword(String pass) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		 Thread.sleep(2000);
		password.sendKeys(pass);
		
	}
	public void clickLoginButton()
	{
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
	}
	
	public void clickLogOutButton()
	{
		wait.until(ExpectedConditions.visibilityOf(logOutButton));
		logOutButton.click();
	}

	public String gotWarningMassage()
	{
		wait.until(ExpectedConditions.visibilityOf(warningMassage));
		String text = warningMassage.getText();
		return text;
	}
}
