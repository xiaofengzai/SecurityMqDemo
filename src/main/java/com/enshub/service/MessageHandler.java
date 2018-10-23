package com.enshub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public  abstract class MessageHandler<T> implements MessageListener {
    @Autowired
    private SimpleMessageConverter simpleMessageConverter;
    protected T getObeject(Message message){
        try {
            return (T)new SimpleMessageConverter().fromMessage(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

}
