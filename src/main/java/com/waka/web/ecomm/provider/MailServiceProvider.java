package com.waka.web.ecomm.provider;

import com.waka.web.ecomm.mail.Mailable;
import com.waka.web.ecomm.util.Env;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MailServiceProvider {
    private static MailServiceProvider mailServiceProvider;
    private ThreadPoolExecutor executor;
    private  Properties properties = new Properties();
    private Authenticator authenticator;
    private  BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

    private MailServiceProvider() {
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", Env.getProperty("mail.host"));
        properties.put("mail.smtp.port", Env.getProperty("mail.port"));

    }

    public static MailServiceProvider getInstance() {
        if (mailServiceProvider == null) {
            mailServiceProvider = new MailServiceProvider();
        }
        return mailServiceProvider;
    }

    public void start(){
        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Env.getProperty("mail.username"), Env.getProperty("mail.password"));
            }
        };

        executor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS, blockingQueue,
                new ThreadPoolExecutor.AbortPolicy());
        executor.prestartAllCoreThreads();

        System.out.println("Mail service provider started -------------------------//////////////");
    }

    public void sendMail(Mailable mailable) {
        blockingQueue.offer(mailable);

    }

    public Properties getProperties() {
        return properties;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void stop(){
        if(executor != null){
            executor.shutdown();
        }
    }
}