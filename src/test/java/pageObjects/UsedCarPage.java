package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtilities;

public class UsedCarPage extends BasePage{

	public UsedCarPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='gsc_thin_scroll']/ul/li")
	List <WebElement> PopularModelList;
	
	public void UsedCarBrand() throws Exception {
		ExcelUtilities EU = new ExcelUtilities();
		System.out.println("Popular Model List: ");
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,500)", "");
		int i=0;
		for(WebElement brand : PopularModelList) {
			System.out.println(brand.getText());
			EU.write(++i,3,brand.getText());
		}
		System.out.println("==================================================");
	}
}
