package util;

import java.io.File;

public class AdbInvoker {
	
	public IAdbCommand adbCommand;

	public void setAdbCommand(IAdbCommand adbCommand) {
		this.adbCommand = adbCommand;
	}

	public void runCommand(String args) {
		adbCommand.run(args);
	}

	public File getRunCommandResultFile() {
		return adbCommand.getCmdResultFile();
	}
	
}
