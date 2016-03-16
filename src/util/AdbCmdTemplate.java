package util;

public class AdbCmdTemplate {

	public static String PID = "adb -s #udid# shell dumpsys meminfo #packageName#|grep pid|awk '{print $5}'";
	public static String UID = "adb -s #udid# shell dumpsys package #packageName#|grep packageSetting|cut -d \"/\" -f2|cut -d \"}\" -f1";

	/**实时抓取**/
	// TIMESTAMP(yyyymmddHHMMSS) CPU(%) PID/PACKAGE
	public static String CPU_USAGE = "adb -s #udid# shell dumpsys cpuinfo|grep #filter#|awk '{print '$(date +%Y%m%d%H%M%S)',$1,$2}'|grep #pid#";

	// TIMESTAMP(yyyymmddHHMMSS) PSS(KB) PACKAGE
	public static String PSS = "adb -s #udid# shell dumpsys meminfo|awk '/process:/,/adjustment:/{if(i>1)print x;x=$0;i++}'|grep #filter#|grep #pid#|awk '{print '$(date +%Y%m%d%H%M%S)',$1,$3}'";

	// TIMESTAMP(yyyymmddHHMMSS) RX_BYTES(BYTE)
	public static String RX_BYTES = "adb -s #udid# shell cat /proc/net/xt_qtaguid/stats|grep #uid#|awk '{rx_bytes+=$6}END{print '$(date +%Y%m%d%H%M%S)',rx_bytes}'";

	// TIMESTAMP(yyyymmddHHMMSS) TX_BYTES(BYTE)
	public static String TX_BYTES = "adb -s #udid# shell cat /proc/net/xt_qtaguid/stats|grep #uid#|awk '{tx_bytes+=$8}END{print '$(date +%Y%m%d%H%M%S)',tx_bytes}'";

	/**异步抓取**/
	// TIMESTAMP(yyyymmddHHMMSS) PID VSS(KB) RSS(KB) PACKAGE
	public static String SAVE_TOP_INFO = "adb -s #udid# shell top -n 1 -d 0|grep #filter#|awk '{print '$(date +%Y%m%d%H%M%S)',$1,$6,$7,$10}' >> output/#udid#/latest/top_#udid#.txt";

	// TIMESTAMP(yyyymmddHHMMSS) CPU(%) PID/PACKAGE
	public static String SAVE_CPU_INFO = "adb -s #udid# shell dumpsys cpuinfo|grep #filter#|awk '{print '$(date +%Y%m%d%H%M%S)',$1,$2}' >> output/#udid#/latest/cpu_#udid#.txt";

	// TIMESTAMP(yyyymmddHHMMSS) PSS(KB) PACKAGE
	public static String SAVE_PSS_INFO = "adb -s #udid# shell dumpsys meminfo|awk '/process:/,/adjustment:/{if(i>1)print x;x=$0;i++}'|grep #filter#|awk '{print '$(date +%Y%m%d%H%M%S)',$1,$3}' >> output/#udid#/latest/pss_#udid#.txt";

	// TIMESTAMP(yyyymmddHHMMSS) RX_BYTES(BYTE) TX_BYTES(BYTE)
	public static String SAVE_TRAFFIC_INFO = "adb -s #udid# shell cat /proc/net/xt_qtaguid/stats|grep #uid#|awk '{rx_bytes+=$6}{tx_bytes+=$8}END{print '$(date +%Y%m%d%H%M%S)',rx_bytes,tx_bytes}' >> output/#udid#/latest/traffic_#udid#.txt";

	// Draw(MS) Process(MS) Execute(MS) 抓取每帧
	public static String SAVE_GFX_INFO = "adb -s #udid# shell dumpsys gfxinfo #packageName#|awk '/Execute/,/hierarchy/{if(i>1)print x;x=$0;i++}'|sed /^[[:space:]]*$/d|awk '{if(length($0)==16)print $1,$2,$3}' >> output/#udid#/latest/gfxinfo_#udid#.txt";
    
	
}
