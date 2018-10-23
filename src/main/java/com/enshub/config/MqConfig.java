package com.enshub.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MqConfig {
    @Bean("amqCoonectionFactory")
    ActiveMQConnectionFactory amqCoonectionFactory(){
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://192.168.1.101:61616");
        factory.setUserName("admin");
        factory.setPassword("admin");
        factory.setTrustAllPackages(true);
        return factory;
    }

    @Bean
    ActiveMQQueue quest(){
        return new ActiveMQQueue("testQueue");
    }

    @Bean
    ActiveMQTopic topic(){
        return new ActiveMQTopic("testTopic");
    }

    @Bean
    JmsTemplate jmsTemplate(){
        return new JmsTemplate(amqCoonectionFactory());
    }

}
