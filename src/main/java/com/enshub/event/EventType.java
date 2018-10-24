package com.enshub.event;

public enum EventType {
    GOHOME(1,"回家",new Class[]{HiEventListener.class,GoHomeEventListener.class}),
    WORKING(2,"工作",new Class[]{HiEventListener.class,WorkEventListener.class})
    ;

    EventType(int value, String name, Class<? extends EventAdapterListener>[]listeners) {
        this.value = value;
        this.name = name;
        this.listeners = listeners;
    }

    private int value;
    private String name;
    private Class<? extends EventAdapterListener>[]listeners;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Class<? extends EventAdapterListener>[] getListeners() {
        return listeners;
    }
}
