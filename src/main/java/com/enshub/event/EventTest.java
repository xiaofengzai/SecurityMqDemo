package com.enshub.event;

public class EventTest {
    public static void main(String[] args) {
        EventData<Person> gohome=new EventData<>(EventType.GOHOME,new Person("a 3",15));
        new CommonEventSource<>(gohome).startWorking();
        EventData<Person> work=new EventData<>(EventType.WORKING,new Person("wenfeng",24));
        new CommonEventSource<>(work).startWorking();
    }
}
