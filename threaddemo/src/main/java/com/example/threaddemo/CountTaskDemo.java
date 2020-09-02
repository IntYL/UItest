package com.example.threaddemo;

import android.util.Log;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class CountTaskDemo {
    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0,100000L);
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(countTask);
        try {
            long result = forkJoinTask.get();
            System.out.println("yaolei "+String.valueOf(result));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
