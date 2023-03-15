package com.liveguru.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneraterManage;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_07_User_01_Apply_Page_Generater_Manage_II extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getRandomEmail();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
	private String firstname , lastname, invalidEmail, notFoundEmail, password, invalidPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName,"");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("");
		
}
	
	@Test
	public void User_01_Register_To_System() {
		
	}
	
	@Test
	public void User_02_Login_To_System() {

	}
	
}
