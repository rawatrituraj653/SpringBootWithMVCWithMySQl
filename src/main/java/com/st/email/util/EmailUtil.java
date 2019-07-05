package com.st.email.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String to ,String subject,String text,MultipartFile file) {
		MimeMessage message =sender.createMimeMessage();
		MimeMessageHelper helper;
		boolean flag=false;
		try {
			
			helper = new MimeMessageHelper(message,true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			if(file!=null)
			helper.addAttachment(file.getOriginalFilename(), file);
			sender.send(message);
			
			flag=true;	
		} catch (MessagingException e1) {
			flag=false;
			e1.printStackTrace();
		}
				
		return flag;
	}
	
}
