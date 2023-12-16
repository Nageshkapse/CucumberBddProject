package Test;

import java.io.File;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import Pom.AddNewCustomer;
import Pom.LoginPage;
import Pom.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VarifyLoginPage extends BaseClass{
	

	@Before
	public void setUp() throws InterruptedException
	{
		readconfig = new ReadConfig() ;
		log = LogManager.getLogger("VarifyLoginPage");

		String browser =readconfig.getBrowser();
		
		switch(browser.toLowerCase())
		{
		case "chrome":
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nagesh\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe" );
	      driver = new ChromeDriver();
	     break;
	     
	
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		 Thread.sleep(3000);
	      driver.manage().window().maximize();
		
	      log.info("setUp executed................");
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws InterruptedException {
	
		
	      loginpage = new LoginPage(driver);
	     addcust = new AddNewCustomer(driver);
	     serachPage = new SearchCustomerPage(driver);
	     log.info("Browser launched................");
	}
	
	@When("user should enter valid url{string}")
	public void user_should_enter_valid_url_https_admin_demo_nopcommerce_com_login(String url) throws InterruptedException {
		Thread.sleep(3000);
		driver.get(url);
		 log.info("Url entered................");
		
	}
	@And("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		loginpage.sendEmail(email);
		loginpage.sendPassword(password);
		
		 log.info("Url and Password Entered................");
	}
	
	@And("user click on login button")
	public void user_click_on_login_button() {
		loginpage.clickLoginButton();
		
		 log.info("Clicked on Login................");
	}
	
	@Then("Page name should be {string}")
	public void page_name_should_be(String expectedTitle) {
		String currentTitle =driver.getTitle();
		
		if (currentTitle.equals(expectedTitle))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("fail");
		}
		 log.info("Varified Title................");
	}
	
	@Then("User click on logout")
	public void user_click_on_logout() {
	   loginpage.clickLogOutButton();
	}
	
	 @Then("User get warning massage")
	    public void User_get_warning_massage()
	    {
	    	String text1 = loginpage.gotWarningMassage();
	    	System.out.println(text1);
	    }
	
	@And("Close browser")
	public void close_browser() {
	   driver.close();
	}
	
	///////////////////add customer///////////////////////////
	@And("Click on customer menu")
	public void click_on_customer_menu() {

		addcust.clickOnCustomer();
	}

	@And("Click on Customer item")
	public void click_on_customer_item() {
		addcust.clickOnCustomerMenu();
	}

	@Then("User can view add user page")
	public void user_can_view_add_use_page() {
		addcust.clickOnAddButton();
	  String currentTitle =	driver.getTitle();
	  String expectedTitle = "Add a new customer / nopCommerce administration";	  
	  if (currentTitle.equals(expectedTitle))
	   {
		   System.out.println("PASS");
	   }
	   else
	   {
		   System.out.println("FAIL");	   }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		addcust.sendEmail("vijaydeverkonda@gmail.com");
		addcust.sendPassword("12345");
		addcust.sendFirstName("Nagesh");
	    addcust.sendLastName("Kapse");
	    addcust.clickOnGender();
		addcust.sendBirthDate("05/05/2001");
		addcust.sendCompanyName("Xento");
		addcust.clickOnIsTax();
		//VarifyLoginPage.addcust.clickOnNewsLetter();
		addcust.selectVendorDropDown();
		addcust.sendComment("Commment");
		
	   
	}

	@And("click on save button")
	public void click_on_save_button() {
		addcust.clickOnSubmittButton();
	}

	@And("User can view confiirmation massage {string}")
	public void user_can_view_confiirmation_massage(String expectedString) {
		String bodyTagText = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();
		if(bodyTagText.contains(expectedString))
		{
		
	     System.out.println(bodyTagText);
	     
	   if (bodyTagText.equals(expectedString))
	   {
		   System.out.println("PASS");
	   }
	   else
	   {
		   System.out.println("FAIL");
	   }
	   
		}
	}
	
	//////////////////////////////search customer//////////////////////
	
	@And("Enter customer email")
	public void Enter_customer_email()
	{
		serachPage.enterEmail("victoria_victoria@nopCommerce.com");
		 log.info("email entered................");
	}
	

	@And("Click on search button")
	public void Click_on_search_button()
	{
		serachPage.clickOnSearchBtn();
		 log.info("Cliked on search button................");
		
	}
	
	@Then("User should found email in the search table")
	public void User_should_found_email_in_the_search_table() throws InterruptedException
	{
		String exp ="victoria_victoria@nopCommerce.com";
		if (serachPage.searchEmailInTable(exp) == true)
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		 log.info("Varified mail................");
	}
     @After
     public void tearDown(Scenario sc)
     {
    	 if(sc.isFailed()== true)
    	 {
    		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		 File dest = new File("D:\\ScreenShot\\test.jpg");
    			
    			try {
					FileHandler.copy(source, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	 }
    	 log.info("webbrowser closed................");
    	 driver.quit();
     }
   

}
