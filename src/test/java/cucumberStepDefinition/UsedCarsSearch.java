package cucumberStepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UsedCarPage;
import pageObjects.ZigWheelsHomePage;
import factory.BaseClass;

public class UsedCarsSearch {
	
	@When("Navigating to used cars")
	public void navigating_to_used_cars() throws Exception {
		ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
		ZWHP.NavigateBack();
		ZWHP.HoveringUsedCars();
		ZWHP.ClickingUsedCarsInChennai();
		BaseClass.getLogger().info("----Successfully navigated to Used Cars----");
		
	}

	@Then("popular models of used cars")
	public void popular_models_of_used_cars() throws Exception {
		UsedCarPage UCP = new UsedCarPage(BaseClass.getDriver());
		
		UCP.UsedCarBrand();
		BaseClass.getLogger().info("----Successfully printed the details of the popular car models----");
	}
}
