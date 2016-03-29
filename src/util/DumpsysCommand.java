package util;

import java.io.File;

import util.CmdOptionsConst.Dumpsys;

public class DumpsysCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;
	private String packageName = null;

	@Override
	public void run(String args) {
		this.acr = new AdbCmdRecevier();
		if (Dumpsys.MEM.equals(args)) {
			acr.runDumpMemInfo(packageName);
		} else if(Dumpsys.CPU.equals(args)) {
			acr.runDumpCpuInfo(packageName);
		} else if (Dumpsys.PACKAGE.equals(args)) {
			acr.runDumpPackage();
		} else if (Dumpsys.DROPBOX.equals(args)) {
			acr.runDumpDropbox(packageName);
		} else if (Dumpsys.SURFACE.equals(args)) {
			acr.runDumpSurfaceFlinger();
		} else if(Dumpsys.PHONE.equals(args)) {
			acr.runDumpPhone();
		} else if(Dumpsys.WIFI.equals(args)) {
			acr.runDumpWifi();
		} else if (Dumpsys.WINDOW.equals(args)) {
			acr.runDumpWindow(packageName);
		} else if (Dumpsys.CONN.equals(args)) {
			acr.runDumpConnectivity();
		} else if (Dumpsys.POWER.equals(args)) {
			acr.runDumpPower();
		} else if (Dumpsys.BATTERY.equals(args)) {
			acr.runDumpBattery();
		} else if (Dumpsys.ACTIVITY.equals(args)) {
			acr.runDumpActivity(packageName);
		} else if (Dumpsys.CONTENT.equals(args)) {
			acr.runDumpContent(packageName);
		} else if (Dumpsys.CURRENT_ACTIVITY.equals(args)) {
			//acr.runDumpCurrentActivity();
			acr.runDumpFPS();
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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}
