package ObjectRepository;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lennoxpropage {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static WebDriver driver;

		public Lennoxpropage() {
		PageFactory.initElements(driver, this);

//			this.driver = driver;
		}
				
			@FindBy(id = "firstName")
			WebElement Fname;

			@FindBy(id = "lastName")
			WebElement Lname;
			
			@FindBy(id = "phNo")
			WebElement Mobile;

			@FindBy(xpath = "//input[@id='email']")
			WebElement Email;

			@FindBy(id = "calender1")
			WebElement Date;

			@FindBy(id = "scheduleRequestTime")
			WebElement Time;

			@FindBy(xpath = "//p[@class='m-0 add-document']")
			WebElement Adddocuments;
			
			@FindBy(xpath = "(//*[@class = 'styled-select documents'])[2]")
			WebElement Selectdoctype;

			@FindBy(xpath = "(//option[@value='MANUAL_J_REPORT'])[2]")
			WebElement doctype;
			
			@FindBy(id = "multipleFileSelect-1")
			WebElement selectfile;

			@FindBy(id = "multipleImageSelect[0]")
			WebElement imageupload;

			@FindBy(xpath = "//span[contains(text(),'Add To Lead')]")
			WebElement addtolead;

			@FindBy(id = "btn-addLeadsForm")
			WebElement Savelead;
		
			
public WebElement Savelead() {
	
	return Savelead;
}

public WebElement Adddocuments() {
	
	return Adddocuments;
}
public WebElement addtolead() {
	
	return addtolead;
}
public WebElement Selectdoctype() {
	
	return Selectdoctype;
}

public WebElement imageupload() {
	
	return imageupload;
}

public WebElement doctype() {
	
	return doctype;
}

public WebElement selectfile() {
	
	return selectfile;
}

public WebElement Fname() {
	
	return Fname;
}

public WebElement Lname() {
	
	return Lname;
}

public WebElement Mobile() {
	
	return Mobile;
}

public WebElement Email() {
	
	return Email;
}


public WebElement Date() {
	
	return Date;
}


public WebElement Time() {
	
	return Time;
}


}
