package com.enshub.service;

import java.io.Serializable;

public interface AlertService {
    <T extends  Serializable> void  send(String dest, T message);
    <T extends Serializable> T  recieve(String dest);
    <T extends  Serializable> void  rabbitSend(String exchange,String router, T message);
    <T extends Serializable> T  rabbitRecieve(String dest);
}
