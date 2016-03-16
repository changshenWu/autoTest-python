package app.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import app.page.BasePage;
import app.page.login.LoginPage;
import app.page.login.QuickLoginPage;
import app.page.login.RegisterPage;
import config.ConfigConst;
import config.DeviceConfig;

public class AppCaseTest {

	public AppiumDriver<WebElement> driver;

	@BeforeMethod(alwaysRun=true)
	public void setup() throws MalformedURLException { 
		DeviceConfig config  = new DeviceConfig();
		URL connectUrl  = new URL(ConfigConst.CONNECT_APPIUM_SERVER_URL);
		driver = new AndroidDriver<WebElement>(connectUrl, config.getDesiredCapabilities());
		System.out.println(driver.getPageSource());
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {
		driver.quit();
	}


	/**
	 *获取相关页面对象
	 *@param pageName 页面名称
	 * */
	public BasePage getPage(String pageName) {
		BasePage basePage = null;
		if (pageName.equals(CasePageConst.LOGIN)) { 
			basePage =	new LoginPage(driver);
			return (LoginPage)basePage;
		} else if (pageName.equals(CasePageConst.REGISTER)) {
			basePage = new RegisterPage(driver);
			return  (RegisterPage)basePage;
		} else if(pageName.equals(CasePageConst.QUCIK_LOGIN)) {
			basePage = new QuickLoginPage(driver);
			return (QuickLoginPage)basePage;
		} else {
			return basePage;
		}
	}

}
