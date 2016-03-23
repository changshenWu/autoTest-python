package util;

import util.CmdOptionsConst.Am;

public class AmCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;
	
	public AmCommand() {
		this.acr = new AdbCmdRecevier();
	}

	@Override
	public void run(String args) {
		if (Am.STOP.equals(args)) {
			acr.runAmStop();
		} else if(Am.TEL.equals(args)) {
			acr.runAmStartPhone();
		}else if (Am.WEB.equals(args)) {
			acr.runAmStartWebView();
		}
	}

}
