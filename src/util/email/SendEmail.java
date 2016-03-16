package util.email;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;  
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *发送邮件
 * */
public class SendEmail {

	private EmailAuthenticator emailAuthenticator;
	private Session session;
	private Message mailMessage;

	private void init(EmailSenderInfo info) {
		//1.邮箱认证登录
		Properties properties = info.getProperties();
		if (info.isNeedValidate()) {
			emailAuthenticator = new EmailAuthenticator(info.getLoginName(),info.getLoginPwd());
		}
		session =  Session.getDefaultInstance(properties, emailAuthenticator);
		mailMessage = new MimeMessage(session);
		try {
			//2.1 设置发送人的邮箱地址
			mailMessage.setFrom(new InternetAddress(info.getemailSender()));
			//2.2设置邮件接收者的邮箱地址
			String[] receviers = info.getEmailReceviers();
			int receviersSize = receviers.length;
			if (receviersSize <= 0) {
				System.out.println("没有填写收件人的邮箱地址,请重新填写");
				return;
			}
			Address[] receviresAddresses = new InternetAddress[receviersSize];
			for (int i = 0; i < receviersSize; i++) {
				receviresAddresses[i] = new InternetAddress(receviers[i]);
			}
			mailMessage.setRecipients(Message.RecipientType.TO, receviresAddresses);
			//2.3 设置邮件抄送者的邮箱地址
			String[] cc = info.getCc();
			int ccLength = cc.length;
			if (ccLength != 0) {
				Address[] ccAddresses = new InternetAddress[ccLength];
				for (int i = 0; i < ccLength; i++) {
					ccAddresses[i] = new InternetAddress(cc[i]);	
				}
				mailMessage.setRecipients(Message.RecipientType.CC, ccAddresses);
			}
			//2.4 添加邮件的发送时间
			mailMessage.setSentDate(new Date());
			//2.5 添加发送邮件的主题
			mailMessage.setSubject(info.getSubject()); 
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendSimpleTextEmail(EmailSenderInfo info,String content) {
		try {
			init(info);
			mailMessage.setText(content);
			Transport.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void sendSimpleHtmlEmail(EmailSenderInfo info,String htmlContent) {
		Multipart mainPart = new MimeMultipart();   
		// 创建一个包含HTML内容的MimeBodyPart   
		BodyPart html = new MimeBodyPart();   
		// 设置HTML内容   
		try {
			html.setContent(htmlContent, "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容   
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}   

	}

	public void sendSimpleImageEmail(EmailSenderInfo info,String[] imagesPath) {

	}

	public void sendMixedEmail(EmailSenderInfo info,String content,String[] htmlCntent,
			String[] imagesPath,String[] imagesContentId,String[] attchFiles) {
		try {

			//添加附件
			MimeMultipart attachFilesMimeMultipart = new MimeMultipart();
			if (attchFiles.length > 0) {
				for (int i = 0; i < attchFiles.length; i++) {
					MimeBodyPart part = addAttachFile(attchFiles[i]);
					attachFilesMimeMultipart.addBodyPart(part);
				}
			}
			
			//添加图片
			if (imagesPath.length > 0 && imagesPath.length == imagesContentId.length) {
				for (int i = 0; i < imagesPath.length; i++) {
					
				}
			}
			
			//添加正文
			
			//添加Html链接地址


		} catch (MessagingException e) {
			e.printStackTrace();
		}




	}

	private MimeBodyPart addAttachFile(String attchFilePath) {
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource(attchFilePath));
		try {
			attach.setDataHandler(dh);
			attach.setFileName(dh.getName());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return attach;

	}
    
	
	@SuppressWarnings("unused")
	private MimeBodyPart addImage(String iamgePath,String ContentIDName) {
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource(iamgePath));
		try {
			attach.setDataHandler(dh);
			attach.setContentID(ContentIDName);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return attach;
	}
    
	public void addImage() {
		
	}



}
