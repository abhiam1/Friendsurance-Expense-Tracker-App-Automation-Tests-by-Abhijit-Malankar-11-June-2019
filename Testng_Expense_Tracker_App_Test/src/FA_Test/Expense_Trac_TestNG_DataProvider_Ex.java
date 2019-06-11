package FA_Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class Expense_Trac_TestNG_DataProvider_Ex {
  
	WebDriver driver=null;
	
	 @BeforeClass
	  public void openBrowserAdd(){
	  System.out.println("Browser is now started to run TestNG-Data Provider Test case");
		  
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://thawing-shelf-73260.herokuapp.com/index.jsp");
	  }
	  
	 @AfterClass
	 
	 public void closeBrowserAdd(){
		 
		// Log out User 
	   		
			WebElement logout1=driver.findElement(By.xpath(".//*[@id='logout']"));
			logout1.click();	
			driver.close();
			
	 }
	
		
 @Test(dataProvider = "loginAddUser" ,priority=1)
 
 public void Adduser(String tcid,String un,String pw1,String pw2) {
	  
	  WebElement register=driver.findElement(By.xpath("html/body/div[1]/div/a"));
	  register.click();
	  
	  driver.findElement(By.xpath(".//*[@id='login']")).clear();
	  driver.findElement(By.xpath(".//*[@id='login']")).sendKeys(un);
	  
	  driver.findElement(By.xpath(".//*[@id='password1']")).clear();
	  driver.findElement(By.xpath(".//*[@id='password1']")).sendKeys(pw1);
	  
	  driver.findElement(By.xpath(".//*[@id='password2']")).clear();
	  driver.findElement(By.xpath(".//*[@id='password2']")).sendKeys(pw2);
	  
	  driver.findElement(By.xpath(".//*[@id='submit']")).click();
	  
	  
	// Verify new user is registered 		
		
		String stitle = driver.findElement(By.xpath("html/body/div[1]/h1")).getText();
		String exp = "List Expenses:";
		AssertJUnit.assertEquals(stitle, exp);
		
			System.out.println("**************************");
			System.out.println("Test Case One ");
			System.out.println("Register user page transitioned with success to List expenses page");
			System.out.println("Hence 1 new user is sucessfully registered using dataprovider parameterization");
			System.out.println("**************************");
	
 }

 @DataProvider
 public Object[][] loginAddUser() {
   return new Object[][] {
     new Object[] {"TC01" ,"testuser123", "12345" , "12345" },
     //new Object[] {"TC02" ,"test345", "12345" , "12345" },
   };
 }
}
	