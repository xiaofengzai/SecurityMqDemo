package com.enshub.disruptor;

public class EventData<T> {
    private EventType type;
    private T data;


    public EventData(EventType type, T data) {
        this.type = type;
        this.data = data;
    }

    public EventData() {

    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
