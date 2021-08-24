package com.br.chamada.catequese.chamada.adapters.outbound.smtp;

import com.br.chamada.catequese.chamada.application.domain.Email;
import com.br.chamada.catequese.chamada.application.ports.SendEmailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpSendEmailService implements SendEmailServicePort {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmailSmtp(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getEmailFrom());
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        mailSender.send(message);
    }
}
