package Lennox;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.Homepage;
import ObjectRepository.Lennoxpropage;
import ObjectRepository.Loginpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

  public class CodingRound{
	ExtentReports extent;
	ExtentTest logger;
		  
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	WebDriver driver;

	String today;
	String testcasename;

	@BeforeTest
	public void openbrowser() throws InterruptedException {
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/QAAutomationInterview.html", true);
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial")
              .addSystemInfo("Environment", "Automation Testing")
              .addSystemInfo("User Name", "Saravanan P");
		 extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
		

	@Test(priority = 0)
	public void LaunchandLogin() throws IOException, InterruptedException {
		
		logger = extent.startTest("passTest");
	
		try {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		// Initialize browser.
		System.setProperty("webdriver.chrome.silentOutput", "true");
	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.liidaveqa.com/");	
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains("Homepage"));	
		
		//POM refers
		Loginpage.driver = driver;
		Homepage.driver = driver;
		Homepage.sheet = sheet;
		Homepage.cell = cell;
		Lennoxpropage.driver = driver;
		Lennoxpropage.sheet = sheet;
		Lennoxpropage.cell = cell;
		
		// Import excel sheet.
		File src = new File("TestData.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load the workbook.l
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		
		Homepage homeobj = new Homepage();
		Loginpage Loginobj = new Loginpage();

		//Click signin
		wait.until(ExpectedConditions.elementToBeClickable(homeobj.Clicksign()));	
		homeobj.Clicksign().click();
		wait.until(ExpectedConditions.titleContains("Login"));	

		//Entering user id
		cell = sheet.getRow(1).getCell(0);
		cell.setCellType(CellType.STRING);
		String useridval = cell.getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(Loginobj.userid()));	
		
		Loginobj.userid().sendKeys(useridval);
		
		//Entering user id
		cell = sheet.getRow(1).getCell(1);
		cell.setCellType(CellType.STRING);
		String passwordval = cell.getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(Loginobj.password()));	

		Loginobj.password().sendKeys(passwordval);

		//Submit
		wait.until(ExpectedConditions.elementToBeClickable(Loginobj.submit()));
		Loginobj.submit().click();
		wait.until(ExpectedConditions.titleContains("Homepage"));	
		screenshot("Passed" + "Login", driver);
		}
		catch(Exception e) {
			logger.log(LogStatus.FAIL, e);		
			screenshot("Failed" + "Login", driver);
		}
	}

	@Test(priority = 1)
	public void CreateLead() throws IOException, InterruptedException {
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Homepage homeobj = new Homepage();
		
		logger = extent.startTest("CreateLead");
		
		cell = sheet.getRow(1).getCell(2);
		cell.setCellType(CellType.STRING);
		String navigation= cell.getStringCellValue();
		
	try {
	System.out.println("Yes");
	WebElement navigate = driver.findElement(By.xpath("//*[@href = '"+ navigation +"']"));
	wait.until(ExpectedConditions.elementToBeClickable(navigate));
	navigate.click();
	
	cell = sheet.getRow(1).getCell(3);
	cell.setCellType(CellType.STRING);
	String navigation1= cell.getStringCellValue();
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//*[contains(text(),'"+navigation1+"')])[1]")));
	WebElement navisalestools = driver.findElement(By.xpath("(//*[contains(text(),'"+navigation1+"')])[1]"));
	wait.until(ExpectedConditions.elementToBeClickable(navisalestools));
	navisalestools.click();
	
	cell = sheet.getRow(1).getCell(4);
	cell.setCellType(CellType.STRING);
	String navigation2= cell.getStringCellValue();
	
	WebElement Build = driver.findElement(By.xpath("//*[contains(text(),'"+navigation2+"')]"));
	wait.until(ExpectedConditions.elementToBeClickable(Build));
	Build.click();
	
	wait.until(ExpectedConditions.visibilityOfAllElements(homeobj.SelectLead()));
	wait.until(ExpectedConditions.elementToBeClickable(homeobj.SelectLead()));
	Thread.sleep(2000);
	homeobj.SelectLead().click();
	wait.until(ExpectedConditions.elementToBeClickable(homeobj.Addlead()));
	homeobj.Addlead().click();
	screenshot("Passed" + "Add Lead", driver);
	}
	
	catch(Exception e) {
		System.out.println(e);
		logger.log(LogStatus.FAIL, e);		
		screenshot("Failed" + "Add Lead", driver);
	}
}


	@Test(priority = 2)
	public void CreateNew() throws IOException, InterruptedException {
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Lennoxpropage lenoxpage = new Lennoxpropage();
		
		logger = extent.startTest("CreateNew");

		try {
		//First Name
		cell = sheet.getRow(1).getCell(5);
		cell.setCellType(CellType.STRING);
		String Fnameval= cell.getStringCellValue();
				
		lenoxpage.Fname().clear();
		lenoxpage.Fname().sendKeys(Fnameval);
		
		//Last Name
		cell = sheet.getRow(1).getCell(6);
		cell.setCellType(CellType.STRING);
		String Lnameval= cell.getStringCellValue();
		
		lenoxpage.Lname().clear();
		lenoxpage.Lname().sendKeys(Lnameval);

		//Mobile Number
		cell = sheet.getRow(1).getCell(7);
		cell.setCellType(CellType.STRING);
		String Mobileval= cell.getStringCellValue();
		
		lenoxpage.Mobile().clear();
		lenoxpage.Mobile().sendKeys(Mobileval);

		//Email id
		cell = sheet.getRow(1).getCell(8);
		cell.setCellType(CellType.STRING);
		String Emailval= cell.getStringCellValue();
		
		lenoxpage.Email().clear();
		lenoxpage.Email().sendKeys(Emailval);
		
		//Handling Calendar
		WebElement dateele = lenoxpage.Date();
	    js.executeScript("arguments[0].scrollIntoView(true);", dateele);

	    Thread.sleep(1000);
	    dateele.click();
	 
	   /* //If we want to use current date using java, then below method will work
		today = getCurrentDay();
		System.out.println("Today's date : " + today + "\n");
		*/
		
	    cell = sheet.getRow(1).getCell(9);
		cell.setCellType(CellType.STRING);
		String Monthvalue = cell.getStringCellValue();
	
		cell = sheet.getRow(1).getCell(10);
		cell.setCellType(CellType.STRING);
		String Dateval = cell.getStringCellValue();
		
		while(true) {
	    	
	    	String month = driver.findElement(By.xpath("//div[@class=\"ui-datepicker-title\"]")).getText();
	    	
	    	if(month.contains(Monthvalue)) {
	    		break;
	    	}else {
	    		
	    	driver.findElement(By.xpath("//a[@data-handler='next']")).click();
	    	}
	    }
	    
		WebElement selectdate = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		WebElement expdate = selectdate.findElement(By.xpath("//a[contains(text(),'"+ Dateval +"')]"));
		expdate.click();
	
		//Handling Time
		cell = sheet.getRow(1).getCell(11);
		cell.setCellType(CellType.STRING);
		String Timeeval = cell.getStringCellValue();
	
		lenoxpage.Time().click();
		
		WebElement selecttime = lenoxpage.Time().findElement(By.xpath("//option[contains(text(),'"+Timeeval+"')]"));
		selecttime.click();
	
		//Scroll to Add Documents
		WebElement Adddocumentsicon = lenoxpage.Adddocuments();
	    js.executeScript("arguments[0].scrollIntoView(true);", Adddocumentsicon);
	    
	    cell = sheet.getRow(1).getCell(12);
		cell.setCellType(CellType.STRING);
		String Adddocumentscheck = cell.getStringCellValue();
		
		if(Adddocumentscheck!=null) {
			wait.until(ExpectedConditions.elementToBeClickable(Adddocumentsicon));
			Adddocumentsicon.click();
		
//			wait.until(ExpectedConditions.visibilityOfAllElements(lenoxpage.Selectdoctype()));
//			wait.until(ExpectedConditions.elementToBeClickable(lenoxpage.Selectdoctype()));
			Thread.sleep(5000);	
			WebElement selecttype = lenoxpage.Selectdoctype();
			selecttype.click();
			
//			js.executeScript("arguments[0].click();", selecttype);
			//actions.moveToElement(lenoxpage.Selectdoctype()).click().build().perform();
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			lenoxpage.doctype().click();
			
//			wait.until(ExpectedConditions.visibilityOf(lenoxpage.selectfile()));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			lenoxpage.selectfile().click();
			actions.moveToElement(lenoxpage.selectfile()).click().build().perform();

			//Handle file explorer using AUtoIT
		  	Thread.sleep(5000);
		  	Process p = Runtime.getRuntime().exec("C:\\Users\\saravanan.pazhani\\eclipse-workspace\\Lennox\\Documents\\AutoITScript.exe" );
			p.waitFor();
		  	Thread.sleep(3000);
		  	
			wait.until(ExpectedConditions.elementToBeClickable(lenoxpage.addtolead()));
		  	Thread.sleep(4000);
			actions.moveToElement(lenoxpage.addtolead()).click().build().perform();
		}
		else {
			System.out.println("Document is not required");
			logger.log(null, "Document is not required");
			}
	

	    cell = sheet.getRow(1).getCell(13);
		cell.setCellType(CellType.STRING);
		String Addimagescheck = cell.getStringCellValue();
		
			if(Addimagescheck!=null) {
				js.executeScript("arguments[0].scrollIntoView(true);", Adddocumentsicon);
//			    wait.until(ExpectedConditions.elementToBeClickable(lenoxpage.imageupload()));
//				lenoxpage.imageupload().click();
				Thread.sleep(2000);
				actions.moveToElement(lenoxpage.imageupload()).click().build().perform();

				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
//				
				//Handle file explorer using AUtoIT
			  	Thread.sleep(2000);
			  	Process p1 = Runtime.getRuntime().exec("C:\\Users\\saravanan.pazhani\\eclipse-workspace\\Lennox\\Documents\\imgupload.exe" );
				p1.waitFor();
			  	Thread.sleep(2000);

		}
			
		else {
			System.out.println("Image is not required");
			logger.log(null, "Image is not required");
			}
		
			lenoxpage.Savelead().click();
			
			Thread.sleep(2000);
			wait.until(ExpectedConditions.titleContains("LennoxPRO"));	
			Thread.sleep(10000);
			WebElement global = driver.findElement(By.id("globalMessages"));
			System.out.println(global.getText());	
			System.out.println(global.isDisplayed());	
			Assert.assertTrue(global.getText().equalsIgnoreCase("Lead Saved Successfully"));
			Assert.assertTrue(driver.getPageSource().contains(Fnameval));
			Assert.assertTrue(driver.getPageSource().contains(Emailval));
			
			screenshot("Passed" + "Create Lead", driver);
			}

		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.log(LogStatus.FAIL, e.getMessage());		
			screenshot("Failed" + "Create Lead", driver);
		}
	}	
	
		@AfterMethod
		public void getResult(ITestResult result){
			
			if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
			}
			else if(result.getStatus() == ITestResult.FAILURE){
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			}else if(result.getStatus() == ITestResult.SKIP){
				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			}
			
			extent.endTest(logger);
		}
		
		@AfterTest
		public void endReport(){
			extent.flush();
	        extent.close();
			
		driver.close();
		
		//Actually i don't have credit card to create a personal Microsoft Azure account, that's why i didn't integrated with Azure.

		}
  

		private String getCurrentDay() {
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			 
	        //Get Current Day as a number
	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	        //System.out.println("Today Int: " + todayInt +"\n");
	 
	        //Integer to String Conversion
	        String todayStr = Integer.toString(todayInt);
	        //System.out.println("Today Str: " + todayStr + "\n");
	 
	        return todayStr;
		}

		public void screenshot(String testcasename, WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destFile = System.getProperty("user.dir") + "\\Screenshots\\" + testcasename + ".png";
			FileUtils.copyFile(source, new File (destFile));
			}

  }