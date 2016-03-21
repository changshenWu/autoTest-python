package util;

public class AdbInvoker {
	
	public IAdbCommand adbCommand;

	public void setAdbCommand(IAdbCommand adbCommand) {
		this.adbCommand = adbCommand;
	}
	
	public void runCommand(String args) {
		adbCommand.run(args);
	}
	
	public  static void main(String[] args) {
		AdbInvoker invoker = new AdbInvoker();
		AdbCmdRecevier acr = new AdbCmdRecevier();
		invoker.setAdbCommand(new MonkeyCommand(acr));
		invoker.runCommand("");
	}
}
