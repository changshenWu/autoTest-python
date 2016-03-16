package app.page.login;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import app.page.BasePage;

/**
 * 封装了登录页的业务逻辑：
 * 1.登录；2.打开快捷登录页;3.打开忘记密码页
 * @param <T>
 * */
public class LoginPage extends BasePage {
	
	private String nameEditId = "";
	private String pwdEditId = "";
	private String loginBtnId = "";
	private String quickLoginTextId = "";
	private String forgetPwdTextId = "";
    
	public LoginPage (AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	/**
	 *用户登录
	 * */
	public void login(String userName,String loginPwd) {
		sendKeys(1, nameEditId, userName);
		sendKeys(1,pwdEditId, loginPwd);
		click(1,loginBtnId);
	}
	
	/**
	 * 打开快捷登录页
	 * @return QuickLoginPage object
	 * */
	public QuickLoginPage openQuickLoginPage () {
		click(1,quickLoginTextId);
		return new QuickLoginPage(driver);
	}
	
	/**
	 * 打开忘记密码登录页
	 * @return ForgetPwdLoginPage object
	 * */
	public ForgetPwdLoginPage openForgetPwdLoginPage() {
		click(1,forgetPwdTextId);
		return new ForgetPwdLoginPage(driver);
	}
	

}
