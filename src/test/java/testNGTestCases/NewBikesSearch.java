package testNGTestCases;

import org.testng.annotations.Test;

import pageObjects.UpcomingBikesPage;
import pageObjects.ZigWheelsHomePage;
import factory.BaseClass;

public class NewBikesSearch extends Setup {
	
	@Test(priority = 1,groups= {"regression","smoke"})
	public void NavigateToUpcomingBikes() throws Exception {
		ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
		ZWHP.HoveringNewBikes();
		ZWHP.ClickingUpcomingBikes();
		BaseClass.getLogger().info("----Successfully clicked on the upcoming Bikes----");
	}
	
	@Test(priority = 2,groups= {"regression","smoke"})
	public void UpcomingBikes() throws Exception  {
		UpcomingBikesPage UBP = new UpcomingBikesPage(BaseClass.getDriver());
		
		UBP.SelectBrand();
		UBP.load();
		UBP.UpcomingBike();
		BaseClass.getLogger().info("----Successfully printed the details of the upcoming bikes----");
	}
}