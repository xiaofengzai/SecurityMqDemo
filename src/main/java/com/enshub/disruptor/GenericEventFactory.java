package com.enshub.disruptor;

import com.lmax.disruptor.EventFactory;

public class GenericEventFactory implements EventFactory<EventData> {
    @Override
    public EventData newInstance() {
        return new EventData();
    }
}
