package com.yangyang.jvmTest;

import java.util.concurrent.atomic.LongAdder;

public class VoilateTest {

    public static volatile LongAdder race = new LongAdder();

    public static void inc(){
        race.increment();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; ++i) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; ++j) {
                    inc();
                }
            });
            threads[i].start();
        }

        //wait
        //while (Thread.activeCount() > 1){
        //    Thread.yield();
        //}
        Thread.sleep(2000);

        System.out.println(race);


    }
}
