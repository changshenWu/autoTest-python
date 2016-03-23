package util;

import util.CmdOptionsConst.Adb;

public class AdbCommand implements IAdbCommand {

	@Override
	public void run(String args) {
		AdbCmdRecevier acr = new AdbCmdRecevier();
		if (Adb.REBOOT.equals(args)) {
			acr.runReboot();
		}
	}

}
