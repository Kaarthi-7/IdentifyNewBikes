package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtilities;

public class GoogleSigninPage extends BasePage {
	WebDriver Driver;
	public GoogleSigninPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "identifierId")
	WebElement Username;
	
	@FindBy(xpath = "//div[@class='o6cuMc Jj6Lae\']")
	WebElement error;
	
	public void Signin() {
		Username.click();
		Username.sendKeys("abc@gmail.com");
		Username.sendKeys(Keys.ENTER);
	}
	
	public void CaptureError() throws Exception {
		ExcelUtilities EU = new ExcelUtilities();
		Thread.sleep(5000);
		System.out.println(error.getText());
		EU.write(1,4,error.getText());
	}
}