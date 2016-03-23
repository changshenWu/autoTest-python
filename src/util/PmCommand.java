package util;

import util.CmdOptionsConst.Pm;

public class PmCommand implements IAdbCommand {

	private AdbCmdRecevier acr;

	public PmCommand() {
		this.acr = new AdbCmdRecevier();
	}

	@Override
	public void run(String option) {
		if (Pm.CLEAR.equals(option)) {
			acr.runPmClear();
		} else if(Pm.PACKAGE.equals(option)) {
			acr.runPmListPackage();
		} else if(Pm.DUMP.equals(option)) {
			acr.runPmDump();
		} else if(Pm.GET_INSTALL_LOC.equals(option)) {
			acr.runPmGetInstallLocation();
		} else if(Pm.PATH.equals(option)) {
			acr.runPmPath();
		} else if(Pm.INSTRMENTATION.equals(option)) {
			acr.runPmListInstrumentation();
		} else if(Pm.PERMISSION.equals(option)) {
			acr.runPmListPermissions();
		} else if(Pm.USER.equals(option)) {
			acr.runPmListUsers();
		}
	}

}
