package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.domain.SelectMail;
import jp.co.openworker.mailsystem.model.form.SelectMailForm;
import jp.co.openworker.mailsystem.model.form.UserForm;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectMailMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

@Controller
@RequestMapping("/mailsystem/user")
public class UserController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private SelectMailMapper selectMailMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		return "register_user";
	}
	
	@RequestMapping("/duplicatedUserName")
	@ResponseBody
	public boolean duplicatedUserName(@RequestParam String userName) {
		int count = userMapper.findCountByUserName(userName);
		
		try {
			Properties property = new Properties();
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.auth", "true");
			property.put("mail.smtp.starttls.enable", "true");
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.port", "587");
			property.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(property, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("yamadatest567@gmail.com", "yamadatest");
				}
			});
			
			// テキスト部分
			MimeBodyPart part1 = new MimeBodyPart();
			part1.setText("テキスト", "iso-2022-jp");
			
			// テキストファイル部分
			DataSource dataSource2 = new ByteArrayDataSource(new FileInputStream( new File("C:\\Users\\user\\Documents\\テキスト.txt")),"text/plain");
			MimeBodyPart part2 = new MimeBodyPart();
			part2.setDataHandler(new DataHandler(dataSource2));
			part2.setFileName("テキスト.txt");
			
			// PDFファイル部分
//			DataSource dataSource3 = new ByteArrayDataSource(new FileInputStream( new File("sample.pdf")),"application/pdf");
//			MimeBodyPart part3 = new MimeBodyPart();
//			part3.setDataHandler(new DataHandler(dataSource3));
//			part3.setFileName("sample.pdf");
			
			final MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(part1);
			multipart.addBodyPart(part2);
//			multipart.addBodyPart(part3);

			MimeMessage mimeMessage = new MimeMessage(session);
			InternetAddress toAddress = new InternetAddress("yamadatest567@gmail.com", "受信者名");
			mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
			InternetAddress fromAddress = new InternetAddress("yamadatest567@gmail.com", "送信者");
			mimeMessage.setFrom(fromAddress);
			mimeMessage.setSubject("title", "ISO-2022-JP");
			mimeMessage.setContent(multipart);
			Transport.send(mimeMessage);
			
			System.out.println("メール送信が完了しました。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count > 0;
	}
	
	//public class Mail {
		//public static void mail(String[] args) {
			
		//}
	//}
	
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int count = userMapper.insert(user);
		
		return count > 0;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public boolean retention(@RequestBody SelectMailForm f) {
		SelectMail mail = new SelectMail(f);
		
		int count = selectMailMapper.insert(mail);
		
		return count > 0;
	}
	
}