package com.example.threaddemo;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.SingleThreadedClaimStrategy;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PCDataFactory pcDataFactory = new PCDataFactory();
        int buffSize = 1024;

        Disruptor<PCData> disruptor = new Disruptor<PCData>(pcDataFactory,executorService,new SingleThreadedClaimStrategy(buffSize),new BlockingWaitStrategy());
    }
}
