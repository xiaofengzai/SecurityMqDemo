package com.enshub.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

@Component("AlterServiceImpl")
public class AlterServiceImpl implements AlertService{
    @Autowired
    private JmsOperations jmsOperations;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public <T extends Serializable> void  send(String dest,T message) {
        jmsOperations.send(dest, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(message);
            }
        });
    }


    @Override
    public <T extends Serializable> T  recieve(String dest){
        return (T)jmsOperations.receiveAndConvert(dest);
//        ObjectMessage message=(ObjectMessage) jmsOperations.receive(dest);
//        try {
//            return (T)message.getObject();
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public <T extends Serializable> void rabbitSend(String exchange,String router, T message) {
        if(StringUtils.isEmpty(router)){
            rabbitTemplate.convertAndSend(message);
        }else if(StringUtils.isEmpty(exchange)){
            rabbitTemplate.convertAndSend( router, message);
        }else  {
            rabbitTemplate.convertAndSend(exchange, router, message);
        }
    }

    @Override
    public <T extends Serializable> T rabbitRecieve(String dest) {
        return  (T)rabbitTemplate.receiveAndConvert(dest);
    }

    public void setJmsOperations(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }
}
