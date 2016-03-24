package util;

import java.io.File;

import util.CmdOptionsConst.Wm;

public class WmCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	@Override
	public void run(String args) {
		acr = new AdbCmdRecevier();
		if (Wm.SIZE.equals(args)) {
			acr.runWmSize();
		}
	}

	@Override
	public File getCmdResultFile() {
		if (acr != null) {
			return acr.getCmdResultFile();
		} else {
			Logger.log("尚未执行相关命令!");
			return null;
		}
	}

}
