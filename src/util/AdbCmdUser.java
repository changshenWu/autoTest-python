package util;

import java.util.Scanner;

import util.CmdOptionsConst.Adb;
import util.CmdOptionsConst.Am;
import util.CmdOptionsConst.Dumpsys;
import util.CmdOptionsConst.Pm;
import util.CmdOptionsConst.Wm;

/**
 * 模拟用户执行常用的adb命令
 * */
public class AdbCmdUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdbInvoker invoker = new AdbInvoker();
		while(true) {
			Logger.log("请输入要选择的选项: 0.退出选择;1.干掉进程;2.清除APP数据;3.monkey做压力测试;"+
					"4.重启手机;5.获取APP当前的内存信息;\n6.查看手机电池信息;7.截图保存到D盘目录;8.获取设备分辨率;"
					+ "9.查看用户安装的包名;10.干掉所有用户APP的进程;");
			System.out.print("你的选择是：");
			int choice= sc.nextInt();
			if (choice == 0) {
				break;
			} else if (choice== 1) {
				invoker.setAdbCommand(new AmCommand());
				invoker.runCommand(Am.STOP);
			} else if (choice == 2) {
				invoker.setAdbCommand(new PmCommand());
				invoker.runCommand(Pm.CLEAR);
			} else if (choice == 3) {
				invoker.setAdbCommand(new MonkeyCommand());
				invoker.runCommand("");
			} else if (choice == 4) {
				invoker.setAdbCommand(new AdbCommand());
				invoker.runCommand(Adb.REBOOT);
			} else if (choice == 5) {
				invoker.setAdbCommand(new DumpsysCommand());
				invoker.runCommand(Dumpsys.MEM);
			} else if (choice == 6) {
				invoker.setAdbCommand(new DumpsysCommand());
				invoker.runCommand(Dumpsys.BATTERY);
			} else if (choice == 7) {
				invoker.setAdbCommand(new AdbCommand());
				invoker.runCommand(Adb.SCREENCAP);
			} else if (choice == 8) {
				invoker.setAdbCommand(new WmCommand());
				invoker.runCommand(Wm.SIZE);
			} else if (choice == 9) {
				invoker.setAdbCommand(new PmCommand());
				invoker.runCommand(Pm.PACKAGE);
			} else if (choice == 10) {
				invoker.setAdbCommand(new AdbCommand());
				invoker.runCommand(Adb.KILL_ALL_PROCESS);
			}

		}
		Logger.log("程序退出！！！！欧耶");

	}

}
