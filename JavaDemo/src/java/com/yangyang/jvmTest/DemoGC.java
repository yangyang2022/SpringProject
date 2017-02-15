package com.yangyang.jvmTest;

public class DemoGC {

    public static void sayHello(){
        System.out.println("hello world");
    }
    public void hello(){
        System.out.println("dynamic hello");
    }
    public static void main(String[] args) {
        sayHello();
        new DemoGC().hello();

    }

}
