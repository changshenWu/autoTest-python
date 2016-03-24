package util;

import java.io.File;

public class MonkeyCommand implements IAdbCommand {
    
	private AdbCmdRecevier acr = null;

	@Override
	public void run(String args) {
		acr = new AdbCmdRecevier();
		if (args.equals("")) {
			acr.runShellMonkey();
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
