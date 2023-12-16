package Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCustomerPage {

	@FindBy(xpath="//div[@class='row search-row ']")
	private WebElement search;
	
	@FindBy(id="SearchEmail")
	private WebElement email;
	
	@FindBy(id="search-customers")
	private WebElement searchButton;
	
	@FindBy(xpath="//table[contains(@class,'table table-bordered')]")
	private WebElement dataTable;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	private List<WebElement> rows;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SearchCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
		
		this.driver =driver;
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	
	public void enterEmail(String emailid)
	{
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(emailid);
		
	}
	public void clickOnSearchBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		
	}
	public boolean searchEmailInTable(String passemail) throws InterruptedException
	{
		boolean found = false ;
		int rowCount = rows.size();
		
		for(int i = 0; i <( rowCount-1); i++)
		{
			
			WebElement searchelement = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[\" + i  + \"]/td[2]"));
			
		
			String actualEmail = searchelement.getText();
			
			System.out.println(actualEmail);
			Thread.sleep(1000);
			if (actualEmail.equals(passemail))
			{
				found = true;
			}
		
		
			
		}
		
		return found;
	}

}
