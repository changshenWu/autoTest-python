package util;

public class DumpsysCommond implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	public DumpsysCommond(AdbCmdRecevier acr) {
		this.acr = acr;
	}

	@Override
	public void run(String args) {
		if (args.equals("mem")) {
			acr.runDumpsysMemInfo();
		} else if(args.equals("cpu")) {
			acr.runDumpsysCpuInfo();
		}
		
	}

}
