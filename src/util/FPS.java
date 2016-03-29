package util;

import java.io.File;

import util.CmdOptionsConst.Dumpsys;

public class FPS {

	private AdbInvoker invoker;

	public FPS() {
		invoker = new AdbInvoker();
	}
	
	public void parseFPS() {
		invoker.setAdbCommand(new DumpsysCommand());
		invoker.runCommand(Dumpsys.SURFACE);
		//解析文件
		parserFile(invoker.getRunCommandResultFile());
	}
	
	private void parserFile(File file) {
		
		
	}
	
	public static void main(String[] args) {
		FPS fps = new FPS();
		fps.parseFPS();
	}

}
