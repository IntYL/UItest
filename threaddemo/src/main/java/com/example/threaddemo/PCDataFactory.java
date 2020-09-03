package com.example.threaddemo;

import com.lmax.disruptor.EventFactory;

public class PCDataFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new PCData();
    }
}
