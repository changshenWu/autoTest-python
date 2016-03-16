package util.email;

import java.util.Properties;

/**
 * 邮件发送者的信息
 * */
public class EmailSenderInfo {

	private String emailServerHost = "mail.xyb100.com";
	private String emailServerPort = "25";
	
	/**
	 * 是否需要身份验证
	 * */
	private boolean isNeedValidate = false;
	
	private String loginName;
	private String loginPwd;
 
	/**
	 *邮件发送者
	 * */
	private String emailSender;
	/**
	 *邮件接收者
	 * */
	private String[] emailReceviers = {};
	/**
	 *抄送邮件给谁
	 * */
	private String[] cc = {};

	/**
	 *邮件的主题
	 * */
	private String subject;
	
	public boolean isNeedValidate() {
		return isNeedValidate;
	}

	public void setNeedValidate(boolean isNeedValidate) {
		this.isNeedValidate = isNeedValidate;
	}
    
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host",this.emailServerHost);
		properties.put("mail.smtp.port", this.emailServerPort);
		properties.put("mail.smtp.auth", isNeedValidate ? "true" : "false" );
		return properties;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getemailSender() {
		return emailSender;
	}

	public void setemailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	public String[] getEmailReceviers() {
		return emailReceviers;
	}

	public void setEmailReceviers(String[] emailReceviers) {
		this.emailReceviers = emailReceviers;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
