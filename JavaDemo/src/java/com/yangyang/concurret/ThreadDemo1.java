package com.yangyang.concurret;

import com.utils.SleepUtils;

public class ThreadDemo1 {
    public static void main(String[] args) {

        System.out.println("main start ... ");

        new FisrtTask();
        new FisrtTask();

        System.out.println("main end ... ");
    }
}
class FisrtTask extends Thread{

    private static int count = 0;
    private int id;

    public FisrtTask(){
        this.id = ++count;
        //this.setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            SleepUtils.sleep1Second();
            System.out.println("< "+id+" >first task !!! " + i);
        }
    }
}
