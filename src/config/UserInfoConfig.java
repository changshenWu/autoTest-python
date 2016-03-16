package config;

import util.parse.Excel;
import jxl.Sheet;

/**
 * 测试账户用户的配置信息类
 * */
public class UserInfoConfig {

	/**
	 *用户名
	 * */
	private String userName;
	/**
	 *登录密码
	 * */
	private String loginPwd = null;
	/**
	 *交易密码
	 * */
	private String tradePwd = null;
	/**
	 *绑定的手机号
	 * */
	private String mobilePhone = null;
	/**
	 *银行卡号
	 * */
	private String bankId = null;
	/**
	 *支行名称
	 * */
	private String bankName = null;
	/**
	 *用户身份证号
	 * */
	private String id = null;
	/**
	 *用户身份证号对应的真实姓名
	 * */
	private String actualName = null;
	/**
	 *银行卡号所属银行
	 * */
	private String bankType = null;


	public static UserInfoConfig getInstance() {
		return new UserInfoConfig();
	}

	private UserInfoConfig () { 
		init(); 
	}

	/**
	 * 获取用户的登录名
	 * */
	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		//不用修改用户
		this.userName = userName;
	}

	/**
	 * 获取用户的登录密码
	 * */
	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	/**
	 * 获取用户的交易密码
	 * */
	public String getTradePwd() {
		return tradePwd;
	}

	public void setTradePwd(String tradePwd) {
		this.tradePwd = tradePwd;	
	}

	/**
	 * 获取用户的已绑定的手机号
	 * */
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * 获取用户已绑定的银行卡号
	 * */
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * 获取用户的身份证号
	 * */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取用户的身份证号对应的真实姓名
	 * */
	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	/**
	 * 获取用户已绑定的银行卡的支行名称
	 * */
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	private void init() {
		Excel excel = new Excel(ConfigConst.CONFIG_FILE_PATH);
		Sheet userInfoSheet = excel.getSheetByName(ConfigConst.USERINFO_SHEET_NAME);
		//列数
		int columns = userInfoSheet.getColumns();
		//行数
		int rows = userInfoSheet.getRows();
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//getcell(列的索引值,行的索引值)
				String content = excel.getCellContent(userInfoSheet, i, j);
				//System.out.println(content);
				switch (j) {
				case 0:
					//第1列为登录名
					setUserName(content);
					break;
				case 1:
					//第2列为登录密码
					setLoginPwd(content);
					break;
				case 2:
					//第3列为交易密码
					setTradePwd(content);
					break;
				case 3:
					//第4列为身份证号
					setId(content);
					break;
				case 4:
					//第5列为真实姓名
					setActualName(content);
					break;
				case 5:
					//第6列为银行卡号
					setBankId(content);
					break;
				case 6:
					//第7列为支行名称
					setBankName(content);
					break;
				case 7:
					//第8列为支行信息
					setBankType(content);
				case 8:
					//第9列为手机号码
					setMobilePhone(content);
					break;
				default:
					break;
				}
			}
		}
	}

	/*public static void main(String[] args) {
		UserInfoConfig userInfo = UserInfoConfig.getInstance();
		System.out.println("手机号码："+userInfo.getMobilePhone());
	}*/


}
