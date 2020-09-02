package com.example.threaddemo;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {
    private final static long THRESHOLD = 10000;
    private long start = 0l;
    private long end = 0l;

    public CountTask(long start,long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum =0L;
        boolean canCompute = (start -end) < THRESHOLD;
        if (canCompute){
            for (long i = start ;i< end; i++){
                sum +=i;
            }
        }else {
         long step = (start + end)/100;
            ArrayList<CountTask> countTaskArrayList = new ArrayList<>();
            long pos = start;
         for (int i = 0; i < 100;i++){
            long lastOne = pos+ step;
            if (lastOne > end){
                lastOne = end;
            }
            CountTask countTask = new CountTask(pos,lastOne);
            pos +=step+1;
            countTaskArrayList.add(countTask);
            countTask.fork();
         }

         for (CountTask item : countTaskArrayList){
             sum += item.join();
         }
        }
        return sum;
    }
}
