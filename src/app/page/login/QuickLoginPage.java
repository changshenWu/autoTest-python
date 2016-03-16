package app.page.login;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import app.page.BasePage;

public class QuickLoginPage extends BasePage { 
	
	private String mobilePhoneEditId = "";
	private String checkCodeEditId = "";
	private String loginBtnId = "";
	
	public QuickLoginPage(AppiumDriver<WebElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
	}
	
	public void quickLogin(String mobilePhone,String checkCode) {
		sendKeys(1,mobilePhoneEditId, mobilePhone);
		sendKeys(1,checkCodeEditId, checkCode);
		click(1,loginBtnId);
	}

}
