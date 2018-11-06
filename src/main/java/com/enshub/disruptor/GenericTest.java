package com.enshub.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GenericTest {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；
//
//        Disruptor<EventData> disruptor = new Disruptor(new GenericEventFactory(),
//                ringBufferSize, executor, ProducerType.SINGLE,
//                new YieldingWaitStrategy());
//        EventHandler<EventData<User>> handler=new UserEventHandler();
//        disruptor.handleEventsWith((EventHandler<? super EventData>) new UserEventHandler());
//
//        disruptor.start();
//
//        RingBuffer<EventData> ringBuffer = disruptor.getRingBuffer();
//        long sequence = ringBuffer.next();//请求下一个事件序号；
//
//        try {
//            EventData event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
////            long data = getEventData();//获取要通过事件传递的业务数据；
//            long data = System.currentTimeMillis();
//            event.setData(new User("wenfneg",12));
//        } finally{
//            ringBuffer.publish(sequence);//发布事件；
//        }
    }
}
