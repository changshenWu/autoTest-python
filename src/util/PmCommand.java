package util;

public class PmCommand implements IAdbCommand {

	private AdbCmdRecevier acr;

	public PmCommand(AdbCmdRecevier acr) {
		super();
		this.acr = acr;
	}

	@Override
	public void run(String option) {
		if (("clear").equals(option)) {
			acr.runPmClear();
		} else if(("list package").equals(option)) {
			acr.runPmListPackage();
		} else if (("dump").equals(option)) {
			acr.runPmDump();
		} else if (("get-install-location").equals(option)) {
			acr.runPmGetInstallLocation();
		} else if(("path").equals(option)) {
			acr.runPmPath();
		}
	}

}
