package Test;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Pom.AddNewCustomer;
import Pom.LoginPage;
import Pom.SearchCustomerPage;
import Utilities.ReadConfig;

public class BaseClass {
	
	public  WebDriver driver;
	public  LoginPage loginpage;
	public  AddNewCustomer addcust;
	public  SearchCustomerPage serachPage;
	public static Logger log;
	public ReadConfig readconfig;
	

}
