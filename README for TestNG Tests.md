
Friendsurance-Expense-Tracker-App-Automation-Tests-by-Abhijit-Malankar-11-June-2019 MSc Engg TU Berlin

Test Set up Requirements for Testing this folder is  

1) Eclipse IDE -  with Testng & Selenium Libraries & dependencies loaded . 
2) Firefox Browser 

This Test NG Folder contains 

2 Tests Scripts which run on a Firefox Browser located in path -

<Friendsurance-Expense-Tracker-App-Automation-Tests-by-Abhijit-Malankar-11-June-2019/Testng_Expense_Tracker_App_Test/src/FA_Test/>


1) Expense_Tracker_App_TestNG_Test.java - For End to End Tests of Expense Tracker App  - which can be run in 2 ways 



     a) As TestNG - Test Suite - By Right Click on the Testng.xml file in this folder and selecting to "run as a Test NG suite" 
     
     
     b) As TestNG Test file - in Eclipse right click - from the Class location - and selecting to "run as a TestNG Test" 
     
     Important Note : Prerequisite for Tests -  
     Before running both of the above scenarios - Please open the class file of "Expense_Tracker_App_TestNG_Test.java & edit the "username" 
     field on the line no - 105 <username.sendKeys("<username>");> , so that an existing user is not replicated again . 
     This test can be run only once with one unique user at the moment , this user has to be changed for each test run to get proper results.
 
     This test has one failing test for bug catch in one of the group for "Add Expense" which has been again implemented within another 
     group with teh bug work around to test remaining scenarios . Please refer the console message at end of the test 
     
     Testng Test Reports can be observed in 3 locations after the test is run (+ file/refresh) within the Test-Output sub folder  
 
      a) emailable-report.html  - open with web browser 
      b) Index.html - open with web browser 
      c) Console messages
      
      
 
 2) Expense_Trac_TestNG_DataProvider_Ex.java - Example of Data Provider parametrization which can be used to pass multiple parameters to 
    test all text fields in the expense tracker app for scenarios including for - positive , negative , exploratory etc . 
    
        
    As an example this is implemented for just testing the "Register New User Routine" using the Data Provider . 
    
    This can be run as 
     a) As TestNG Test file - in Eclipse right click - from the Class location - and selecting to "run as a TestNG Test" 
     
     Important Note : Prerequisite for Test-  
     Before running this test - Please open the class file of "Expense_Trac_TestNG_DataProvider_Ex.java & edit the "username" 
     field on the line no - 81- <new Object[] {"TC01" ,"username", "12345" , "12345" },> , so that an existing user is not replicated again . 
     This test can be run only once with one unique user at the moment , this user has to be changed for each test run to get proper results.
 
     Testng Test Reports can be observed in 3 locations after the test is run (+ file/refresh) within the Test-Output sub folder  
 
      a) emailable-report.html  - open with web browser 
      b) Index.html - open with web browser 
      c) Console messages
     
     
     In case of any questions , please get in touch on email - abhiam1@gmail.com or skype - abhiam11 
     
     Thanks . 
     Abhijit Malankar 
     MSc Engg TU Berlin 
     
     
     
     
     

