package util;

import util.CmdOptionsConst.Dumpsys;

public class DumpsysCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	public DumpsysCommand() {
		this.acr = new AdbCmdRecevier();
	}

	@Override
	public void run(String args) {
		if (Dumpsys.MEM.equals(args)) {
			acr.runDumpMemInfo();
		} else if(Dumpsys.CPU.equals(args)) {
			acr.runDumpCpuInfo();
		} else if (Dumpsys.PACKAGE.equals(args)) {
			acr.runDumpPackage();
		} else if (Dumpsys.DROPBOX.equals(args)) {
			acr.runDumpDropbox();
		} else if (Dumpsys.SURFACE.equals(args)) {
			acr.runDumpSurfaceFlinger();
		} else if(Dumpsys.PHONE.equals(args)) {
			acr.runDumpPhone();
		} else if(Dumpsys.WIFI.equals(args)) {
			acr.runDumpWifi();
		} else if (Dumpsys.WINDOW.equals(args)) {
			acr.runDumpWindow();
		} else if (Dumpsys.CONN.equals(args)) {
			acr.runDumpConnectivity();
		} else if (Dumpsys.POWER.equals(args)) {
			acr.runDumpPower();
		} else if (Dumpsys.BATTERY.equals(args)) {
			acr.runDumpBattery();
		}
	}

}
