package com.enshub.event;

public class WorkEventListener extends EventAdapterListener<Person> {

     @Override
     void excecute(Person data) {
          System.out.println(data.getName().concat(" is working now"));
     }
}