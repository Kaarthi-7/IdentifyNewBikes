package cucumberStepDefinition;

import java.util.ArrayList;
import java.util.List;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GoogleSigninPage;
import pageObjects.ZigWheelsHomePage;

public class SignInPage {
	
	@When("Open signin using google page")
	public void open_signin_using_google_page() throws Exception {
		ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
		ZWHP.NavigateBack();
		ZWHP.SignIn();
		ZWHP.Google();
		List<String> handleList = new ArrayList<String>(BaseClass.getDriver().getWindowHandles());
		for(String handle : handleList) {
			System.out.println(handle);
		}
		BaseClass.getDriver().switchTo().window(handleList.get(1));
		Thread.sleep(5000);
		BaseClass.getLogger().info("----Opened the sign In using google page----");
	}

	@Then("Capturing error")
	public void capturing_error() throws Exception {
		GoogleSigninPage GSP = new GoogleSigninPage(BaseClass.getDriver());
		GSP.Signin();
		GSP.CaptureError();
		BaseClass.getLogger().info("----Captured the error successfully----");
	}
}
