package Pom;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomer {
	
	@FindBy(xpath ="(//a[@class='nav-link'])[21]")
	private WebElement  customerMenu ;
	
	@FindBy(xpath ="//p[text()=' Customers']")
	private WebElement  customer ;
	
	@FindBy(xpath ="//a[@class='btn btn-primary']")
	private WebElement addNewButton ;
	
	@FindBy(xpath ="//input[@id='Email']")
	private WebElement  email ;
	
	@FindBy(xpath ="//input[@id='Password']")
	private WebElement password ;
	
	@FindBy(xpath ="//input[@id='FirstName']")
	private WebElement  firstName ;
	
	@FindBy(xpath ="//input[@id='LastName']")
	private WebElement  lastName ;
	
	@FindBy(xpath ="//input[@id='Gender_Male']")
	private WebElement  gender ;
	
	@FindBy(xpath ="//input[@id='DateOfBirth']")
	private WebElement  dateOfBirth ;
	
	
	@FindBy(xpath ="//input[@id='Company']")
	private WebElement  companyName ;
	
	@FindBy(xpath ="//input[@id='IsTaxExempt']")
	private WebElement  tax ;
	
	@FindBy(xpath ="(//div[contains(@class,'k-multiselect-wrap k')])[1]")
	private WebElement  newsletter ;
	
	@FindBy(xpath ="//select[@id='VendorId']")
	private WebElement  managerVendor ;
	
	@FindBy(xpath ="//textarea[@id='AdminComment']")
	private WebElement  adminComment ;
	
	@FindBy(xpath ="(//button[@type='submit'])[2]")
	private WebElement submittButton;
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AddNewCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
		
		this.driver=driver;
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	
	public void clickOnCustomer()
	{
		wait.until(ExpectedConditions.visibilityOf(customerMenu));
		customerMenu.click();
	}
	public void clickOnCustomerMenu()
	{
		wait.until(ExpectedConditions.visibilityOf(customer));
		customer.click();
	}

	

	public void clickOnAddButton()
	{
		wait.until(ExpectedConditions.visibilityOf(addNewButton));
		addNewButton.click();
	}

	public void sendEmail(String emailid)
	{
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(emailid);
	}
	public void sendPassword(String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	public void sendFirstName(String enterfname)
	{
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(enterfname);
	}
	public void sendLastName(String enterLname)
	{
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(enterLname);
	}
	public void clickOnGender()
	{
		wait.until(ExpectedConditions.visibilityOf(gender));
		gender.click();
	}
	public void sendBirthDate(String date)
	{
		wait.until(ExpectedConditions.visibilityOf(dateOfBirth));
		dateOfBirth.sendKeys(date);
	}
	public void sendCompanyName(String name)
	{
		wait.until(ExpectedConditions.visibilityOf(companyName));
		companyName.sendKeys(name);
	}
	public void clickOnIsTax()
	{
		wait.until(ExpectedConditions.visibilityOf(tax));
		tax.click();
	}
//	public void clickOnNewsLetter() throws InterruptedException
//	{
//		wait.until(ExpectedConditions.visibilityOf(newsletter));
//		Thread.sleep(2000);
//		newsletter.click();
//		newsletter.sendKeys(Keys.ARROW_DOWN);
//		Thread.sleep(2000);
//		newsletter.sendKeys(Keys.ENTER);
//	}
	public void selectVendorDropDown()
	{
		wait.until(ExpectedConditions.visibilityOf(managerVendor));
		Select s = new Select(managerVendor);
		s.selectByVisibleText("Vendor 1");
	}
	public void sendComment(String comment)
	{
		wait.until(ExpectedConditions.visibilityOf(adminComment));
		adminComment.sendKeys(comment);
		
	}
	public void clickOnSubmittButton()
	{
		wait.until(ExpectedConditions.visibilityOf(submittButton));
		submittButton.click();
	}
	

}
