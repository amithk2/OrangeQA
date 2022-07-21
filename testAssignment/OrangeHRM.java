package testAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver dv;
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	@AfterTest
	public void shutdown() {
		dv.close();
	}
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		dv = new ChromeDriver();
		dv.get(baseURL);
//		dv.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		dv.manage().window().maximize();
		dv.manage().deleteAllCookies();
//		dv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
@Test(dataProvider="DP")
public void user1(String username,String password) throws InterruptedException {
	dv.findElement(By.id("txtUsername")).sendKeys(username);
	dv.findElement(By.id("txtPassword")).sendKeys(password);
	dv.findElement(By.id("btnLogin")).click();
//	String actualurl=dv.getCurrentUrl();
//		System.out.println(actualurl);
//		String expectedurl="https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
//		if(actualurl.equalsIgnoreCase(expectedurl)) {
//			  System.out.println("The login is success");
//		}
//		else {
//			System.out.println("The Login is failed");
//		}
	try {

		dv.findElement(By.partialLinkText("Admin")).click();
		Thread.sleep(1000);
		dv.findElement(By.partialLinkText("Leave")).click();
		Thread.sleep(1000);

		dv.findElement(By.partialLinkText("Recruitment")).click();
		Thread.sleep(1000);


		
		dv.findElement(By.partialLinkText("Welcome")).click();
		dv.findElement(By.linkText("Logout")).click();
}catch(Exception e) {
	System.out.println(username +"Invalid Username");
}
}
	
	
	@DataProvider(name ="DP")
	public Object[][] dataObject(){
		return new Object[][] {
			{"Admin","admin123"},{"amith","ka1072"},{"sachin","gfer1234"},{"harish","KJF1423"}
			
		};


}
}
