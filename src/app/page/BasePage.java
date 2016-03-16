package app.page;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;

import util.parse.DomParseXml;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;


public class BasePage implements IFindElement {

	public AndroidDriver<WebElement> driver;

	public void quit() {
		driver.quit();
	}
    
	public void sendKeys(int type,String value,String content) {
		findElement(1, value).sendKeys(content);
		driver.hideKeyboard();
	}

	public void click(int type,String value) {
		findElement(type, value).click();
	}

	@Override
	public WebElement findElement(int type, String value) {
		WebElement webElement = null;
		if (type == 1) {
			webElement = driver.findElementById(value);
		} else if (type == 2) {
			webElement = driver.findElementByName(value);
		} else if (type == 3) {
			webElement = driver.findElementByClassName(value);	
		} else if (type == 4) {
			driver.findElementByAndroidUIAutomator(value);
		}
		return webElement;
	}  


	/**
	 * @return HashMap<節點名，hashMap<節點屬性，節點屬性值>>
	 * */
	public HashMap<String, HashMap<String, String>> getCurrentPageElements() {
		//若是若不是Android平台，则返回
		if (!(driver instanceof AndroidDriver)) {
			System.out.println("当前平台不是Android平台");
			return null;
		}
		//1.获取当前的activity Name
		String currentActivityName =  driver.currentActivity();
		//2.获取当前的页面元素
		String pageElement = driver.getPageSource();
		HashMap<String, HashMap<String, String>> temp = null;
		try {
			//3.生成activity.xml文件
			File file = new File(".\\config"+currentActivityName+".xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(pageElement);
			bw.flush();
			bw.close();
			//4.解析xml文件
			DomParseXml px = new DomParseXml();
			temp = px.getFactorsHashMap(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 *判断当前网络是否连接？
	 * */
	public boolean isConnectNetwork() {
		//status = 0,1,2,4 分别对应的是：无网络，飞行模式，wifi,移动网络
		int status =  driver.getNetworkConnection().value;
		/*	if (status == 0) {
			System.out.println("当前无网络");	
		} else if(status == 1) {
			System.out.println("当前网络为飞行模式");
		} else if (status == 2) {
			System.out.println("当前网络连接是wifi");
		} else if (status == 4) {
			System.out.println("当前网络连接的是移动网络");
		}*/
		if (status == 0 | status == 1 ) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 网络操作：断开网络,连接网络;切换网络;
	 * */
	public void handleNetwork(boolean disconnect,boolean isWifiNetwork,boolean isDataNetwork) {
		NetworkConnectionSetting connection = driver.getNetworkConnection();
		int status = connection.value;
		if (status == 0 | status == 1) {
			//1.断开网络
			//2.打开飞行模式
			//3.连接到wifi ,其中wifi的优先级大于data网络
			//4.连接到data网络
			if (!disconnect && isWifiNetwork) {
               connection.setWifi(true);
			} else if(!disconnect && isDataNetwork) {
				connection.setData(true);
			}
			
		} else {

		}

	}




}
