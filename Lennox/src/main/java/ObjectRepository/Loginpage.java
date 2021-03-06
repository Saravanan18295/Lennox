package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {


		public static WebDriver driver;

		public Loginpage() {
		PageFactory.initElements(driver, this);

//			this.driver = driver;
		}
		
			@FindBy(id = "j_username")
			WebElement useridtxtbox;

			@FindBy(id = "j_password")
			WebElement passwordtxtbox;

			@FindBy(id = "loginSubmit")
			WebElement loginSubmit;
			

public WebElement userid() {

	return useridtxtbox;
}

public WebElement password() {

	return passwordtxtbox;
}

public WebElement submit() {

	return loginSubmit;
}
}
