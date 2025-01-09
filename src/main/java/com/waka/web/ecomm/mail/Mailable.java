package com.waka.web.ecomm.mail;

import com.waka.web.ecomm.provider.MailServiceProvider;
import com.waka.web.ecomm.util.Env;
import io.rocketbase.mail.EmailTemplateBuilder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public abstract class Mailable implements Runnable {
    private final MailServiceProvider mailServiceProvider;
    private final EmailTemplateBuilder.EmailTemplateConfigBuilder emailTemplateBuilder;

    public Mailable() {
        mailServiceProvider = MailServiceProvider.getInstance();
        emailTemplateBuilder = EmailTemplateBuilder.builder();
    }

    @Override
    public void run() {
        try {
            Session session = Session.getInstance(
                    mailServiceProvider.getProperties(),
                    mailServiceProvider.getAuthenticator()
            );

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Env.getProperty("app.mail")));
            build(message);
            if (message.getRecipients(Message.RecipientType.TO).length > 0) {
                Transport.send(message);
                System.out.println("Email sent successfully---------------------/////////////////////////");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void build(Message message) throws MessagingException;

    public EmailTemplateBuilder.EmailTemplateConfigBuilder getEmailTemplateBuilder() {
        return emailTemplateBuilder;
    }
}
