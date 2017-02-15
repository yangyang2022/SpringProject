package com.yangyang.jvmTest;

class SuperClass{
    static {
        System.out.println("supperclass init!");
    }
    public static int value = 12;
}
class Subclass extends SuperClass{
    static {
        System.out.println("subClass !!!");
    }
}
class ConstClass{
    static {
        System.out.println("constClass ... ");
    }
    public static final String HELLOWORLD = "helloworld";
}

public class TestInit {

    interface inter0{
        int a = 0;
    }
    interface inter1 extends inter0{
        int a = 1;
    }
    interface inter2 {
        int a =2;
    }
    static class Parent implements inter1{
        public static int a = 3;
    }
    static class Sub extends Parent implements inter2{
        public static int a = 4;
    }
    //static {
    //    i = 0;
    //    System.out.println("static i: "+i);
    //}
    //static int i = 2;

    static class DeadLoopClass{
        static {
            System.out.println("threadName: "+Thread.currentThread().getName() +" init ... ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Runnable r = ()->{
            System.out.println(Thread.currentThread().getName() + " start ... ");
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread().getName() + " end ... ");
        };
        new Thread(r).start();
        new Thread(r).start();

        //Thread.sleep(5);

    }
    public static void main1(String[] args) {

        //System.out.println(Subclass.value);
        //new Subclass();
        //new SuperClass();

        //SuperClass[] sca = new SuperClass[10];
        System.out.println(ConstClass.HELLOWORLD);

    }
}
