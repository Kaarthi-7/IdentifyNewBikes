package testNGTestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pageObjects.GoogleSigninPage;
import pageObjects.ZigWheelsHomePage;
import factory.BaseClass;

public class SignInPage extends UsedCarsSearch{
	
	@Test(priority = 5,groups= {"regression","smoke"})
	public void ClickonSignIn() throws Exception {
		ZigWheelsHomePage ZWHP = new ZigWheelsHomePage(BaseClass.getDriver());
		ZWHP.NavigateBack();
		ZWHP.SignIn();
		ZWHP.Google();
		List<String> handleList = new ArrayList<String>(BaseClass.getDriver().getWindowHandles());
		BaseClass.getDriver().switchTo().window(handleList.get(1));
		Thread.sleep(5000);
		BaseClass.getLogger().info("----Successfully clicked on the google----");
	}
	
	@Test(priority = 6,groups= {"regression","smoke"})
	public void captureSigninError() throws Exception {
		GoogleSigninPage GSP = new GoogleSigninPage(BaseClass.getDriver());
		GSP.Signin();
		GSP.CaptureError();
		BaseClass.getLogger().info("----Successfully captured the Error message----");
	}
}
