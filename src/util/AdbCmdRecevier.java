package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdbCmdRecevier {
	
	/* adb 命令解析
	 * adb -d 当Android手机用USB连接计算机时可通过adb－d对该装置下命令
	 * adb -e对正在运行的仿真器下指令
	 * adb -s指定仿真器序号
	 * adb devices显示当前启动的仿真器装置序号
	 * adb help显示adb指令用法
	 * adb verson显示adb版本
	 * adb install安装APK应用程序组件
	 * adb push上传文件或目录（adb push 文件所在PC的位置即文件名 目的位置）
	 * adb pull下载文件或目录（adb pull 文件所在手机的位置即文件名 目的位置）
	 * adb shell进入Android系统命令行模式
	 * adb logcat监控仿真器运行记录
	 * adb bugreport生成adb出错报告
	 * adb start－server启动adb服务器
	 * adb kill－server关闭adb服务器
	 * adb get－state取得adb服务器运行状态
	 * adb get－serialno获得仿真器运行序号
	 * adb forward tcp：port更改仿真器的网络TCP通信端口
	 * adb shell dumpsys
	 * */
	
	private void runCmd(String cmd) {
		Runtime rt = Runtime.getRuntime();
		try {
			Process process = rt.exec(cmd);
			//如果p不为空，那么要清空
			if(process != null) {
				//检查正确的执行结果
				InputStream is = process.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String line = null;
				while ((line = br.readLine()) != null) {
					//System.out.println(line);
					Logger.log(line);
				}
				process.destroy();
				process = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runDumpsysMemInfo() {
		runCmd("adb shell dumpsys meminfo cn.xyb100.xyb");
	}
    
	
	public void runDumpsysCpuInfo() {
		
	}
}
