package com.testautomation.StepDef;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class YouTubeSerarchStepDef extends ExtentReportListener {
	public static WebDriver driver;
	PropertiesFileReader obj= new PropertiesFileReader();  
    
	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{
		
		ExtentTest logInfo=null;
	
		try {
		test = extent.createTest(Feature.class, "Yotube Search validations	");	
		
		test=test.createNode(Scenario.class, "Youtube Search possitive scenarios");	
		
		logInfo=test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
		
		Properties properties=obj.getProperty();   
		 
		System.setProperty("webdriver.chrome.driver", "D:\\Cucumberworkspace\\SeleniumCucumberTestNGFramework-master\\SeleniumCucumberBDDFramework\\chromedriver_78.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();			
		driver.get(properties.getProperty("browser.baseURL"));
		Thread.sleep(3000);	 
		
		
		logInfo.pass("Opened chrome browser and entered url");
		
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
		
	} catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}		
	}

	@When("^Enter search creteria$")
	public void enter_search_creteria() throws Throwable 
	{
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("When"), "Enter search creteria");
		driver.findElement(By.id("search")).sendKeys("selenium by bakkappa n");		
		Thread.sleep(1000);	
		logInfo.pass("Enter search creteria");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
	} catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}
		    
	}

	@Then("^Click on search button$")
	public void click_on_search_button() throws Throwable 
	{
		ExtentTest logInfo=null;
	
	try {
		
		logInfo=test.createNode(new GherkinKeyword("When"), "Click on search button");
		driver.findElement(By.cssSelector("search-icon-legacy")).click();;	
		Thread.sleep(3000);	 	
		driver.quit();
		
		logInfo.pass("Click on search button");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
	} catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}
	}

}
