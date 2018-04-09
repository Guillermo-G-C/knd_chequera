package com.KND.chequera.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.KND.chequera.model.MailModel;
import com.KND.chequera.service.SendMailService;

@Service("sendMailService")
public class SendMailServiceImpl implements SendMailService {

	@Autowired 
	private JavaMailSender emailSender;
	
	@Override
	public boolean sendMailMessage(MailModel mailModel) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(mailModel.getSubject());
		helper.setText(mailModel.getContent());
		helper.setTo(mailModel.getTo());
		helper.setFrom(mailModel.getFrom());
		
		helper.addAttachment("logo", new ClassPathResource(""));
		emailSender.send(message);
		return false;
	}

}
