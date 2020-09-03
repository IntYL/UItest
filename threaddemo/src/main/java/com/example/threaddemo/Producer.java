package com.example.threaddemo;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class Producer {
    private RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next();

        try {
            PCData pcData = ringBuffer.get(sequence);
            pcData.setValue(bb.getLong(0));
        }finally {
          ringBuffer.publish(sequence);
        }



    }
}
