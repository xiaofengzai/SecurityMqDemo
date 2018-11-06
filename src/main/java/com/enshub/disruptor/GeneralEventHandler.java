package com.enshub.disruptor;

import com.lmax.disruptor.EventHandler;

public abstract class GeneralEventHandler<T> implements EventHandler<EventData<T>>
{
}