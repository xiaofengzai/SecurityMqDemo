package com.enshub.disruptor;

public  class UserEventHandler extends GeneralEventHandler<User>
{
    @Override
    public void onEvent(EventData<User> userEventData, long l, boolean b) throws Exception {
        System.out.println(userEventData.getData().toString());
    }
}