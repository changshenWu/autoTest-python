package util;

public class MonkeyCommand implements IAdbCommand {
    
	private AdbCmdRecevier acr;
	public MonkeyCommand(AdbCmdRecevier acr) {
		this.acr = acr;
	}

	@Override
	public void run(String args) {
		acr.runMonkey();
	}

}
