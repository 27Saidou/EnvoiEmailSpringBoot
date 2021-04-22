package com.javaexpress.springbootemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1")
public class SendEmailController {
	@Autowired
    private JavaMailSender javaMailSender;
	
	@GetMapping("/sendEmail")
	public String sendEmail() {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("sinthio2@gmailcom");
		message.setSubject("SpringBoot Message");
		message.setText("je suis un développeur web et mobile");
		javaMailSender.send(message);
		return "message send successfully";
	}
	@PostMapping("/send")
	public String sendEmail(@RequestBody Email mail) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(mail.getTo());
		message.setSubject(mail.getMessageBody());
		message.setText(mail.getMessageBody());
		javaMailSender.send(message);
		return "message send successfully";
	}
}
