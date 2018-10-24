package com.enshub.event;

public class HiEventListener extends EventAdapterListener<Person> {

     @Override
     void excecute(Person data) {
          System.out.println("hi"+data.getName());
     }
}