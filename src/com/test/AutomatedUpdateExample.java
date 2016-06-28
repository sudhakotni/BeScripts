package com.test;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import org.openqa.selenium.support.ui.ExpectedConditions;

	import org.openqa.selenium.support.ui.WebDriverWait;

	import testlink.api.java.client.TestLinkAPIClient;

import testlink.api.java.client.TestLinkAPIException;

	import testlink.api.java.client.TestLinkAPIResults;

	 

	public class AutomatedUpdateExample {


	public static String DEVKEY="895e5b64b94d165414658d6c9d20de47";

	public static String URL="http://testlink.inrd.io/lib/api/xmlrpc/v1/xmlrpc.php";

	 

	public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{

	TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);

	api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);

	}

	 

	@Test

	public void Test1()throws Exception

	{

	AutomatedUpdateExample a=new AutomatedUpdateExample();

	WebDriver driver=new FirefoxDriver();

	WebDriverWait wait=new WebDriverWait(driver, 600);

	String testProject="Continues Integration";

	String testPlan="SampleTestPlan";

	String testCase="Test Sample";

	String build="Test Build";

	String notes=null;

	String result=null;

	try{

	driver.manage().window().maximize();

	driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");

	driver.findElement(By.id("Email")).sendKeys("testlink.msoftgp");

	driver.findElement(By.id("Passwd")).sendKeys("*******");

	driver.findElement(By.id("signIn")).click();

	driver.switchTo().defaultContent();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+Testlink")));

	result= TestLinkAPIResults.TEST_PASSED;

	notes="Executed successfully";

	}

	catch(Exception e){

	result=TestLinkAPIResults.TEST_FAILED;

	notes="Execution failed";

	}

	finally{

	 

	a.reportResult(testProject, testPlan, testCase, build, notes, result);

	driver.quit();

	}

	}

	}