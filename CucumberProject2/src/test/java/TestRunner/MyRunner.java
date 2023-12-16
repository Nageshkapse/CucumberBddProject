package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/resources/Features/CustomerInfo.feature",
		
		 glue ="Test",
		 tags = "@regression",
		publish = true,
		plugin= {"pretty","html:target/CucumberReport/CucumberReport.html"}
		
		
		)

public class MyRunner  {

	

	
}
