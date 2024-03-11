package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtilities;

public class UpcomingBikesPage extends BasePage{

	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "makeId")
	WebElement Brand;
	
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement ShowMore;
	
	@FindBy(xpath = "//strong[@class='lnk-hvr block of-hid h-height']")
	List<WebElement> BikeNameList;
	
	@FindBy(xpath = "//div[@class='b fnt-15']")
	List<WebElement> BikePriceList;
	
	@FindBy(xpath = "//div[@class='clr-try fnt-14']")
	List<WebElement> BikeReleaseDate;
	
	@FindBy(xpath = "//div[@class='i-b mid-sec']//div[@class='d-tbl']")
	WebElement Scroll1;
	
	public void SelectBrand() {
		Select select = new Select(Brand);
		select.selectByVisibleText("Honda");
	}
	
//	public void load() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()",Scroll1);
//		ShowMore.click();
//	}
	
	public void load() throws Exception {
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,1350)", "");
		Thread.sleep(5000);
		ShowMore.click();
	}
	
	public void UpcomingBike() throws Exception {
		int j=1;
		List<String> prices = new ArrayList<String>();
		float fixedPrice = 4.00f;
		for(WebElement price : BikePriceList) {
			prices.add(price.getText());
		}
		for(int i=0; i<BikeNameList.size(); i++) {
			
			String BikeName = BikeNameList.get(i).getText();
			String BikePrice = BikePriceList.get(i).getText();
			String BikeRelease = BikeReleaseDate.get(i).getText().replace("Launch Date : ", "");
			ExcelUtilities EU = new ExcelUtilities();
			if(prices.get(i).contains("Lakh")) {
				String[] price = prices.get(i).split(" ");
				float pricing = Float.parseFloat(price[1]);
				
				if(pricing<=fixedPrice) {
					System.out.println(BikeName);
					System.out.println(BikePrice);
					System.out.println(BikeRelease);
					System.out.println("==================================================");
					EU.write(j,0,BikeName);
					EU.write(j,1,BikePrice);
					EU.write(j,2,BikeRelease);
					j++;
				}
			}else {
				String[] price = prices.get(i).replaceAll(",", "").split(" ");
				int pricing = Integer.parseInt(price[1]);
				if(pricing>0 && pricing < 99999) {
					System.out.println(BikeNameList.get(i).getText());
					System.out.println(BikePriceList.get(i).getText());
					System.out.println(BikeReleaseDate.get(i).getText());
					System.out.println("==================================================");
					EU.write(j,0,BikeName);
					EU.write(j,1,BikePrice);
					EU.write(j,2,BikeRelease);
					j++;
				}
			}
		}
	}
}
