package util;

import java.io.File;

public interface IAdbCommand {
	public void run(String args);
	public File getCmdResultFile();
}
