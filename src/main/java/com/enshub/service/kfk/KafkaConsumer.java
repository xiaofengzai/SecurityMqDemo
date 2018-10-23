package com.enshub.service.kfk;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Logger;

public class KafkaConsumer {
    private Logger log=Logger.getLogger(KafkaConsumer.class.getName());

    /**
     * 监听test主题,有消息就读取
     * @param message
     */
    @KafkaListener(topics = {"test"})
    public void consumer(String message){
        log.info("test topic message : {}"+ message);
    }
}
