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
	 * adb shell monkey
	 * */

	private String packageName = "cn.xyb100.xyb";

	private void runCmd(String cmd) {
		Runtime rt = Runtime.getRuntime();
		try {
			Process process = rt.exec(cmd);
			Logger.log(cmd);
			//如果p不为空，那么要清空
			if(process != null) {
				//检查正确的执行结果
				InputStream is = process.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String line = null;
				while ((line = br.readLine()) != null) {
					//System.out.print(line);
					Logger.log(line);
				}
				process.destroy();
				process = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runDumpMemInfo() {
		runCmd("adb shell dumpsys meminfo "+packageName);
	}

	public void runDumpCpuInfo() {
		runCmd("adb shell dumpsys cpuinfo "+packageName);
	}

	public void runDumpActivity() {
		runCmd("adb shell dumpsys activity "+packageName);
	}

	public void runDumpSurfaceFlinger() {
		runCmd("adb shell dumpsys SurfaceFlinger");
	}

	public void runDumpPackage() {
		runCmd("adb shell dumpsys package");
	}

	public void runDumpDropbox() {
		runCmd("adb shell dumpsys dropbox "+packageName);
	}

	public void runDumpPhone() {
		runCmd("adb shell dumpsys phone");
	}

	public void runDumpWifi() {
		runCmd("adb shell dumpsys wifi");
	}

	public void runDumpBluetooth() {
		runCmd("adb shell dumpsys bluetooth");
	}

	public void runDumpWindow() {
		runCmd("adb shell dumpsys window " +packageName);
	}

	public void runDumpConnectivity() {
		runCmd("adb shell dumpsys connectivity");
	}

	/*
	 * adb shell monkey命令
	 * -p 允许的包名列表，可同时指定多个包名，每个包都需要使用“-p”参数指定
	 * --ignore-crashes 忽视应用 crash 报错，不指定该参数时，应用出现 crash，monkey 会自动停止发送事件，
	 *                  指定该参数后，mongkey 会在 crash 后也一直发送事件，知道所有事件发送完成
	 * --ignore-timeouts 忽视超时导致的错误，即ANR的错误
	 * --ignore-security-exceptions 忽视权限方面的错误
	 * --monitor-native-crashes 监控由 C/C++ 代码引起的 crash
	 * --ignore-native-crashes 忽视由 C/C++ 代码引起的 crash
	 * --kill-process-after-error 当出现错误后杀掉应用的进程
	 * --hprof 指定该选项后，monkey会在发送事件完成后生成性能报告，报告一般存放于/data/misc目录下，对报告的分析，需要使用Traceview
	 * --pct-touch percent 设定 touch 事件比例
	 * --pct-motion 设定手势事件比例，例如滑动事件
	 * --pct-trackball 设定跟踪球事件的比例
	 * --pct-syskeys 设定系统按键事件的比例
	 * --pct-nav 设定”基本”导航事件的比例
	 * --pct-majornav 设定”主要”导航事件比例
	 * --pct-appswitch 设定启动 Activity的事件比例
	 * --pct-pinchzoom 设定缩放事件比例
	 * --pct-anyevent 设定其他事件比例
	 * -s 设定种子数，方便用于重现 bug
	 * -v 设定输出信息的详细级别，1个 -v 表示级别为1，2个 -v 表示级别为2
	 * --throttle 设定事件之间的延时，单位为毫秒
	 * [--profile-wait MILLISEC]
     * [--device-sleep-time MILLISEC]
     * [--randomize-script]
     * [--script-log]
     * [--bugreport]
     * [--periodic-bugreport]
     * [--kill-process-after-error]
     * [--pkg-blacklist-file PACKAGE_BLACKLIST_FILE]
     * [--pkg-whitelist-file PACKAGE_WHITELIST_FILE]
     * [--wait-dbg]
     * [--dbg-no-events]
     * [--setup scriptfile]
     * [-f scriptfile [-f scriptfile] ...]
     * [--port port]
	 * COUNT 事件数目
	 * 例如：adb shell monkey -p cn.xyb100.xyb -v 500
	 * */
	public void runMonkey() {
		String[] monkeyCmdIgnoreArgs = {"--ignore-crashes","--ignore-timeouts",
				"--ignore-security-exceptions","--ignore-native-crashes"};
		String[] monkeyCmdPctArgs = {"--pct-touch","--pct-motion","--pct-trackball",
				"--pct-syskeys","--pct-pinchzoom","--pct-nav","--pct-majornav",
				"pct-anyevent","pct-appswitch"};
		String[] otherArgsStrings = {"-p "+packageName};
		runCmd("adb shell monkey");
	}
	
	public void runPm() {
	}
	
	public void runAm() {
	}

}
