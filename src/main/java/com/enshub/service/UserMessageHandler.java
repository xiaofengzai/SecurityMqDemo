package com.enshub.service;

import com.enshub.model.User;

import javax.jms.Message;

public class UserMessageHandler extends MessageHandler<User> {
    private static Integer count=0;

    @Override
    public void onMessage(Message message) {
        System.out.println("com");
        User user =getObeject(message);
        System.out.println(user.getUsername());
        if(count++ <1)
            throw new RuntimeException("dd");
    }
}
