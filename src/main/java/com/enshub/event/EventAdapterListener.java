package com.enshub.event;

import java.util.EventListener;

public  abstract class EventAdapterListener<T> implements EventListener {
     protected  void action(CommonEventObject event){
         T data=(T)event.getSource().getData();
         excecute(data);
     }
     abstract  void  excecute(T data);
}