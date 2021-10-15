package com.stores.stores.models.utils;

import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

@Service
public class SendMail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Autowired
	private TemplateEngine templateEngine;
	
	
	public void sendMailData(String from, String to, String subject, String body) throws MessagingException {

		//SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage mimeMessage =  javaMailSender.createMimeMessage();
		MimeMessageHelper message =  new MimeMessageHelper(mimeMessage, true);
		
		message.setTo(to);
		message.setFrom(from);
		message.setSubject(subject);
		message.setText(body, true);
		
		javaMailSender.send(mimeMessage);
	}
	
	public void sendPago(String from, String to, String subject , String tienda, Long long1, String fecha, Long long2) throws MessagingException {
		Context context = new Context();
		context.setVariable("tienda", tienda);
		context.setVariable("valor", long1);
		context.setVariable("fecha", fecha);
		context.setVariable("id", long2);


		String htmlContext = templateEngine.process("pago", context);
		
		sendMailData(from, to , subject, htmlContext);
	}
	
	

}
