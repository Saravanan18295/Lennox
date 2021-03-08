package ObjectRepository;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	

		public static WebDriver driver;

		public Homepage() {
		PageFactory.initElements(driver, this);

//			this.driver = driver;
		}
				
			@FindBy(xpath = "//a[@class='login-link btn NEEDS_AUTHENTICATION']")
			WebElement Clicksignin;

			@FindBy(xpath = "//*[contains(text(),'SELECT LEAD')]")
			WebElement SelectLead;
			
			@FindBy(xpath = "//a[@class='btn btn-primary hide-mobile introjs-l-9 introjs-l-83']")
			WebElement Addlead;

			@FindBy(xpath = "//span[@class='signedin-user']")
			WebElement Signeduser;
			
			@FindBy(id = "logout_id")
			WebElement Logout;

public WebElement Signeduser() {

	return Signeduser;
}

public WebElement Logout() {

	return Logout;
}

public WebElement Clicksign() {

	return Clicksignin;
}

public WebElement SelectLead() {

	return SelectLead;
}


public WebElement Addlead() {

	return Addlead;
}

}
