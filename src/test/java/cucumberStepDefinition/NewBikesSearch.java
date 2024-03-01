package cucumberStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UpcomingBikesPage;
import pageObjects.ZigWheelsHomePage;
import factory.BaseClass;

public class NewBikesSearch extends BaseClass{
	//WebDriver driver;
	@Given("user is on ZigWheels.com website")
	public void Website() {
		if(BaseClass.getDriver().getTitle().equals("New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com"));
		System.out.println("Correct website is Launched");
	}
	
    @And("verifying the logo of webpage")
    public void logo() {
    	ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
    	ZWHP.pageLogo();
    	BaseClass.getLogger().info("----Successfully clicked on the Page Logo----");
    	
    }
    
	@When("Navigating to upcoming bikes")
	public void navigating_to_upcoming_bikes() throws Exception {
		ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
		ZWHP.HoveringNewBikes();
		ZWHP.ClickingUpcomingBikes();
		BaseClass.getLogger().info("----Successfully navigated on the Upcoming Bikes----");
	}

	@Then("Informations of upcoming bikes")
	public void informations_of_upcoming_bikes() throws Exception {
		UpcomingBikesPage UBP = new UpcomingBikesPage(BaseClass.getDriver());
		
		UBP.SelectBrand();
		UBP.load();
		Thread.sleep(2000);
		UBP.UpcomingBike();
		BaseClass.getLogger().info("----Successfully printed the details of upcoming bikes----");
	}
}
