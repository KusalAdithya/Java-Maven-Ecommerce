package com.waka.web.ecomm.mail;

import com.waka.web.ecomm.util.Env;
import io.rocketbase.mail.model.HtmlTextEmail;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;

public class VerificationMail extends Mailable{
    private String to;
    private String verificationCode;

    public VerificationMail(String to, String verificationCode) {
        this.to = to;
        this.verificationCode = verificationCode;
    }

    @Override
    public void build(Message message) throws MessagingException {
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject("Please Verify Your Email Address");

        String url = Env.getProperty( "app.base_url")+"verify?token="+verificationCode;

        HtmlTextEmail content = getEmailTemplateBuilder()
                .header()
                .logo("../webapp/img/logo.png").logoHeight(41).and()
                .text("Welcome!").h1().center().and()
                .text("Verify Your Email Address").h2().center().and()
                .html("<center><a href=\""+url+"\">To Verify, Click Here</a></center>").and()
                .copyright("Aranoz").url("http://localhost:8080/ecomm/").suffix(". All rights reserved.").and()
                .footerText("[Aranoz.]\n" +
                        "1234 Street Rd.\n" +
                        "Suite 1234").and()
                .build();

        message.setContent(content.getHtml(),"text/html");
    }
}
