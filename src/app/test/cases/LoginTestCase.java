package app.test.cases;

import org.testng.annotations.Test;

import config.UserInfoConfig;
import app.page.login.LoginPage;
import app.page.login.QuickLoginPage;
import app.page.login.RegisterPage;
import app.test.AppCaseTest;
import app.test.CasePageConst;

public class LoginTestCase extends AppCaseTest {
	
	private UserInfoConfig uic = UserInfoConfig.getInstance();
    
	@Test
	public void testLogin() {	
		((LoginPage)getPage(CasePageConst.LOGIN)).login(uic.getUserName(), uic.getLoginPwd());
	}
	
	@Test
	public void testOpenQuickLoginPage() {
		((LoginPage)getPage(CasePageConst.LOGIN)).openQuickLoginPage();
	}
	
	@Test
	public void testQuickLogin() {
		((QuickLoginPage)getPage(CasePageConst.QUCIK_LOGIN)).quickLogin("15400000088", "925486");	
	}
	
	@Test
	public void testRegister() {
		((RegisterPage)getPage(CasePageConst.REGISTER)).register("15400000088", uic.getLoginPwd(), "924586");
	}
	
	public void testForgetPwdLogin() {
	}

}
