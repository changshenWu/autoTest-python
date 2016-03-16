package app.page.login;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import app.page.BasePage;

public class QuickLoginPage extends BasePage { 
	
	private String mobilePhoneEditId = "";
	private String checkCodeEditId = "";
	private String loginBtnId = "";
	
	public QuickLoginPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	public void quickLogin(String mobilePhone,String checkCode) {
		sendKeys(1,mobilePhoneEditId, mobilePhone);
		sendKeys(1,checkCodeEditId, checkCode);
		click(1,loginBtnId);
	}

}
