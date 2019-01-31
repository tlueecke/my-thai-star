package com.devonfw.application.mtss4sdk.mailservice;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.devonfw.application.mtsj.mailservice.Mail;

/**
 * Class for Mail service
 *
 */
@Named
@ConditionalOnProperty(prefix = "spring.mail", name = "enabled", havingValue = "true")
public class MailImpl implements Mail {

  @Value("${spring.mail.username}")
  private String from;

  @Autowired
  public MailSender mailSender;

  public boolean sendMail(String to, String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(this.from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    try {
      this.mailSender.send(message);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
