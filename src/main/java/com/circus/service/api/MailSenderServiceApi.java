package com.circus.service.api;

public interface MailSenderServiceApi {
    void send(String emailTo,String subject, String message);
}
