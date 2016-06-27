package innRoad.suite;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import innRoad.config.BaseTest;
import innRoad.config.TestUtil;
import innRoad.config.Wait;
import innRoad.properties.OR;

public class Room_Classes extends BaseTest{
	
	 Screen screen = new Screen();
	 @Test(dataProvider = "testParameterData")
	  public void testUntitled(String URL, String TCN, String Client_Code, String User_Name, String Password, String Home_Page_Title, String Client_Name, String Property_Name, String RoomClassName,
			  String Room_Class_Abbreviation, String Max_Adult, String Max_Persons,String Rooms_quantity, String Room_Number, String Station_id, String Sort_Order
			  
			  ) throws Exception {
		 
		 setupBeforeSuite(TCN);
		 
		 
		 //login to the inncenter
		 try
		 {
		 filllogin2(URL,Client_Code,User_Name,Password);
		 testresultdata.put("2", new Object[] { 1d,
	              "TC1 - Verify site loaded or not ",
	              "System sucessfully navigate to the Site", "Pass" }); }
		  
		  catch (Throwable t) {
             testresultdata.put("2", new Object[] { 1d,
		      "TC1 - Verify site loaded or not",
		      "System Failed to navigate to the site", "Fail" });
          }
		 
		 //Verify home page
		 
		 try
		 {
		 String Get_Home_Page_Title=d.getTitle();
		 Wait.wait15Second();
		if(Get_Home_Page_Title.endsWith(Home_Page_Title))
		{
			System.out.println("Title verified");
		}
		else
		{
			System.out.println("Fail to verify title");
		}
		 testresultdata.put("3", new Object[] { 2d,
	              "TC2 - Verify Page title",
	              "System sucessfully verified page title", "Pass" }); }
		  
		  catch (Throwable t) {
            testresultdata.put("3", new Object[] { 2d,
		      "TC2 - Verify page title",
		      "System failed to verify page title", "Fail" });
         }
		 
		 
		 
		 
		//Select client from client dropdown
	try
		 { 
		 d.switchTo().frame(0);
		 Wait.wait2Second();
		 d.findElement(OR.Search_Icon).click();
		 Wait.wait10Second();
		 
		 testresultdata.put("4", new Object[] { 3d,
	              "TC3 - Verify by clicking on Search shortcut icon",
	              "System sucessfully clicked search icon", "Pass" }); }
		  
		  catch (Throwable t) {
           testresultdata.put("4", new Object[] { 3d,
		      "TC3 - Verify by clicking on search shortcut icon",
		      "System failed click serach icon", "Fail" });
        }
		
		
		//Selecting client from client dropdown 
		try
		{
		 d.switchTo().defaultContent();
		 Wait.wait2Second();
		 d.switchTo().frame("main");
		 Wait.wait2Second();
		 d.findElement(By.xpath("//b")).click();
		 Wait.wait5Second();
		 d.findElement(By.id("s2id_autogen1_search")).click();
		 d.findElement(By.id("s2id_autogen1_search")).sendKeys(Client_Name);
		// d.findElement(By.id("s2id_autogen1_search")).sendKeys(Client_Name);
		 d.findElement(By.id("s2id_autogen1_search")).sendKeys(Keys.ENTER);
		 Wait.wait10Second();
		
			testresultdata.put("5", new Object[] { 4d,
		              "TC4 - Verify Page title",
		              "System sucessfully verified page title", "Pass" }); }
			  
			  catch (Throwable t) {
	           testresultdata.put("5", new Object[] { 4d,
			      "TC4 - Verify page title",
			      "System failed to verify page title", "Fail" });
	        }
		
		
		
		 //Verify by clicking on Setup
		try
		{
			 d.switchTo().defaultContent();
			    Wait.wait2Second();	
			    d.switchTo().frame(0);
				 Wait.wait2Second();
		d.findElement(OR.setup).click();
		Wait.wait10Second();
		testresultdata.put("6", new Object[] { 5d,
	              "TC5 - Click Set up link",
	              "System should navigate to the set up page", "Pass" }); }
		  
		  catch (Throwable t) {
         testresultdata.put("6", new Object[] { 5d,
		      "TC5 - Click Set up link",
		      "System failed to navigate to the set up page", "Fail" });
      }
		
		//Click on Room Classes
	    try
	    {
	    d.switchTo().defaultContent();
	    Wait.wait2Second();
	    d.switchTo().frame("main");
	    Wait.wait2Second();
		d.findElement(OR.Room_Classes).click();
		Wait.wait10Second();
		testresultdata.put("7", new Object[] { 6d,
	              "TC6 - Click on Rooms link",
	              "System should navigate to the Rooms Page", "Pass" }); }
		  
		  catch (Throwable t) {
       testresultdata.put("7", new Object[] { 6d,
		      "TC6 - Click on Rooms link",
		      "System should navigate to the Rooms page", "Fail" });
    }
	    
	    
	    
	    //Select property 
	    try
	   {
	    d.switchTo().defaultContent();
	    Wait.wait2Second();
	    d.switchTo().frame("nxtgen");
	    Wait.wait2Second();
	    new Select (d.findElement(OR.Select_property)).selectByVisibleText(Property_Name);
	    Wait.wait5Second();
	    testresultdata.put("8", new Object[] { 7d,
	              "TC7 - Select Required property",
	              "System should allow user to select required property", "Pass" }); }
		  
		  catch (Throwable t) {
     testresultdata.put("8", new Object[] { 6d,
		      "TC7 - Select Required property",
		      "System failed to allow user to select required property", "Fail" });
  }
	    
	    
	  //Click on New Room class
	    
	    try
	    {
	    	d.findElement(OR.New_Class_Room).click();
	    	Wait.wait2Second();
	    
	    	 testresultdata.put("9", new Object[] { 8d,
		              "TC8 - click on New Room classes",
		              "System should allow user to navigate to new rooms classes page", "Pass" }); }
			  
			  catch (Throwable t) {
	     testresultdata.put("9", new Object[] { 8d,
			      "TC8 - Click on New Room Classes",
			      "System failed to allow user to navigate to the new room claases", "Fail" });
	  }
		    
		 
	//Entering Room details
	    try
	    {
	    d.findElement(OR.Enter_Room_Class_Name).sendKeys(RoomClassName);
	    d.findElement(OR.Room_Class_Abbreviation).sendKeys(Room_Class_Abbreviation);
	    testresultdata.put("10", new Object[] { 9d,
	              "TC9 - Enter Room details",
	              "System should allow user enter room details", "Pass" }); }
		  
		  catch (Throwable t) {
   testresultdata.put("10", new Object[] { 9d,
		      "TC9 - Click on New Room Classes",
		      "System failed to allow user to navigate to rooms page", "Fail" });
        }
	    
	    
	    //Clicking on Details
	    try
	    {
	    d.findElement(OR.Click_Rooms_Tab).click();
	    Wait.wait2Second();
	    d.findElement(OR.Enter_Max_Adult).sendKeys(Max_Adult);
	    d.findElement(OR.Enter_Max_Person).sendKeys(Max_Persons);
	    d.findElement(OR.Enter_Room_quantity).sendKeys(Rooms_quantity);
	    d.findElement(OR.create_Rooms).click();
	    Wait.wait2Second();
	    d.findElement(OR.Enter_Room_Number).sendKeys(Room_Number);
	    d.findElement(OR.Enter_station_id).sendKeys(Station_id);
	    d.findElement(OR.Enter_sort_order).sendKeys(Sort_Order);
	    d.findElement(OR.Click_Assign_Rooms).click();
	    Wait.wait2Second();
	    d.findElement(OR.Click_Publish).click();
	    Wait.wait5Second();
	    testresultdata.put("11", new Object[] { 10d,
	              "TC10 - Enter Room details",
	              "System should allow user enter room details", "Pass" }); }
		  
		  catch (Throwable t) {
 testresultdata.put("11", new Object[] { 10d,
		      "TC10 - Click on New Room Classes",
		      "System failed to allow user to navigate to rooms page", "Fail" });
      }
	    
		 
		 
		 
		 
	 }
	 
	 
	 
	 @AfterClass
		public void stop() {
			setupAfterSuite();
			stopDriver();
		}

		@DataProvider(name = "testParameterData", parallel = false)
		public static Object[][] testParameterData(Method method) throws Exception {

			initialize();
			Object data[][] = TestUtil.getData(datatable_suite1, "Room_Classes");
			return data;
		}

}
