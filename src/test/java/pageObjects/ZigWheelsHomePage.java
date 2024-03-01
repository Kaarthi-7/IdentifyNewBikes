package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ZigWheelsHomePage extends BasePage {
	WebDriver Driver;
	public ZigWheelsHomePage(WebDriver driver) {
		super(driver);
	}	
	
	//Elements
	@FindBy(xpath = "//img[@data-track-label='zw-header-logo']")
	WebElement ZigWheelsLogo;
	
	@FindBy(xpath = "//a[@href='/newbikes']")
	WebElement NewBike;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement UpComingBike;
	
	@FindBy(xpath = "//a[@href='/used-car']")
	WebElement UsedCars;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement UsedCarsChennai;
	
	@FindBy(id = "forum_login_title_lg")
	WebElement Login;
	
	@FindBy(xpath = "//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement Google;
	
	public void pageLogo() {
		ZigWheelsLogo.isDisplayed();
		System.out.println("Zigwheels logo is displayed");
	}
	
	public void NavigateBack() {
		ZigWheelsLogo.click();
	}
	
	public void HoveringNewBikes() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(NewBike).perform();
		Thread.sleep(1000);
	}
	
	public void ClickingUpcomingBikes() {
		UpComingBike.click();
	}
	
	public void HoveringUsedCars() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(UsedCars).perform();
		Thread.sleep(1000);
	}
	
	public void ClickingUsedCarsInChennai() {
		UsedCarsChennai.click();
	}
	
	public void SignIn() throws Exception {
		Login.click();
		Thread.sleep(3000);
	}
	
	public void Google() {
		Google.click();
	}
}
