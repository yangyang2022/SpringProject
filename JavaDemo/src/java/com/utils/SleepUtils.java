package com.utils;

public class SleepUtils {

    public static void sleepMills(long mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleepSeconds(int i){sleepMills(i*1000);}

    public static void sleep1Second(){sleepSeconds(1);}
    public static void sleep2Second(){sleepSeconds(2);}
    public static void sleep3Second(){sleepSeconds(3);}
    public static void sleep4Second(){sleepSeconds(4);}

    public static void sleep300ms(){sleepMills(300);}
    public static void sleep500ms(){sleepMills(500);}
    public static void sleep800ms(){sleepMills(800);}
}
