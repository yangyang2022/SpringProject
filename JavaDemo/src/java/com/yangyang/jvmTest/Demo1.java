package com.yangyang.jvmTest;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws InterruptedException {

        //String s1 = new StringBuilder("com").append("putor").toString();
        //System.out.println(s1.intern() == s1);
        //
        //String s2 = new StringBuilder("te").append("st").toString();
        //System.out.println(s2.intern() == s2);

        //List<String> list = new ArrayList<>();
        //int i = 0;
        //while (true){
        //    list.add(String.valueOf(i++).intern());
        //}

        //Thread.sleep(5000);
        //
        //fillHeap(10000);

        //for (int i = 0; i < 100; ++i) {
        //    new Thread(new DeadLoack(1, 2)).start();
        //    new Thread(new DeadLoack(2, 1)).start();
        //}




    }
    static class DeadLoack implements Runnable{
        int a,b;

        public DeadLoack(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println("a+b: "+(a+b));
                }
            }
        }
    }
    private static void fillHeap(int num) throws InterruptedException {

        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            Thread.sleep(10);
            list.add(new OOMObject());
        }
        System.gc();
    }
    static class OOMObject{
        public byte[] placeHolder = new byte[64*1024];
    }
}
