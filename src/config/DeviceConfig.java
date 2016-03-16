package config;

import org.openqa.selenium.remote.DesiredCapabilities;

import util.parse.Excel;
import jxl.Sheet;

/**
 * 获取app 自动化测试所需要的配置的前提文件
 * */
public class DeviceConfig {

	/**
	 * 读取连接appium服务器的配置
	 * @return DesiredCapabilities对象
	 * */
	public DesiredCapabilities getDesiredCapabilities() {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Excel excel = new Excel(ConfigConst.CONFIG_FILE_PATH);
		Sheet configSheet = excel.getSheetByName(ConfigConst.CONFIG_SHEET_NAME);
		//获取行数
		int rows = configSheet.getRows();
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < 3; j++) {
				//getcell(列的索引值,行的索引值)
				String content = excel.getCellContent(configSheet, i, j);
				//System.out.print(content+" ");
				//若IsNeed的字段值为1，则保存到String
				if (j == 2 && content.equals("1")) {
					//把第1列和第2列的值以键值对的形式放到hashMap
					String key = excel.getCellContent(configSheet, i, 0);
					String value = excel.getCellContent(configSheet, i, 1);
					capabilities.setCapability(key,value);
					System.out.println(key+":"+value);
				}
			}
			//System.out.println();
		}
		return capabilities;
	}
    
	//test
	public static void main(String[] args) {
		DeviceConfig deviceConfig = new DeviceConfig();
		deviceConfig.getDesiredCapabilities();
	}


}
