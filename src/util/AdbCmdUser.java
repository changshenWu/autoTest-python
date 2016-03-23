package util;

import java.util.Scanner;

import util.CmdOptionsConst.Adb;
import util.CmdOptionsConst.Am;
import util.CmdOptionsConst.Pm;

/**
 * 模拟用户执行常用的adb命令
 * */
public class AdbCmdUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdbInvoker invoker = new AdbInvoker();
		while(true) {
			Logger.log("请输入要选择的选项: 0.退出选择;1.干掉进程;2.清除APP数据;3.monkey做压力测试;"+
					"4.重启手机");
			int choice= sc.nextInt();
			if (choice== 1) {
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
			}
			
			if (choice == 0) {
				break;
			}
			
		}
		

	}

}
