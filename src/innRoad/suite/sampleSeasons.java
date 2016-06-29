package innRoad.suite;

import innRoad.config.Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleSeasons {
	
	public static WebDriver d;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sudha.kotni\\Documents\\My Received Files\\Drivers\\chromedriver.exe");
        d = new ChromeDriver();
      
        d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("http://demo.innroad.com/login.aspx");
		Wait.wait15Second();

	}

}
