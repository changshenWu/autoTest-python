package config;

public class ConfigConst {
	
	/**
	 *Appium 服务器配置文件的路劲
	 * */
	public final static String CONFIG_FILE_PATH = ".\\config\\config.xls";
	/**
	 *Appium 配置EXCEL 表格中对应的Sheet名
	 * */
	public final static String CONFIG_SHEET_NAME = "device";
	/**
	 *用户信息的Sheet名
	 * */
	public final static String USERINFO_SHEET_NAME = "user";
	
	/**
	 * 连接appium服务器的URL地址 
	 * */
	public final static String CONNECT_APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

}
