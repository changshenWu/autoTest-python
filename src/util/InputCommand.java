package util;

import java.io.File;

import util.CmdOptionsConst.Input;

public class InputCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;
	private String location = null;
	private String text = null;
	private String key = null;

	@Override
	public void run(String args) {
		acr = new AdbCmdRecevier();
		if (args.equals(Input.SWIPE)) {
			acr.runInputSwipe();
		} else if (args.equals(Input.TEXT)) {
			if (text == null) {
				Logger.log("尚未输入");
			} else {
				acr.runInputText(text);
			}
		} else if (args.equals(Input.TAP)) {
			acr.runInputTap(location);
		} else if (args.equals(Input.KEYEVENT)) {
			acr.runInputKeyEvent(key);
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

	public String getLocaltion() {
		return location;
	}

	public void setLocaltion(String location) {
		this.location = location;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
