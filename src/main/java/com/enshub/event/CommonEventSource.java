package com.enshub.event;

public class CommonEventSource<T> {
    private EventData<T> eventData;

    public CommonEventSource(EventData<T> eventData) {
        this.eventData = eventData;
    }

    public void startWorking() {
        Class[] classes=eventData.getType().getListeners();
        for(int i=0,len=classes.length;i<len;i++){
            EventAdapterListener listener=null;

            try {
                listener = (EventAdapterListener)  classes[i].newInstance(); //频繁可考虑加缓存
                listener.action(new CommonEventObject(eventData));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

}
