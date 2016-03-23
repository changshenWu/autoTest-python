package util;

public class MonkeyCommand implements IAdbCommand {
    
	private AdbCmdRecevier acr;
	public MonkeyCommand() {
		this.acr = new AdbCmdRecevier();;
	}

	@Override
	public void run(String args) {
		if (args.equals("")) {
			acr.runShellMonkey();
		}
	}

}
