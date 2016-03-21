package util;

public class DumpsysCommond implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	public DumpsysCommond(AdbCmdRecevier acr) {
		this.acr = acr;
	}

	@Override
	public void run(String args) {
		if (args.equals("mem")) {
			acr.runDumpMemInfo();
		} else if(args.equals("cpu")) {
			acr.runDumpCpuInfo();
		} else if (args.equals("package")) {
			acr.runDumpPackage();
		} else if (args.equals("dropbox")) {
			acr.runDumpDropbox();
		} else if (args.equals("surface")) {
			acr.runDumpSurfaceFlinger();
		} else if(args.equals("phone")) {
			acr.runDumpPhone();
		} else if(args.equals("wifi")) {
			acr.runDumpWifi();
		} else if (args.equals("window")) {
			acr.runDumpWindow();
		} else if (args.equals("conn")) {
			acr.runDumpConnectivity();
		}

	}

}
