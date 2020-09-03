package com.example.threaddemo;

import com.lmax.disruptor.WorkHandler;

public class Cosumer implements WorkHandler<PCData>{
    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println("Thread "+Thread.currentThread().getId()+" onEvent():"+event.getValue()*event.getValue());
    }
}
