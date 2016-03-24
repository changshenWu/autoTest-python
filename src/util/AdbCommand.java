package util;

import java.io.File;

import util.CmdOptionsConst.Adb;

public class AdbCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	@Override
	public void run(String args) {
		acr = new AdbCmdRecevier();
		if (Adb.REBOOT.equals(args)) {
			acr.runReboot();
		} else if (Adb.SCREENCAP.equals(args)) {
			acr.runScreencap();
		} else if (Adb.KILL_ALL_PROCESS.equals(args)) {
			acr.runKillAllProcess();
		}
	}

	@Override
	public File getCmdResultFile() {
		if (acr != null) {
			return acr.getCmdResultFile();
		} else {
			return null;
		}
	}

}
