package com.enshub.event;

import java.util.EventObject;

public class CommonEventObject<T> extends EventObject {

    private static final long serialVersionUID = 1L;
    private EventData<T> source;

    public CommonEventObject(EventData source ){
         super(source);
         this.source=source;
     }

    @Override
    public EventData getSource() {
        return source;
    }

    public void setSource(EventData source) {
        this.source = source;
    }
}
