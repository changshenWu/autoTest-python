package util;

import util.CmdOptionsConst.Dump;

public class DumpsysCommond implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	public DumpsysCommond() {
		this.acr = new AdbCmdRecevier();
	}

	@Override
	public void run(String args) {
		if (Dump.MEM.equals(args)) {
			acr.runDumpMemInfo();
		} else if(Dump.CPU.equals(args)) {
			acr.runDumpCpuInfo();
		} else if (Dump.PACKAGE.equals(args)) {
			acr.runDumpPackage();
		} else if (Dump.DROPBOX.equals(args)) {
			acr.runDumpDropbox();
		} else if (Dump.SURFACE.equals(args)) {
			acr.runDumpSurfaceFlinger();
		} else if(Dump.PHONE.equals(args)) {
			acr.runDumpPhone();
		} else if(Dump.WIFI.equals(args)) {
			acr.runDumpWifi();
		} else if (Dump.WINDOW.equals(args)) {
			acr.runDumpWindow();
		} else if (Dump.CONN.equals(args)) {
			acr.runDumpConnectivity();
		}
	}

}
