package com.enshub.service;

import com.enshub.model.User;

import javax.jms.Message;

public class UserMessageHandler extends MessageHandler<User> {

    @Override
    public void onMessage(Message message) {
        User user =getObeject(message);
        System.out.println(user.getUsername());
    }
}
