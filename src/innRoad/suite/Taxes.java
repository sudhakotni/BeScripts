package innRoad.suite;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import innRoad.config.BaseTest;
import innRoad.config.TestUtil;
import innRoad.config.Wait;
import innRoad.properties.OR;

public class Taxes extends BaseTest {
	
	
	@Test(dataProvider = "testParameterData")
	  public void testUntitled(String URL, String TCN, String Client_Code, String User_Name, String Password, String Home_Page_Title, String Client_Name, String Property_Name,
			  String Tax_Name, String Display_Name, String Desc_Name, String Tax_value, String Category, String Tax_Category
			  
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
		d.findElement(OR.Taxes).click();
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
	  //  try
	 //  {
	  
	    new Select (d.findElement(OR.Select_Tax_Property)).selectByVisibleText(Property_Name);
	    Wait.wait5Second();
	    if(d.findElements(OR.Tax_validation_Message).size()!=0)
		 {
	    	d.findElement(OR.New_item).click();
	    	Wait.wait2Second();
	    	d.findElement(OR.Item_Name).sendKeys(Tax_Name);
	    	d.findElement(OR.Tax_Display_Name).sendKeys(Display_Name);
	    	d.findElement(OR.Tax_Description_Name).sendKeys(Desc_Name);
	    	d.findElement(OR.Tax_value).sendKeys(Tax_value);
	    	d.findElement(OR.Tax_Percent).click();
	    	Wait.wait2Second();
	    	new Select (d.findElement(OR.Category_Dropdown)).selectByVisibleText(Category);
	    	Wait.wait2Second();
	    	d.findElement(OR.Edit_Taxes).click();
	    	Wait.wait5Second();
	    	d.switchTo().frame(d.findElement(By.tagName("iframe")));
			Wait.wait5Second();
			d.switchTo().frame(0);	
			List<WebElement> all_Taxes_size = d.findElements(OR.Get_Seasons);
			System.out.println("all_Seasons_size "+ all_Taxes_size.size());
			Wait.wait2Second();
			
			for(int i=0;i<all_Taxes_size.size();i++)
			{
				
				if(all_Taxes_size.get(i).getText().equals(Tax_Category))
				{
					int var=i+1;
					d.findElement(By.xpath("//select[@id='lstTaxes']/option["+var+"]")).click();
					Wait.wait2Second();
					d.findElement(OR.Pick_one_item).click();
					Wait.wait2Second();
					d.findElement(OR.DoneButton).click();
					Wait.wait5Second();
					
					break;
				}
				
			}
			
			
			 d.switchTo().defaultContent();
			 Wait.wait2Second();
			 d.switchTo().frame("main");
			 Wait.wait2Second();
			 d.findElement(OR.DoneButton2).click();
			 Wait.wait2Second();
			
		 }
	    else
	    {
       int x = d.findElements(OR.Get_Num_items).size();
	    for(int i=0;i<x;i++)
	    {
	    	d.findElement(OR.Select_Items).click();
	    	Wait.wait2Second();
	    	d.findElement(OR.Delete_Tax).click();
	    	Wait.wait2Second();
	    }
	    d.findElement(OR.New_item).click();
    	Wait.wait2Second();
    	d.findElement(OR.Item_Name).sendKeys(Tax_Name);
    	d.findElement(OR.Tax_Display_Name).sendKeys(Display_Name);
    	d.findElement(OR.Tax_Description_Name).sendKeys(Desc_Name);
    	d.findElement(OR.Tax_value).sendKeys(Tax_value);
    	d.findElement(OR.Tax_Percent).click();
    	Wait.wait2Second();
    	new Select (d.findElement(OR.Category_Dropdown)).selectByVisibleText(Category);
    	Wait.wait2Second();
    	d.findElement(OR.Edit_Taxes).click();
    	Wait.wait5Second();
    	d.switchTo().frame(d.findElement(By.tagName("iframe")));
		Wait.wait5Second();
		d.switchTo().frame(0);	
		List<WebElement> all_Taxes_size = d.findElements(OR.Get_Seasons);
		System.out.println("all_Seasons_size "+ all_Taxes_size.size());
		Wait.wait2Second();
		
		for(int i=0;i<all_Taxes_size.size();i++)
		{
			
			if(all_Taxes_size.get(i).getText().equals(Tax_Category))
			{
				int var=i+1;
				d.findElement(By.xpath("//select[@id='lstTaxes']/option["+var+"]")).click();
				Wait.wait2Second();
				d.findElement(OR.Pick_one_item).click();
				Wait.wait2Second();
				d.findElement(OR.DoneButton).click();
				Wait.wait5Second();
				break;
			}
			
		}
	
		 d.switchTo().defaultContent();
		 Wait.wait2Second();
		 d.switchTo().frame("main");
		 Wait.wait2Second();
		 d.findElement(OR.DoneButton2).click();
		 Wait.wait2Second();
	    }
	   /* testresultdata.put("8", new Object[] { 7d,
	              "TC7 - Fill all Taxes details and click on Done",
	              "System should save the tax details", "Pass" }); }
		  
		  catch (Throwable t) {
     testresultdata.put("8", new Object[] { 7d,
		      "TC7 - Fill all Taxes Details and click on Done",
		      "System failed to save the tax details", "Fail" });
   }*/
	    
	    
	   
		 
		 
		 
	}
			 
			
			 
			 
			 
			 @AfterClass
				public void stop() {
					setupAfterSuite();
					stopDriver();
				}

				@DataProvider(name = "testParameterData", parallel = false)
				public static Object[][] testParameterData(Method method) throws Exception {

					initialize();
					Object data[][] = TestUtil.getData(datatable_suite1, "Taxes");
					return data;
				}

}
