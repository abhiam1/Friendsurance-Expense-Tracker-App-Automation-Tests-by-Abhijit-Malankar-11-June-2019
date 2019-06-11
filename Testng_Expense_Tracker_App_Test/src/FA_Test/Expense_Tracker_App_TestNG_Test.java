package FA_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Expense_Tracker_App_TestNG_Test {

	public static WebDriver driver=new FirefoxDriver();

	@BeforeSuite(groups = {"New_User_Addition"})
	public static WebDriver setup_Browser() 
   {
		//WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Step 2: Enter URL
		driver.get("http://thawing-shelf-73260.herokuapp.com/index.jsp");
		return driver;

	}
	
	@AfterSuite(groups = {"New_User_Addition"})
	public static WebDriver Close_Browser() 
    {
		//WebDriver driver=new FirefoxDriver();
		
		
		// Log out User 
   		
	WebElement logout1=driver.findElement(By.xpath(".//*[@id='logout']"));
	logout1.click();	
				
	driver.close();
	return driver;

	}

	@Test(priority = 1, groups = {"New_User_Addition"})
	public static void Verify_Url() 
	{
		
		// Actual url
		String my_url = driver.getCurrentUrl();
		System.out.println("**************************");
		System.out.println("Test Case One");
		System.out.println("Page url is " + my_url);
		System.out.println("**************************");
		// expected url
		String expected_url = "http://thawing-shelf-73260.herokuapp.com/index.jsp";
		AssertJUnit.assertEquals(my_url , expected_url);
		
		
	}

	@Test(priority = 2, groups = {"New_User_Addition"})
	public void Verify_Application_Title() 
	{
		
		// Page title Actual title
		String my_title = driver.getTitle();
		
		System.out.println("**************************");
		System.out.println("Test Case Two");
		System.out.println("Page title is " + my_title);
		System.out.println("**************************");
		
		// expected title
		String expected_title = "Expense tracker";
		AssertJUnit.assertEquals(my_title, expected_title);
		
	}

	@Test(priority = 3, groups = {"New_User_Addition"})
	public void Verify_Page_Title() {
    	WebElement register = driver.findElement(By.xpath("html/body/div[1]/div/a"));
    	register.click();	
	String stitle = driver.findElement(By.xpath("html/body/div[1]/h3")).getText();
		String exp = "Register new user";
		AssertJUnit.assertEquals(stitle, exp);
	
		System.out.println("**************************");
		System.out.println("Test Case Three");
		System.out.println("Page Title is  " + stitle);
		System.out.println("**************************");
				
	}

	@Test(priority = 4, groups = {"New_User_Addition"})
	public void New_User_Register() {
    
		// configure new username 
		
	WebElement username=driver.findElement(By.xpath(".//*[@id='login']"));
	username.sendKeys("userid123");
				
	//configure password
				
	WebElement password1=driver.findElement(By.xpath(".//*[@id='password1']"));
				password1.sendKeys("test321");
				
	//confirm password
				
	WebElement password2=driver.findElement(By.xpath(".//*[@id='password2']"));
	password2.sendKeys("test321");
				
	// Register submit 		
	WebElement submit=driver.findElement(By.xpath(".//*[@id='submit']"));
	submit.click();
		
	// Verify new user is registered 		
		
	String stitle = driver.findElement(By.xpath("html/body/div[1]/h1")).getText();
		String exp = "List Expenses:";
		AssertJUnit.assertEquals(stitle, exp);
	
		System.out.println("**************************");
		System.out.println("Test Case Four");
		System.out.println("Register user page transitioned to List expenses page");
		System.out.println("Hence new user is sucessfully registered");
		System.out.println("**************************");
		
						
	}
	
 @Test(priority = 5, groups = {"New_Cat_Addition"})
	
	public void New_Category() {
    
		// Go to List Categories to Create Category
		
		WebElement category=driver.findElement(By.xpath(".//*[@id='go_list_categories']"));
		category.click();

		// Add category 1 click 
		
		WebElement Addcategory1=driver.findElement(By.xpath(".//*[@id='go_add_category']"));
		Addcategory1.click();
					
		// Add category 1
					
		WebElement category1=driver.findElement(By.xpath(".//*[@id='name']"));
		category1.sendKeys("home expense");
					
    	// category 1 submit 
					
		WebElement csubmit1=driver.findElement(By.xpath(".//*[@id='submit']"));
		csubmit1.click();
					
		// Add category 2 click 
					
		WebElement Addcategory2=driver.findElement(By.xpath(".//*[@id='go_add_category']"));
		Addcategory2.click();
							
		// Add category 2 
							
		WebElement category2=driver.findElement(By.xpath(".//*[@id='name']"));
		category2.sendKeys("travel expense");
							
	    // Category 2 submit 
							
		WebElement csubmit2=driver.findElement(By.xpath(".//*[@id='submit']"));
		csubmit2.click();
					
		// Verify new categories are added successfully 	
	
		String stitle = driver.findElement(By.xpath("html/body/div[1]/h1")).getText();
		String exp = "List Categories";
		AssertJUnit.assertEquals(stitle, exp);
		
		System.out.println("**************************");
		System.out.println("Test Case Five");
		System.out.println("Add category page transitioned to List categories page");
		System.out.println("Hence 2 new categories are sucessfully created ");
		System.out.println("**************************");
		
	}

 
 @Test(priority = 6, groups = {"New_Expense_Addition_Bug_Catch"})
	
	public void New_Expense_Bug_catch() {
	 

	 
	//Go to Add expense to create new expense
		
			WebElement mmexpense1=driver.findElement(By.xpath(".//*[@id='go_add_expense']"));
			mmexpense1.click();
					
	//Add expense 1 routine 
			
	//Configure date 
	//Add day 
			
	WebElement Day1=driver.findElement(By.xpath(".//*[@id='day']"));
	Day1.sendKeys("09");
			    
	//Add Month 
	
	System.out.println("**************************");
	System.out.println("Test Case Six");
	System.out.println("In add Expense routine for Month field a Bug is noticed during automation");
	System.out.println("If we dont clear() the Month field before passing values to the field,it automatically appends 1 to the field value & thus test case 6 fails as below ");
	System.out.println("A workaround for this issue is implemented in next Test case 7 to enable us to test further app functions");
	System.out.println("**************************");	
	
	
	WebElement Month1=driver.findElement(By.xpath(".//*[@id='month']"));
	//Month1.clear();
	Month1.sendKeys("10");
			    
	//Add Year 
				
	WebElement Year1=driver.findElement(By.xpath(".//*[@id='year']"));
	Year1.sendKeys("2019");
			    
	// Select category from drop down menu  
				
	WebElement categoryselect = driver.findElement(By.xpath(".//*[@id='category']"));
			    
	Select C= new Select(categoryselect);
	C.selectByVisibleText("home expense");
				
	//  Configure expense amount 
			
    WebElement Amount1=driver.findElement(By.xpath(".//*[@id='amount']"));
    Amount1.sendKeys("10.00");	
		    
    //  Configure expense reason  
			
	WebElement reason1=driver.findElement(By.xpath(".//*[@id='reason']"));
	reason1.sendKeys("Internet");	
		    
	// expense submit 
			
	WebElement ex1submit=driver.findElement(By.xpath(".//*[@id='submit']"));
	ex1submit.click();
		 		
	//Go to Add expense to create new expense
				
	WebElement mmexpense2=driver.findElement(By.xpath(".//*[@id='go_add_expense']"));
	mmexpense2.click();
		 			 		
	//Add expense 2 routine 
				
	//Configure date 
				
	//Add day 
				
	WebElement Day2=driver.findElement(By.xpath(".//*[@id='day']"));
	Day2.sendKeys("05");
				    
	//Add Month 
				    
	WebElement Month2=driver.findElement(By.xpath(".//*[@id='month']"));
	//Month2.clear();
	Month2.sendKeys("10");
				  
	//Add Year 
					
	WebElement Year2=driver.findElement(By.xpath(".//*[@id='year']"));
	Year2.sendKeys("2019");
				    
	// Select category from drop down menu  
					
	WebElement categoryselect1 = driver.findElement(By.xpath(".//*[@id='category']"));
				    
	Select C2= new Select(categoryselect1);
	C2.selectByVisibleText("travel expense");
					
	//  Configure expense amount 
				
	WebElement Amount2=driver.findElement(By.xpath(".//*[@id='amount']"));
	Amount2.sendKeys("30.00");	
			    
	//  Configure expense reason  
				
	WebElement reason2=driver.findElement(By.xpath(".//*[@id='reason']"));
	reason2.sendKeys("Bus Travel");	
			    
	// expense submit 
				
	WebElement ex2submit=driver.findElement(By.xpath(".//*[@id='submit']"));
	ex2submit.click();
		 				
					
	// Verify new expenses are added successfully  	
			 	
   	String stitle = driver.findElement(By.xpath("html/body/div[1]/h1")).getText();
	String exp = "List Expenses:";
	AssertJUnit.assertEquals(stitle, exp);
	
	System.out.println("**************************");
	System.out.println("Test Case Six");
	System.out.println("Add expense page transitioned to List expenses page");
	System.out.println("Hence 2 new expenses are sucessfully added ");
	System.out.println("**************************");
	
	}
 

 @Test(priority = 7, groups = {"New_Expense_Addition_Bug_Workaround"})
	
	public void New_Expense_Bug_workaround() {
	 

	 
	//Go to Add expense to create new expense
		
	WebElement mmexpense1=driver.findElement(By.xpath(".//*[@id='go_add_expense']"));
	mmexpense1.click();
					
	//Add expense 1 routine 
			
	//Configure date 
	//Add day 
			
	WebElement Day1=driver.findElement(By.xpath(".//*[@id='day']"));
	Day1.sendKeys("09");
			    
	//Add Month 
	
	
	WebElement Month1=driver.findElement(By.xpath(".//*[@id='month']"));
	Month1.clear();
	Month1.sendKeys("1");
			    
	//Add Year 
				
	WebElement Year1=driver.findElement(By.xpath(".//*[@id='year']"));
	Year1.sendKeys("2019");
			    
	// Select category from drop down menu  
				
	WebElement categoryselect = driver.findElement(By.xpath(".//*[@id='category']"));
			    
	Select C= new Select(categoryselect);
	C.selectByVisibleText("home expense");
				
	//  Configure expense amount 
			
 WebElement Amount1=driver.findElement(By.xpath(".//*[@id='amount']"));
 Amount1.sendKeys("10.00");	
		    
 //  Configure expense reason  
			
	WebElement reason1=driver.findElement(By.xpath(".//*[@id='reason']"));
	reason1.sendKeys("Internet");	
		    
	// expense submit 
			
	WebElement ex1submit=driver.findElement(By.xpath(".//*[@id='submit']"));
	ex1submit.click();
		 		
	//Go to Add expense to create new expense
				
	WebElement mmexpense2=driver.findElement(By.xpath(".//*[@id='go_add_expense']"));
	mmexpense2.click();
		 			 		
	//Add expense 2 routine 
				
	//Configure date 
				
	//Add day 
				
	WebElement Day2=driver.findElement(By.xpath(".//*[@id='day']"));
	Day2.sendKeys("05");
				    
	//Add Month 
				    
	WebElement Month2=driver.findElement(By.xpath(".//*[@id='month']"));
	Month2.clear();
	Month2.sendKeys("1");
				  
	//Add Year 
					
	WebElement Year2=driver.findElement(By.xpath(".//*[@id='year']"));
	Year2.sendKeys("2019");
				    
	// Select category from drop down menu  
					
	WebElement categoryselect1 = driver.findElement(By.xpath(".//*[@id='category']"));
				    
	Select C2= new Select(categoryselect1);
	C2.selectByVisibleText("travel expense");
					
	//  Configure expense amount 
				
	WebElement Amount2=driver.findElement(By.xpath(".//*[@id='amount']"));
	Amount2.sendKeys("30.00");	
			    
	//  Configure expense reason  
				
	WebElement reason2=driver.findElement(By.xpath(".//*[@id='reason']"));
	reason2.sendKeys("Bus Travel");	
			    
	// expense submit 
				
	WebElement ex2submit=driver.findElement(By.xpath(".//*[@id='submit']"));
	ex2submit.click();
		 				
					
	// Verify new expenses are added successfully  	
			 	
	String stitle = driver.findElement(By.xpath("html/body/div[1]/h1")).getText();
	String exp = "List Expenses:";
	AssertJUnit.assertEquals(stitle, exp);
	
	System.out.println("**************************");
	System.out.println("Test Case Seven with Month field Clear() workaround for Add Expense Page ");
	System.out.println("This TC 7 has bug workaround for Month field issue noticed in test case 6");
	System.out.println("Add expense page transitioned with success to List expenses page");
	System.out.println("Hence 2 new expenses are successfully added ");
	System.out.println("**************************");
	
	}
 
 
 @Test(priority = 8, groups = {"Show_Statistics"})
	
	public void Show_Stats() {
	 
// Go to Show statistics routine
		
 WebElement showstats1=driver.findElement(By.xpath(".//*[@id='go_show_statistics']"));
 showstats1.click(); 
	 
 // Select month to display statistics from drop down menu  
	
 WebElement monthselect1 = driver.findElement(By.xpath("html/body/div[1]/div[1]/form/select"));
 
 Select M1= new Select(monthselect1);
 M1.selectByVisibleText("2019.01");	
					
// Verify Statistics are displayed  	
			 	
String stitle = driver.findElement(By.xpath("html/body/div[1]/div[1]/form/select")).getText();
String exp = "2019.01";
AssertJUnit.assertEquals(stitle, exp);
	
System.out.println("**************************");
System.out.println("Test Case Eight");
	System.out.println("List expenses page transitioned with success to Show stats page");
	System.out.println("And Monthwise Stats are displayed ");
	System.out.println("**************************");
	
	}

 @Test(priority = 9, groups = {"Edit_Account"})
	
	public void Edit_Account() {
	 
	//Go to edit account routine
		
	 WebElement editaccount1=driver.findElement(By.xpath(".//*[@id='editaccount']"));
	 editaccount1.click(); 
	 
	//edit password - send old password 
		
			WebElement oldpassword1=driver.findElement(By.xpath(".//*[@id='password']"));
			oldpassword1.sendKeys("test321");
			
			// new password
			WebElement newpassword1=driver.findElement(By.xpath(".//*[@id='newpassword1']"));
			newpassword1.sendKeys("test321");
			
	 	// repeat new password
			WebElement rnewpassword1=driver.findElement(By.xpath(".//*[@id='newpassword2']"));
			rnewpassword1.sendKeys("test321");
			
	    // update account submit		
			WebElement submit2=driver.findElement(By.xpath(".//*[@id='submit']"));
			submit2.click();
					
//Verify edit account is completed  	
			 	
			String stitle = driver.findElement(By.xpath("html/body/div[1]/h1")).getText();
			String exp = "List Expenses:";
			AssertJUnit.assertEquals(stitle, exp);
			
			System.out.println("**************************");
			System.out.println("Test Case Nine ");
			System.out.println("Edit Account Page transitioned to List expenses page");
			System.out.println("Hence Edit Account routine sucessfull ");
			System.out.println("**************************");
	} 

 
}





