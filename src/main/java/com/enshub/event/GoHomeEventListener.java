package com.enshub.event;

public class GoHomeEventListener extends EventAdapterListener<Person> {

     @Override
     void excecute(Person data) {
          System.out.println(data.getName().concat(" is going home"));
     }


}