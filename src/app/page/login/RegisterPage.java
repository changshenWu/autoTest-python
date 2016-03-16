package app.page.login;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

import app.page.BasePage;

public class RegisterPage extends  BasePage {
	
	//页面元素
	public RegisterPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	/**
	 * 有推荐码的注册
	 * */
	public void register(String mobilePhone, String pwd, String checkCode, String recommendCode) {
		
	}
	
	/**
	 *无推荐码的注册
	 * */
	public void register(String mobilePhone, String pwd, String checkCode) {
		
	}

}
