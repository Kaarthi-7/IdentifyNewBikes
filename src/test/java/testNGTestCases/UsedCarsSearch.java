package testNGTestCases;

import org.testng.annotations.Test;

import pageObjects.UsedCarPage;
import pageObjects.ZigWheelsHomePage;
import factory.BaseClass;

public class UsedCarsSearch extends NewBikesSearch{

	@Test(priority = 3,groups= {"regression"})
	public void navigateToUsedCars() throws Exception {
		ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
		ZWHP.NavigateBack();
		ZWHP.HoveringUsedCars();
		ZWHP.ClickingUsedCarsInChennai();
		BaseClass.getLogger().info("----Successfully clicked on the Used Cars----");
	}
	
	@Test(priority = 4,groups= {"regression"})
	public void usedCars() throws Exception {
		UsedCarPage UCP = new UsedCarPage(BaseClass.getDriver());
		
		UCP.UsedCarBrand();
		BaseClass.getLogger().info("----Successfully displayed the car brand name----");
	}
}
