package junit;

import config.UserInfoConfig;
import junit.framework.TestCase;


public class UserInfoConfigTest extends TestCase {
   
	private UserInfoConfig userInfoConfig;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		userInfoConfig = UserInfoConfig.getInstance();	
	}
	
	public void testGetLoginPwd() {
		String loginPwd = userInfoConfig.getLoginPwd();
		assertEquals("qwerty", loginPwd);
	}
    
	public void testGetTradePwd() {
		String tradePwd = userInfoConfig.getTradePwd();
		assertEquals(tradePwd, "123456");
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	

}
